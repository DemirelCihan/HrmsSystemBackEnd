package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.CityService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

    private CityService cityService;
    @Autowired
    public CitiesController(CityService cityService){
        this.cityService = cityService;
    }
    @PostMapping("/add")
    public Result add(@RequestBody City city){
        return this.cityService.add(city);
    }

    @PutMapping("update")
    public Result update(@RequestBody City city){
        return this.cityService.update(city);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
        return this.cityService.delete(id);
    }

     @GetMapping("/getAll")
    public DataResult<List<City>> getAll(){
        return this.cityService.getAll();
     }

     @GetMapping("/getById")
    public DataResult<City> getById(int id){
        return this.cityService.getById(id);
     }

}
