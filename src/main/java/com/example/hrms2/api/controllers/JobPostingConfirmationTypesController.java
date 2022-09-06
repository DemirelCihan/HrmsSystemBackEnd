package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.JobPostingConfirmationTypeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.JobPostingConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobPostingConfirmationTypes")
@CrossOrigin
public class JobPostingConfirmationTypesController {
    private JobPostingConfirmationTypeService jobPostingConfirmationTypeService;
    @Autowired
    public JobPostingConfirmationTypesController(JobPostingConfirmationTypeService jobPostingConfirmationTypeService){
        this.jobPostingConfirmationTypeService = jobPostingConfirmationTypeService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody JobPostingConfirmationType jobPostingConfirmationType){
        return this.jobPostingConfirmationTypeService.add(jobPostingConfirmationType);
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobPostingConfirmationType jobPostingConfirmationType) {
        return this.jobPostingConfirmationTypeService.update(jobPostingConfirmationType);
    }

    @GetMapping("/getAll")
    public DataResult<List<JobPostingConfirmationType>> getAll() {
        return this.jobPostingConfirmationTypeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<JobPostingConfirmationType> getById(@RequestParam int id) {
        return this.jobPostingConfirmationTypeService.getById(id);
    }


}
