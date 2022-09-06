package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.CoverLetterService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/coverLetters")
@CrossOrigin
public class CoverLettersController {
    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService){
        this.coverLetterService = coverLetterService;
    }
    //ekleme işlemleri için
    @PostMapping("/add")
    public Result add(@RequestBody CoverLetter coverLetter){
        return this.coverLetterService.add(coverLetter);
    }

    //güncelleme işlemleri için
    @PutMapping("/update")
    public Result update(@RequestBody CoverLetter coverLetter){
        return this.coverLetterService.update(coverLetter);
    }

    //silme işlemleri için
    @DeleteMapping("/delete")
    public Result delete (@RequestParam int id){
        return this.coverLetterService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<CoverLetter>> getAll(){
        return this.coverLetterService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<CoverLetter> getById(@RequestParam int id){
        return this.coverLetterService.getById(id);
    }

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<CoverLetter>> getAllByCandidateId(@RequestParam int candidateId){
        return this.coverLetterService.getAllByCandidateId(candidateId);
    }

}
