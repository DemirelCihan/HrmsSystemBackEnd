package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.CompanyPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyPersonnelDao extends JpaRepository<CompanyPersonnel, Integer> {

}
