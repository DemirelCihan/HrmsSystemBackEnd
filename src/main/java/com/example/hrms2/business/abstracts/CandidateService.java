package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Candidate;


import java.util.List;

public interface CandidateService extends BaseEntityService<Candidate>{

    Result activate(String code);

    DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated);

    DataResult<Candidate> getByIdentityNumber(String identityNumber);




}
