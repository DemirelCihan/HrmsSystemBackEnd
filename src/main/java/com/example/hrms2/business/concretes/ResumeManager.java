package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.*;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.ResumeDao;
import com.example.hrms2.entities.concretes.Resume;
import com.example.hrms2.entities.dtos.ResumeWithEntitiesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;
    private CoverLetterService coverLetterService;
    private ImageService imageService;
    private EducationService educationService;
    private ExperienceService experienceService;


    @Autowired
    public ResumeManager(ResumeDao resumeDao,CoverLetterService coverLetterService,ImageService imageService, EducationService educationService, ExperienceService experienceService){
        this.resumeDao = resumeDao;
        this.coverLetterService = coverLetterService;
        this.imageService = imageService;
        this.educationService = educationService;
        this.experienceService = experienceService;
    }


    @Override
    public Result add(Resume resume) {

        resume.setCreationDate(LocalDateTime.now());
        this.resumeDao.save(resume);
        return new SuccessResult("Yeni bir özgeçmiş eklendi.");
    }

    @Override
    public Result update(Resume resume) {
        resume = getById(resume.getId()).getData();
        resume.setCreationDate(LocalDateTime.now());

        this.resumeDao.save(resume);
        return new SuccessResult("Özgeçmiş güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.resumeDao.deleteById(id);
        return new SuccessResult("Özgeçmiş silindi");
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        Sort sort = Sort.by(Sort.Direction.DESC,"creationDate");
        //özgeçmişler sıralama tarihlerine göre sıralanmış olacaktıdr.
        return new SuccessDataResult<List<Resume>>
                (this.resumeDao.findAll(sort));
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return new SuccessDataResult<Resume>
                (this.resumeDao.getById(id));
    }


    @Override
    public Result addCoverLetterToResume(int resumeId, int coverLetterId) {
      Resume resume = getById(resumeId).getData();
      resume.setCoverLetter(coverLetterService.getById(coverLetterId).getData());

      update(resume);
        return new SuccessResult("Ön yazı özgeçmişe eklendi.");
    }

    @Override
    public Result deleteCoverLetterFromResume(int resumeId) {
       Resume resume = getById(resumeId).getData();
       resume.setCoverLetter(null);

       update(resume);
        return new SuccessResult("Ön yazı özgeçmişten kaldırıldı.");
    }

    @Override
    public DataResult<List<ResumeWithEntitiesDto>> getAllResumeDetailsByActivatedCandidate() {
     List<ResumeWithEntitiesDto> resumes = new ArrayList<ResumeWithEntitiesDto>();
        for (Resume resume : getAll().getData()) {
            if (resume.getCandidate().getUserActivation().isActivated() == true ) {
                resumes.add(getResumeDetailsByCandidateId(resume.getCandidate().getId()).getData());
            }
        }
        return new SuccessDataResult<List<ResumeWithEntitiesDto>>
                (resumes);
    }

    @Override
    public DataResult<Resume> getByCandidateId(int candidateId) {
        return new SuccessDataResult<Resume>
                (this.resumeDao.getByCandidate_Id(candidateId));
    }

    @Override
    public DataResult<ResumeWithEntitiesDto> getResumeDetailsByCandidateId(int candidateId) {

        Resume resume = getByCandidateId(candidateId).getData();

        ResumeWithEntitiesDto resumeWithEntitiesDto = new ResumeWithEntitiesDto(
         resume.getId(),
         resume.getCreationDate(),
         resume.getCandidate(),
         resume.getCoverLetter(),
         imageService.getByUserId(candidateId).getData(),
         educationService.getAllByResumeIdSortedByGraduationDate(resume.getId()).getData(),
         experienceService.getAllByResumeIdSortedByTerminationDate(resume.getId()).getData(),
         resume.getLanguageLevels(),
         resume.getLinks(),
         resume.getSkills()
        );
        return new SuccessDataResult<ResumeWithEntitiesDto>
                (resumeWithEntitiesDto);
    }
}
