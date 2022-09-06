package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.EmailService;
import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {
    @Override
    public Result sendEmail(User user) {
        return new SuccessResult(user.getEmail()+ "email adresine mail gönderildi.");
    }
}
