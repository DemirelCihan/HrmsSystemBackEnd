package com.example.hrms2.business.adapters.mernis;

import java.time.LocalDate;

public interface UserCheckService {
    boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, LocalDate birthYear);

}
