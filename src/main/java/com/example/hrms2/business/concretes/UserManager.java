package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.UserService;
import com.example.hrms2.core.dataAccess.UserDao;
import com.example.hrms2.core.entities.User;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;
    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar Listelendi");
    }

    @Override
    public DataResult<User> getById(int id) {
        return new SuccessDataResult<User>(this.userDao.getById(id));
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email));
    }
}
