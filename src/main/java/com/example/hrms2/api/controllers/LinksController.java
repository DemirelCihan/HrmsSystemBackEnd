package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.LinkService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/links")
@CrossOrigin
public class LinksController {
private LinkService linkService;
@Autowired
    LinksController(LinkService linkService){
    this.linkService = linkService;
}
    @PostMapping("/add")
    public Result add(@RequestBody Link link) {
        return this.linkService.add(link);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Link link) {
        return this.linkService.update(link);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return this.linkService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Link>> getAll() {
        return this.linkService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Link> getById(@RequestParam int id) {
        return this.linkService.getById(id);
    }

}
