package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.LinkName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkNameDao extends JpaRepository<LinkName, Integer> {

}
