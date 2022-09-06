package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.UpdatedEmployerService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UpdatedEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/updatedEmployers")
@CrossOrigin
public class UpdatedEmployersController {
    private UpdatedEmployerService updatedEmployerService;
    @Autowired
    public UpdatedEmployersController(UpdatedEmployerService updatedEmployerService) {
        this.updatedEmployerService = updatedEmployerService;
    }
    @GetMapping("/getAll")
    public DataResult<List<UpdatedEmployer>> getAll() {
        return this.updatedEmployerService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<UpdatedEmployer> getById(@RequestParam int id) {
        return this.updatedEmployerService.getById(id);
    }

    @GetMapping("/getByEmployerId")
    public DataResult<UpdatedEmployer> getByEmployerId(@RequestParam int employerId) {
        return this.updatedEmployerService.getByEmployerId(employerId);
    }

}
