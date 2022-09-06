package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.UserActivationService;
import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userActivations")
@CrossOrigin
public class UserActivationsController {

private UserActivationService userActivationService;

@Autowired
    public UserActivationsController(UserActivationService userActivationService){
    this.userActivationService = userActivationService;
}

@GetMapping("/getAll")
    public DataResult<List<UserActivation>> getAll(){
    return this.userActivationService.getAll();
}

@GetMapping("/getById")
    public DataResult<UserActivation> getById(@RequestParam int id){
    return this.userActivationService.getById(id);
}

@GetMapping("/getByUserId")
    public DataResult<UserActivation> getByUserId(@RequestParam int userId){
    return this.userActivationService.getByUserId(userId);
}

@GetMapping("/getAllByIsActivated")
    public DataResult<List<UserActivation>> getAllByIsActivated(@RequestParam boolean isActivated){
    return this.userActivationService.getAllByIsActivated(isActivated);
}

}
