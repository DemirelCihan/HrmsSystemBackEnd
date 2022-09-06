package com.example.hrms2.core.dataAccess;

import com.example.hrms2.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User getByEmail(String email);

}
