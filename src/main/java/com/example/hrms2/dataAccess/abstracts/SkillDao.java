package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillDao extends JpaRepository<Skill, Integer> {

}
