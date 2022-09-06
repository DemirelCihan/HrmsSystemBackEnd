package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.LinkNameService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.LinkName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/linkNames")
@CrossOrigin
public class LinkNamesController {
private LinkNameService linkNameService;
@Autowired
    public LinkNamesController(LinkNameService linkNameService){
    this.linkNameService = linkNameService;
}

    @PostMapping("/add")
    public Result add(@RequestBody LinkName linkName) {
        return this.linkNameService.add(linkName);
    }

    @PutMapping("/update")
    public Result update(@RequestBody LinkName linkName) {
        return this.linkNameService.update(linkName);
    }

    @GetMapping("/getAll")
    public DataResult<List<LinkName>> getAll() {
        return this.linkNameService.getAll();
    }

    @GetMapping("getById")
    public DataResult<LinkName> getById(@RequestParam int id) {
        return this.linkNameService.getById(id);
    }
}
