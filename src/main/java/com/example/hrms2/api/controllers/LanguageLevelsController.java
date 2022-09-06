package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.LanguageLevelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languageLevels")
@CrossOrigin
public class LanguageLevelsController {
private LanguageLevelService languageLevelService;
@Autowired
    public LanguageLevelsController(LanguageLevelService languageLevelService){
    this.languageLevelService = languageLevelService;
}
@PostMapping("/add")
    public Result add(@RequestBody LanguageLevel languageLevel){
    return this.languageLevelService.add(languageLevel);
}
@PutMapping("/update")
    public Result update(@RequestBody LanguageLevel languageLevel){
    return this.languageLevelService.update(languageLevel);
}
@DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
    return this.languageLevelService.delete(id);
}
@GetMapping("/getAll")
    public DataResult<List<LanguageLevel>> getAll(){
    return this.languageLevelService.getAll();
}
    @GetMapping("/getById")
    public DataResult<LanguageLevel> getById(@RequestParam int id) {
        return languageLevelService.getById(id);
    }

}
