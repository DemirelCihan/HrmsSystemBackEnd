package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    List<Candidate> getByUserActivation_IsActivated(boolean isActivated);

    Candidate getByIdentityNumber(String identityNumber);


}
