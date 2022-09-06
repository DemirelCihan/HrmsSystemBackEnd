package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.JobPostingConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation,Integer> {
    JobPostingConfirmation getByJobPosting_Id(int jobPostingId);

}
