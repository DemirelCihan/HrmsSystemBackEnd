package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.UpdatedEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdatedEmployerDao extends JpaRepository<UpdatedEmployer, Integer> {
    UpdatedEmployer getByEmployer_Id(int employerId);

}
