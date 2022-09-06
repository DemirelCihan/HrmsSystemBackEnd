package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.LanguageLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageLevelDao extends JpaRepository<LanguageLevel, Integer> {

}
