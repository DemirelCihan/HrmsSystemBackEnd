package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Resume;
import com.example.hrms2.entities.dtos.ResumeWithEntitiesDto;

import java.util.List;

public interface ResumeService extends  BaseEntityService<Resume>{
    Result addCoverLetterToResume(int resumeId, int coverLetterId);

    Result deleteCoverLetterFromResume(int resumeId);

    DataResult<List<ResumeWithEntitiesDto>> getAllResumeDetailsByActivatedCandidate();

    DataResult<Resume> getByCandidateId(int candidateId);

    DataResult<ResumeWithEntitiesDto> getResumeDetailsByCandidateId(int candidateId);

}
