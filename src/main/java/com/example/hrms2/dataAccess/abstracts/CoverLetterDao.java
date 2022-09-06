package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {
    List<CoverLetter> getByCandidate_Id(int candidateId);

}
