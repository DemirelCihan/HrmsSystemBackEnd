package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.UserConfirmationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserConfirmationTypeDao extends JpaRepository<UserConfirmationType, Integer> {

}
