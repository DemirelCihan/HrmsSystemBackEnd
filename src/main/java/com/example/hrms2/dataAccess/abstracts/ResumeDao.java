package com.example.hrms2.dataAccess.abstracts;

import com.example.hrms2.entities.concretes.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeDao extends JpaRepository<Resume , Integer> {
    Resume getByCandidate_Id(int candidateId);

    Resume getByCoverLetter_Id(int coverLetterId);
}
