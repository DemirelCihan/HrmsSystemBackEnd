package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {

}
