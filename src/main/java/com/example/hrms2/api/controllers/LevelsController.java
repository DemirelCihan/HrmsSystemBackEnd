package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.LevelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/levels")
@CrossOrigin
public class LevelsController {
private LevelService levelService;
@Autowired
    public LevelsController(LevelService levelService){
    this.levelService = levelService;
}
    @PostMapping("/add")
    public Result add(@RequestBody Level level) {
        return this.levelService.add(level);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Level level) {
        return this.levelService.update(level);
    }

    @GetMapping("/getAll")
    public DataResult<List<Level>> getAll() {
        return this.levelService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Level> getById(@RequestParam int id) {
        return this.levelService.getById(id);
    }

}
