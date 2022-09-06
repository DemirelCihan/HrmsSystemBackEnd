package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.JobPostingConfirmationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingConfirmationTypeDao extends JpaRepository<JobPostingConfirmationType, Integer> {

}
