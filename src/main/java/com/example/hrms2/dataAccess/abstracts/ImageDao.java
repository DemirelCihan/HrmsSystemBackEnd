package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image, Integer> {

    Image getByUser_Id(int userId);
}
