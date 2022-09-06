package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.EmployerService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {
    private EmployerService employerService;
    @Autowired
    public EmployersController(EmployerService employerService){
        this.employerService = employerService;
    }
    @PutMapping("/update")
    public Result update(@RequestBody Employer employer){
        return this.employerService.update(employer);
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("getById")
    public DataResult<Employer> getById(@RequestParam int id) {
        return employerService.getById(id);
    }
    @PutMapping("/activate")
    public Result activate(@RequestParam String code) {
        return employerService.activate(code);
    }

    @PutMapping("/confirm")
    public Result confirm(@RequestParam int employerId, @RequestParam int companyStaffId, @RequestParam int userConfirmationTypeId, @RequestParam boolean isConfirmed) {
        return employerService.confirm(employerId, companyStaffId, userConfirmationTypeId, isConfirmed);
    }

    @GetMapping("/getAllOnesThatWaitingForAccountConfirmation")
    public DataResult<List<Employer>> getAllOnesThatWaitingForAccountConfirmation() {
        return employerService.getAllOnesThatWaitingForAccountConfirmation();
    }

    @GetMapping("/getAllOnesThatWaitingForUpdateConfirmation")
    public DataResult<List<Employer>> getAllOnesThatWaitingForUpdateConfirmation() {
        return employerService.getAllOnesThatWaitingForUpdateConfirmation();
    }

    @GetMapping("/getAllByIsActivated")
    public DataResult<List<Employer>> getAllByIsActivated(@RequestParam boolean isActivated) {
        return employerService.getAllByIsActivated(isActivated);
    }

    @GetMapping("/getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName")
    public DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName(@RequestParam boolean isConfirmed, @RequestParam int userConfirmationTypeId) {
        return employerService.getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName(isConfirmed, userConfirmationTypeId);
    }

    @GetMapping("/getOneThatWaitingForUpdateConfirmationById")
    public DataResult<Employer> getOneThatWaitingForUpdateConfirmationById(@RequestParam int id) {
        return employerService.getOneThatWaitingForUpdateConfirmationById(id);
    }





}
