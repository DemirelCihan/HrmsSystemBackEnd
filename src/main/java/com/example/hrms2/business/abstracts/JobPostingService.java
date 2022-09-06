package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.JobPosting;
import com.example.hrms2.entities.concretes.JobTitle;

import java.util.List;

public interface JobPostingService  extends  BaseEntityService<JobPosting>{

    Result confirm(int employerId, int companyStaffId, int jobPostingConfirmationTypeId, boolean isConfirmed);

    Result makeActiveOrPassive(int id, boolean isActive);

    DataResult<List<JobPosting>> getAllByIsActive(boolean isActive);

    DataResult<List<JobPosting>> getAllActiveOnesByPage(int pageNo, int pageSize);

    DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate();

    DataResult<List<JobPosting>> getAllActiveOnesByPageSortedByPostingDate(int pageNo, int pageSize);

    DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDateTop6();

    DataResult<List<JobPosting>> getAllActiveOnesByEmployerIdSortedByPostingDate(int employerId);

    DataResult<List<JobPosting>> getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId);

    DataResult<List<JobPosting>> getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(int cityId, int jobTitleId, int workingTimeId, int workingTypeId, int pageNo, int pageSize);

    DataResult<List<JobPosting>> getAllOnesThatWaitingForPostingConfirmation();


}
