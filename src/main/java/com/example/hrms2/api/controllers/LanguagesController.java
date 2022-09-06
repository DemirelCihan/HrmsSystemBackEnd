package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.LanguageService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguagesController {
private LanguageService languageService;
@Autowired
    public LanguagesController(LanguageService languageService){
    this.languageService = languageService;
}

    @PostMapping("/add")
    public Result add(@RequestBody Language language) {
        return this.languageService.add(language);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Language language) {
        return this.languageService.update(language);
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Language> getById(@RequestParam int id) {
        return this.languageService.getById(id);
    }

}
