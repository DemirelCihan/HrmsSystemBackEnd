package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelDao extends JpaRepository<Level,Integer> {

}
