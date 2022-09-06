package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.CompanyPersonnelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.CompanyPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companyPersonnels")
@CrossOrigin
public class CompanyPersonnelController {
private CompanyPersonnelService companyPersonnelService;
@Autowired
    public CompanyPersonnelController(CompanyPersonnelService companyPersonnelService){
    this.companyPersonnelService =  companyPersonnelService;
}
@PutMapping("/update")
    public Result update(@RequestBody CompanyPersonnel companyPersonnel){
    return this.companyPersonnelService.update(companyPersonnel);
}
@GetMapping("/getAll")
    public DataResult<List<CompanyPersonnel>> getAll(){
    return this.companyPersonnelService.getAll();
}
@GetMapping("/getById")
    public DataResult<CompanyPersonnel> getById(@RequestParam int id){
    return this.companyPersonnelService.getById(id);
}

}
