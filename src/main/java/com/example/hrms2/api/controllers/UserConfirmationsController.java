package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.UserConfirmationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userConfirmations")
@CrossOrigin
public class UserConfirmationsController {
private UserConfirmationService userConfirmationService;
@Autowired
    public UserConfirmationsController(UserConfirmationService userConfirmationService){
    this.userConfirmationService = userConfirmationService;
}
@GetMapping("/getAll")
    public DataResult<List<UserConfirmation>> getAll(){
    return this.userConfirmationService.getAll();
}
@GetMapping("/getById")
    public DataResult<UserConfirmation> getById(@RequestParam int id){
    return this.userConfirmationService.getById(id);
}
@GetMapping("/getAllByUserId")
    public DataResult<List<UserConfirmation>> getAllByUserId(@RequestParam int userId){
    return this.userConfirmationService.getAllByUserId(userId);
}
@GetMapping("/getAllByIsConfirmedAndUserConfirmationTypeId")
    public DataResult<List<UserConfirmation>>
    getAllByIsConfirmedAndUserConfirmationTypeId(@RequestParam boolean isConfirmed, @RequestParam int userConfirmationTypeId){
    return this.userConfirmationService.getAllByIsConfirmedAndUserConfirmationTypeId(isConfirmed, userConfirmationTypeId);
}

}
