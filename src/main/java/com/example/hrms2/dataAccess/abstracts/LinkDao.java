package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link, Integer> {

}
