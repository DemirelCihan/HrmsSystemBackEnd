package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationService extends BaseEntityService<JobPostingConfirmation>{

    DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId);

}
