package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.ResumeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Resume;
import com.example.hrms2.entities.dtos.ResumeWithEntitiesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin
public class ResumesController {

    private ResumeService resumeService;

    @Autowired
    public ResumesController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Resume resume){
        return this.resumeService.add(resume);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Resume resume){
        return this.resumeService.update(resume);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.resumeService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Resume> getById(@RequestParam int id){
        return this.resumeService.getById(id);
    }

    @PostMapping("/addCoverLetterToResume")
    public Result addCoverLetterToResume(@RequestParam int resumeId, @RequestParam int coverLetterId ){
        return this.resumeService.addCoverLetterToResume(resumeId,coverLetterId);
    }

    @DeleteMapping("/deleteCoverLetterFromResume")
    public Result deleteCoverLetterFromResume(@RequestParam int resumeId){
        return this.resumeService.deleteCoverLetterFromResume(resumeId);
    }
    @GetMapping("/getAllResumesDetailsByActivatedCandidate")
    public DataResult<List<ResumeWithEntitiesDto>> getAllResumesDetailsByActivatedCandidate() {
        return this.resumeService.getAllResumeDetailsByActivatedCandidate();
    }

    @GetMapping("/getResumeDetailsByCandidateId")
    public DataResult<ResumeWithEntitiesDto> getResumeDetailsByCandidateId(@RequestParam int candidateId) {
        return this.resumeService.getResumeDetailsByCandidateId(candidateId);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<Resume> getByCandidateId(@RequestParam int candidateId) {
        return this.resumeService.getByCandidateId(candidateId);
    }


}
