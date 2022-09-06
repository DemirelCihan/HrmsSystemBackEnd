package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.WorkingType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingTypeDao extends JpaRepository<WorkingType,Integer> {

}
