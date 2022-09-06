package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.WorkingTypeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypesController {
private WorkingTypeService workingTypeService;
@Autowired
    public WorkingTypesController(WorkingTypeService workingTypeService){
    this.workingTypeService = workingTypeService;
}
@PostMapping("/add")
    public Result add(@RequestBody WorkingType workingType){
    return this.workingTypeService.add(workingType);
}
@PutMapping("/update")
    public Result update(@RequestBody WorkingType workingType){
    return this.workingTypeService.update(workingType);
}

@DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
    return this.workingTypeService.delete(id);
}

@GetMapping("/getAll")
    public DataResult<List<WorkingType>> getAll(){
    return this.workingTypeService.getAll();
}

@GetMapping("/getById")
    public DataResult<WorkingType> getById(@RequestParam int id){
    return this.workingTypeService.getById(id);
}

}
