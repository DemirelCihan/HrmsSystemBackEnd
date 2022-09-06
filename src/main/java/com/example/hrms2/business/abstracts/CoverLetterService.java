package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.CoverLetter;

import java.util.List;

public interface CoverLetterService extends BaseEntityService<CoverLetter> {
    DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);

}
