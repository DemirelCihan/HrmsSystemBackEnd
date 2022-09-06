package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDao extends JpaRepository<JobTitle, Integer> {
    JobTitle getByTitle(String title);

}
