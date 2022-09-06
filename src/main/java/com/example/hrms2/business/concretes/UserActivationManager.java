package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.EmailService;
import com.example.hrms2.business.abstracts.UserActivationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.UserActivationDao;
import com.example.hrms2.entities.concretes.UserActivation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class UserActivationManager implements UserActivationService {

    private UserActivationDao userActivationDao;
    private EmailService emailService;

    @Autowired
    public UserActivationManager(UserActivationDao userActivationDao, EmailService emailService){
        this.userActivationDao = userActivationDao;
        this.emailService = emailService;
    }

    @Override
    public Result add(UserActivation userActivation) {

        userActivation.setActivated(false);
        userActivation.setCode(generateCode());
        userActivation.setIsActivatedDate(LocalDateTime.now());

        this.userActivationDao.save(userActivation);
        return this.emailService.sendEmail(userActivation.getUser());
    }

    @Override
    public Result update(UserActivation userActivation) {
        this.userActivationDao.save(userActivation);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.userActivationDao.deleteById(id);
        return new SuccessResult("Silme işlemi gerçekleşti");
    }

    @Override
    public DataResult<List<UserActivation>> getAll() {
        return new SuccessDataResult<List<UserActivation>>
                (this.userActivationDao.findAll());
    }

    @Override
    public DataResult<UserActivation> getById(int id) {
        return new SuccessDataResult<UserActivation>
                (this.userActivationDao.getById(id));
    }

    @Override
    public DataResult<UserActivation> getByCode(String code) {
        return new SuccessDataResult<UserActivation>
                (this.userActivationDao.getByCode(code));
    }

    @Override
    public DataResult<UserActivation> getByUserId(int userId) {
        return new SuccessDataResult<UserActivation>
                (this.userActivationDao.getByUser_Id(userId));
    }

    @Override
    public DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated) {
        return new SuccessDataResult<List<UserActivation>>
                (this.userActivationDao.getByIsActivated(isActivated));
    }

    private String generateCode(){
        UUID code = UUID.randomUUID();
        return code.toString();
    }
    /*UUID (universally unique identifier) bir çeşit random sayı üreticisi denilebilir.*/
}
