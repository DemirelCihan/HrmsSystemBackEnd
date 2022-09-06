package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.UserConfirmationTypeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.UserConfirmationTypeDao;
import com.example.hrms2.entities.concretes.UserConfirmationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserConfirmationTypeManager implements UserConfirmationTypeService {
    private UserConfirmationTypeDao userConfirmationTypeDao;
    @Autowired
    UserConfirmationTypeManager(UserConfirmationTypeDao userConfirmationTypeDao){
        this.userConfirmationTypeDao = userConfirmationTypeDao;
    }

    @Override
    public Result add(UserConfirmationType userConfirmationType) {
        this.userConfirmationTypeDao.save(userConfirmationType);
        return new SuccessResult("Kullanıcı onay tipi eklendi");
    }

    @Override
    public Result update(UserConfirmationType userConfirmationType) {
        this.userConfirmationTypeDao.save(userConfirmationType);
        return new SuccessResult("Kullanıcı onay tipi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.userConfirmationTypeDao.deleteById(id);
        return new SuccessResult("Onay tipi silindi.");
    }

    @Override
    public DataResult<List<UserConfirmationType>> getAll() {
        return new SuccessDataResult<List<UserConfirmationType>>
                (this.userConfirmationTypeDao.findAll());
    }

    @Override
    public DataResult<UserConfirmationType> getById(int id) {
        return new SuccessDataResult<UserConfirmationType>
                (this.userConfirmationTypeDao.getById(id));
    }
}
