package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.CandidateService;
import com.example.hrms2.business.abstracts.ResumeService;
import com.example.hrms2.business.abstracts.UserActivationService;
import com.example.hrms2.business.abstracts.UserService;
import com.example.hrms2.business.adapters.mernis.UserCheckService;
import com.example.hrms2.core.results.*;
import com.example.hrms2.dataAccess.abstracts.CandidateDao;
import com.example.hrms2.entities.concretes.Candidate;
import com.example.hrms2.entities.concretes.Resume;
import com.example.hrms2.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private ResumeService resumeService;
    private UserService userService;
    private UserCheckService userCheckService;
    private UserActivationService userActivationService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, ResumeService resumeService,UserService userService, UserCheckService userCheckService,
                            UserActivationService userActivationService){
        this.candidateDao = candidateDao;
        this.resumeService =resumeService;
        this.userService = userService;
        this.userCheckService = userCheckService;
        this.userActivationService = userActivationService;
    }

    @Override
    public Result add(Candidate candidate) {
       if(validateCandidate(candidate) != null){
           return validateCandidate(candidate);
       }
       this.candidateDao.save(candidate);
       resumeService.add(new Resume(candidate));
        return userActivationService.add(new UserActivation(candidate));
    }


    @Override
    public Result update(Candidate candidate) {
        Candidate c = getById(candidate.getId()).getData();

        candidate.setEmail(candidate.getEmail() == null || candidate.getEmail() == ""
                ? c.getEmail()
                : candidate.getEmail());
        candidate.setPassword(candidate.getPassword() == null || candidate.getPassword() == ""
                ? c.getPassword()
                : candidate.getPassword());
        candidate.setCandidateFirstName(candidate.getCandidateFirstName() == null || candidate.getCandidateFirstName() == ""
                ? c.getCandidateFirstName()
                : candidate.getCandidateFirstName());
        candidate.setCandidateLastName(candidate.getCandidateLastName() == null || candidate.getCandidateLastName() == ""
                ? c.getCandidateLastName()
                : candidate.getCandidateLastName());
        candidate.setIdentityNumber(candidate.getIdentityNumber() == null || candidate.getIdentityNumber() == ""
                ? c.getIdentityNumber()
                : candidate.getIdentityNumber() );
        candidate.setBirthYear(candidate.getBirthYear() == null
                ? c.getBirthYear()
                : candidate.getBirthYear());

        if (validateCandidate(candidate) != null) {
            return validateCandidate(candidate);
        }

        candidateDao.save(candidate);
        return new SuccessResult("İş arayan güncellendi.");
    }


    @Override
    public Result delete(int id) {
        this.candidateDao.deleteById(id);
        return new SuccessResult("iş arayanlar silindi");
    }


    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.findAll());
    }



    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>
                (this.candidateDao.getById(id));
    }


    @Override
    public Result activate(String code) {

        UserActivation userActivation = userActivationService.getByCode(code).getData();

        if (userActivation == null) {
            return new ErrorResult("Geçersiz bir kod girdiniz.");
        }

        Candidate candidate = getById(userActivation.getUser().getId()).getData();

        userActivation.setActivated(true);
        userActivation.setIsActivatedDate(LocalDateTime.now());

        candidateDao.save(candidate);
        userActivationService.update(userActivation);
        return new SuccessResult("Üyelik işlemleri tamamlanmıştır.");
    }

    @Override
    public DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated) {
        return new SuccessDataResult<List<Candidate>>
                (this.candidateDao.getByUserActivation_IsActivated(isActivated));
    }

    @Override
    public DataResult<Candidate> getByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Candidate>
                (this.candidateDao.getByIdentityNumber(identityNumber));
    }

    private boolean checkIfEmailExists(String email) {

        boolean result = false;

        if (userService.getByEmail(email).getData() == null) {
            result = true;
        }

        return result;
    }
    private boolean checkIfIdentityNumberExists(String identityNumber) {

        boolean result = false;

        if (getByIdentityNumber(identityNumber).getData() == null) {
            result = true;
        }

        return result;
    }

    private Result validateCandidate(Candidate candidate) {

        if (!checkIfEmailExists(candidate.getEmail())) {
            return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
        }

        if (!checkIfIdentityNumberExists(candidate.getIdentityNumber())) {
            return new ErrorResult("Girilen kimlik numarası başka bir hesaba aittir.");
        }

        if (!userCheckService.checkIfRealPerson(candidate.getIdentityNumber(), candidate.getCandidateFirstName(), candidate.getCandidateLastName(), candidate.getBirthYear())) {
            return new ErrorResult("Lütfen bilgilerinizi doğru giriniz.");
        }

        return null;
    }

}

