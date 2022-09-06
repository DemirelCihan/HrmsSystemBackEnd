package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.JobPostingConfirmationTypeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.JobPostingConfirmationTypeDao;
import com.example.hrms2.entities.concretes.JobPostingConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Table;
import java.util.List;

@Service
public class JobPostingConfirmationTypeManager implements JobPostingConfirmationTypeService {
    private JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao;
    @Autowired
    public JobPostingConfirmationTypeManager(JobPostingConfirmationTypeDao jobPostingConfirmationTypeDao){
        this.jobPostingConfirmationTypeDao = jobPostingConfirmationTypeDao;
    }
    @Override
    public Result add(JobPostingConfirmationType jobPostingConfirmationType) {
        return new SuccessResult("İş ilanı onay tipi eklendi");
    }

    @Override
    public Result update(JobPostingConfirmationType jobPostingConfirmationType) {
        return new SuccessResult("İş ilanı onay tipi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        return new SuccessResult("İş ilanı onay tipi silindi.");
    }

    @Override
    public DataResult<List<JobPostingConfirmationType>> getAll() {
        return new SuccessDataResult<List<JobPostingConfirmationType>>
                (this.jobPostingConfirmationTypeDao.findAll());
    }

    @Override
    public DataResult<JobPostingConfirmationType> getById(int id) {
        return new SuccessDataResult<JobPostingConfirmationType>
                (this.jobPostingConfirmationTypeDao.getById(id));
    }

}
