package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.CoverLetterService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.CoverLetterDao;
import com.example.hrms2.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverLetterManager implements CoverLetterService {

    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao){
        this.coverLetterDao = coverLetterDao;
    }
    @Override
    public Result add(CoverLetter coverLetter){
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Yeni bir ön yazı eklendi.");
    }

    @Override
    public Result update(CoverLetter coverLetter) {
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Ön yazı güncellenmesi gerçekleşti.");

    }

    @Override
    public Result delete(int id) {
        coverLetterDao.deleteById(id);
        return new SuccessResult("Ön yazı silindi");
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>
                (this.coverLetterDao.findAll());//tüm önyazıların listeleme işlemi
    }

    @Override
    public DataResult<CoverLetter> getById(int id) {
        return new SuccessDataResult<CoverLetter>
                (this.coverLetterDao.getById(id));
    }

    @Override
    public DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<List<CoverLetter>>
                (this.coverLetterDao.getByCandidate_Id(candidateId));

    }
}
