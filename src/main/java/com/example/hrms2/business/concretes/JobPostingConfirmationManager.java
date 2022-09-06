package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.EmailService;
import com.example.hrms2.business.abstracts.JobPostingConfirmationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.JobPostingConfirmationDao;
import com.example.hrms2.entities.concretes.JobPostingConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JobPostingConfirmationManager implements JobPostingConfirmationService {
    private JobPostingConfirmationDao jobPostingConfirmationDao;
    private EmailService emailService;
    @Autowired
    public JobPostingConfirmationManager(JobPostingConfirmationDao jobPostingConfirmationDao,
                                         EmailService emailService){
        this.jobPostingConfirmationDao = jobPostingConfirmationDao;
        this.emailService = emailService;

    }
    @Override
    public Result add(JobPostingConfirmation jobPostingConfirmation) {
    jobPostingConfirmation.setIsConfirmedDate(LocalDateTime.now());
    this.jobPostingConfirmationDao.save(jobPostingConfirmation);
    emailService.sendEmail(jobPostingConfirmation.getJobPosting().getEmployer());
        return new SuccessResult();
    }

    @Override
    public Result update(JobPostingConfirmation jobPostingConfirmation) {
        this.jobPostingConfirmationDao.save(jobPostingConfirmation);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {

        this.jobPostingConfirmationDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<JobPostingConfirmation>> getAll() {
        return new SuccessDataResult<List<JobPostingConfirmation>>
                (this.jobPostingConfirmationDao.findAll());
    }

    @Override
    public DataResult<JobPostingConfirmation> getById(int id) {
        return new SuccessDataResult<JobPostingConfirmation>
                (this.jobPostingConfirmationDao.getById(id));
    }

    @Override
    public DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId) {
        return new SuccessDataResult<JobPostingConfirmation>
                (this.jobPostingConfirmationDao.getByJobPosting_Id(jobPostingId));
    }
}
