package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.SkillService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {

    private SkillService skillService;
    @Autowired
    public SkillsController(SkillService skillService){
        this.skillService = skillService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Skill skill){
        return this.skillService.add(skill);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Skill skill){
        return this.skillService.update(skill);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.skillService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Skill>> getAll(){
        return this.skillService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Skill> getById(@RequestParam int id){
        return this.skillService.getById(id);
    }
}
