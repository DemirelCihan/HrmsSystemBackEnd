package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.AuthService;
import com.example.hrms2.business.abstracts.CandidateService;
import com.example.hrms2.business.abstracts.CompanyPersonnelService;
import com.example.hrms2.business.abstracts.EmployerService;
import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.ErrorResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Candidate;
import com.example.hrms2.entities.concretes.CompanyPersonnel;
import com.example.hrms2.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {
    /*yetkilendirme yönetim adresi*/
    private CompanyPersonnelService companyPersonnelService;
    private CandidateService candidateService;
    private EmployerService employerService;

    @Autowired
    public AuthManager(CompanyPersonnelService companyPersonnelService, CandidateService candidateService,
                       EmployerService employerService){
        this.companyPersonnelService = companyPersonnelService;
        this.candidateService = candidateService;
        this.employerService = employerService;
    }

    @Override
    public Result registerCompanyPersonnel(CompanyPersonnel user, String confirmPassword) {

       validateUser(user, confirmPassword);
        return this.companyPersonnelService.add(user);
    }

    @Override
    public Result registerCandidate(Candidate user, String confirmPassword) {
        validateUser(user, confirmPassword);
        return this.candidateService.add(user);
    }

    @Override
    public Result registerEmployer(Employer employer, String confirmPassword) {
        return null;
    }

    private boolean checkIfPasswordsMatch(String password, String confirmPassword){
        boolean result = false;

        if(password.equals(confirmPassword));{
            result = true;
        }
        return result;
    }

    private Result validateUser(User user, String confirmPassword){
        if (!checkIfPasswordsMatch(user.getPassword(), confirmPassword)){
            return new ErrorResult("Parola eşleşmesi gerçekleşmedi.Tekrar deneyiniz.");
        }
        return null;
    }
}
