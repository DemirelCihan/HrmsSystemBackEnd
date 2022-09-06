package com.example.hrms2.business.adapters.mernis;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserCheckManager implements UserCheckService{
    @Override
    public boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, LocalDate birthYear) {
        return true;
    }
}
