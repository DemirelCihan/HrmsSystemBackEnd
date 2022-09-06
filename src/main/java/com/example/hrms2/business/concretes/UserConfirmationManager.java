package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.EmailService;
import com.example.hrms2.business.abstracts.UserConfirmationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.UserConfirmationDao;
import com.example.hrms2.entities.concretes.UserConfirmation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserConfirmationManager implements UserConfirmationService {

  private UserConfirmationDao userConfirmationDao;
  private EmailService emailService;
  @Autowired
  UserConfirmationManager(UserConfirmationDao userConfirmationDao, EmailService emailService){
      this.userConfirmationDao = userConfirmationDao;
      this.emailService = emailService;
  }
    @Override
    public Result add(UserConfirmation userConfirmation) {

      userConfirmation.setIsConfirmedDate(LocalDateTime.now());
      this.userConfirmationDao.save(userConfirmation);
      emailService.sendEmail(userConfirmation.getUser());
      return new SuccessResult();
    }

    @Override
    public Result update(UserConfirmation userConfirmation) {
      this.userConfirmationDao.save(userConfirmation);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
      this.userConfirmationDao.deleteById(id);
        return new SuccessResult();
    }

    @Override
    public DataResult<List<UserConfirmation>> getAll() {
        return new SuccessDataResult<List<UserConfirmation>>
                (this.userConfirmationDao.findAll());
    }

    @Override
    public DataResult<UserConfirmation> getById(int id) {
        return new SuccessDataResult<UserConfirmation>
                (this.userConfirmationDao.getById(id));
    }

    @Override
    public DataResult<List<UserConfirmation>> getAllByUserId(int userId) {
        return new SuccessDataResult<List<UserConfirmation>>
                (this.userConfirmationDao.getByUser_Id(userId));
    }

    @Override
    public DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId) {
        return new SuccessDataResult<List<UserConfirmation>>
                (this.userConfirmationDao.getByIsConfirmedAndUserConfirmationType_Id(isConfirmed,userConfirmationTypeId));
    }

}
