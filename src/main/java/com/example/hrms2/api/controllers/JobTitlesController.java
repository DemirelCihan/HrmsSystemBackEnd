package com.example.hrms2.api.controllers;


import com.example.hrms2.business.abstracts.JobTitleService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobTitles")
@CrossOrigin
public class JobTitlesController {
private JobTitleService jobTitleService;
@Autowired
    public JobTitlesController(JobTitleService jobTitleService){
    this.jobTitleService = jobTitleService;
}
@PostMapping("/add")
    public Result add(@RequestBody JobTitle jobTitle){
    return this.jobTitleService.add(jobTitle);
}
@PutMapping("update")
    public Result update(@RequestBody JobTitle jobTitle){
    return this.jobTitleService.update(jobTitle);
}

@GetMapping("/getAll")
    public DataResult<List<JobTitle>> getAll(){
    return this.jobTitleService.getAll();
}

@GetMapping("/getById")
    public DataResult<JobTitle> getById(@RequestParam int id){
    return this.jobTitleService.getById(id);
}

}
