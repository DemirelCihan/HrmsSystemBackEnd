package com.example.hrms2.business.abstracts;


import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();
    DataResult<User> getById(int id);
    DataResult<User> getByEmail(String email);

}
