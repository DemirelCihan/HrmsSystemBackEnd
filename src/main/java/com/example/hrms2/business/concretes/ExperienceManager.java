package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.ExperienceService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.ExperienceDao;
import com.example.hrms2.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao){
        this.experienceDao = experienceDao;
    }

    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("İş deneyimi eklendi.");
    }

    @Override
    public Result update(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("İş deneyimi günecllendi");
    }

    @Override
    public Result delete(int id) {
        this.experienceDao.deleteById(id);
        return new SuccessResult("İş deneyimi silindi");
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>
                (this.experienceDao.findAll());
    }

    @Override
    public DataResult<Experience> getById(int id) {
        return new SuccessDataResult<Experience>
                (this.experienceDao.getById(id));
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Experience>>
                (this.experienceDao.getByResume_Id(resumeId));
        //tüm özgeçmiş id numaralarını toplayacaktır.
    }

    @Override
    public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "terminationDate");
        //adayların iş tecrübelerinin sıralanması yıla göre tersten olmalıdır.
        return new SuccessDataResult<List<Experience>>
                (this.experienceDao.getByResume_Id(resumeId,sort));
    }
}
