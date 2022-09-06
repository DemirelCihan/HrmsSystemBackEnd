package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.EducationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin
public class EducationsController {
    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService){
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Education education){
        return this.educationService.update(education);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.educationService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Education> getById(@RequestParam int id){
        return this.educationService.getById(id);
    }

    @GetMapping("/getAllByResumeIdSortedByGraduationDate")
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(@RequestParam int resumeId){
        return this.educationService.getAllByResumeIdSortedByGraduationDate(resumeId);
    }


}
