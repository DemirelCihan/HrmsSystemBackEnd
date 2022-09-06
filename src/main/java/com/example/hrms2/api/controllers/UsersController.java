package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.UserService;
import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.DataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin//(kökler arasında kaynak paylaşımı)
public class UsersController {
    private UserService userService;
    @Autowired
    public UsersController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<User> getById(@RequestParam int id){
        return this.userService.getById(id);
    }

}
