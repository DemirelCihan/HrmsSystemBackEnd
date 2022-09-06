package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Candidate;
import com.example.hrms2.entities.concretes.CompanyPersonnel;
import com.example.hrms2.entities.concretes.Employer;

public interface AuthService {
    Result registerCompanyPersonnel (CompanyPersonnel companyPersonnel, String confirmPassword);
    Result registerCandidate(Candidate candidate, String confirmPassword);
    Result registerEmployer(Employer employer, String confirmPassword);
}
