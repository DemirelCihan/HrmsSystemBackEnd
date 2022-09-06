package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.CandidateService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {

    private CandidateService candidateService;
    @Autowired
    public CandidatesController(CandidateService candidateService){
        this.candidateService = candidateService;

    }
    @PutMapping("/update")//PutMapping yöntemi kaynağı güncellemek için kullanılır.
    public Result update(@RequestBody Candidate candidate){
        return this.candidateService.update(candidate);
    }

    @GetMapping("/getAll")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Candidate> getById(@RequestParam int id){
        return this.candidateService.getById(id);
    }

    @PutMapping("/activate")
    public Result activate(@RequestParam String code){
        return this.candidateService.activate(code);
    }

    @GetMapping("/getAllByIsActivated")
    public DataResult<List<Candidate>> getAllByIsActivated (@RequestParam boolean isActivated){
        return candidateService.getAllByIsActivated(isActivated);
    }
}
