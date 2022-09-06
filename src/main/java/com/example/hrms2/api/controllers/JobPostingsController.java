package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.JobPostingService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostings")
@CrossOrigin
public class JobPostingsController {
private JobPostingService jobPostingService;
@Autowired
    public JobPostingsController(JobPostingService jobPostingService){
    this.jobPostingService = jobPostingService;
}

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting) {
        return this.jobPostingService.add(jobPosting);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPosting>> getAll() {
        return this.jobPostingService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPosting> getById(@RequestParam int id) {
        return this.jobPostingService.getById(id);
    }

    @PutMapping("/confirm")
    public Result confirm(@RequestParam int jobPostingId, @RequestParam int companyStaffId, @RequestParam int jobPostingConfirmationTypeId, @RequestParam boolean isConfirmed) {
        return this.jobPostingService.confirm(jobPostingId, companyStaffId, jobPostingConfirmationTypeId, isConfirmed);
    }

    @PutMapping("/makeActiveOrPassive")
    public Result makeActiveOrPassive(@RequestParam int id, @RequestParam boolean isActive) {
        return this.jobPostingService.makeActiveOrPassive(id, isActive);
    }

    @GetMapping("/getAllByIsActive")
    public DataResult<List<JobPosting>> getAllByIsActive(@RequestParam boolean isActive) {
        return this.jobPostingService.getAllByIsActive(isActive);
    }

    @GetMapping("/getAllActiveOnesByPage")
    public DataResult<List<JobPosting>> getAllActiveOnesByPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return this.jobPostingService.getAllActiveOnesByPage(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDate")
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDate() {
        return this.jobPostingService.getAllActiveOnesSortedByPostingDate();
    }

    @GetMapping("/getAllActiveOnesByPageSortedByPostingDate")
    public DataResult<List<JobPosting>> getAllActiveOnesByPageSortedByPostingDate(@RequestParam int pageNo,	@RequestParam int pageSize) {
        return this.jobPostingService.getAllActiveOnesByPageSortedByPostingDate(pageNo, pageSize);
    }

    @GetMapping("/getAllActiveOnesSortedByPostingDateTop6")
    public DataResult<List<JobPosting>> getAllActiveOnesSortedByPostingDateTop6() {
        return this.jobPostingService.getAllActiveOnesSortedByPostingDateTop6();
    }

    @GetMapping("/getAllActiveOnesByEmployerIdSortedByPostingDate")
    public DataResult<List<JobPosting>> getAllActiveOnesByEmployerIdSortedByPostingDate(@RequestParam int employerId) {
        return this.jobPostingService.getAllActiveOnesByEmployerIdSortedByPostingDate(employerId);
    }

    @GetMapping("/getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType")
    public DataResult<List<JobPosting>> getAllActiveOnesFilteredByWorkingTimeAndWorkingTypeAndCityAndJobTitle(@RequestParam int cityId, @RequestParam int jobTitleId,
                                                                                                              @RequestParam int workingTimeId, @RequestParam int workingTypeId) {
        return this.jobPostingService.getAllActiveOnesFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(cityId, jobTitleId, workingTimeId, workingTypeId);
    }

    @GetMapping("/getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType")
    public DataResult<List<JobPosting>> getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(@RequestParam int cityId, @RequestParam int jobTitleId,
                                                                                                                    @RequestParam int workingTimeId, @RequestParam int workingTypeId, @RequestParam int pageNo, @RequestParam int pageSize) {
        return this.jobPostingService.getAllActiveOnesByPageFilteredByCityAndJobTitleAndWorkingTimeAndWorkingType(cityId, jobTitleId, workingTimeId, workingTypeId, pageNo, pageSize);
    }

    @GetMapping("/getAllOnesThatWaitingForPostingConfirmation")
    public DataResult<List<JobPosting>> getAllOnesThatWaitingForPostingConfirmation() {
        return this.jobPostingService.getAllOnesThatWaitingForPostingConfirmation();
    }
}
