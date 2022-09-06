package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
