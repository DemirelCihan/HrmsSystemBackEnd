package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.Result;

public interface EmailService {
    Result sendEmail(User user);

}
