package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.JobPostingConfirmationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.JobPostingConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostingConfirmations")
@CrossOrigin
public class JobPostingConfirmationsController {
private JobPostingConfirmationService jobPostingConfirmationService;

@Autowired
    public JobPostingConfirmationsController(JobPostingConfirmationService jobPostingConfirmationService){
    this.jobPostingConfirmationService = jobPostingConfirmationService;
}

    @GetMapping("/getAll")
    public DataResult<List<JobPostingConfirmation>> getAll() {
        return this.jobPostingConfirmationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPostingConfirmation> getById(@RequestParam int id) {
        return this.jobPostingConfirmationService.getById(id);
    }

    @GetMapping("/getByJobPostingId")
    public DataResult<JobPostingConfirmation> getByJobPostingId(@RequestParam int jobPostingId) {
        return this.jobPostingConfirmationService.getByJobPostingId(jobPostingId);
    }
}
