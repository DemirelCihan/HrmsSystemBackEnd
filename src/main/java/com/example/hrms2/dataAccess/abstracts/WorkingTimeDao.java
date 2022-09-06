package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.WorkingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTimeDao extends JpaRepository<WorkingTime,Integer> {

}
