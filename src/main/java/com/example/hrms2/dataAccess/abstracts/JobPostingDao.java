package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.JobPosting;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting,Integer> {

    List<JobPosting> getByIsActive(boolean isActive);

    List<JobPosting> getByIsActive(boolean isActive, Sort sort);

    List<JobPosting> getByIsActive(boolean isActive, Pageable pageable);
    //Pageable -> ile controller dana alacağımız sayfa numaralarını sıralama işlemini gerçekleştireceğiz

    List<JobPosting>  getByIsActiveAndEmployer_Id(boolean isActive, int employerId,Sort sort);
}
