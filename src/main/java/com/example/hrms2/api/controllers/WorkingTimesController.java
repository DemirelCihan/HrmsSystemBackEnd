package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.WorkingTimeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {
private WorkingTimeService workingTimeService;
@Autowired
    public WorkingTimesController(WorkingTimeService workingTimeService){
    this.workingTimeService = workingTimeService;
}

@PostMapping("/add")
public Result add(@RequestBody WorkingTime workingTime){
    return this.workingTimeService.add(workingTime);
}
@PutMapping("/update")
    public Result update(@RequestBody WorkingTime workingTime){
    return this.workingTimeService.update(workingTime);
}
@DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
  return this.workingTimeService.delete(id);
}

@GetMapping("/getAll")
    public DataResult<List<WorkingTime>> getAll(){
    return this.workingTimeService.getAll();
}
@GetMapping("/getById")
    public DataResult<WorkingTime> getById(@RequestParam int id){
    return this.workingTimeService.getById(id);
}

}
