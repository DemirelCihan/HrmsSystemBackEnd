package com.example.hrms2.business.abstracts;


import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UserActivation;
import java.util.List;

public interface UserActivationService extends BaseEntityService<UserActivation>{
    DataResult<UserActivation> getByCode(String code);

    DataResult<UserActivation> getByUserId(int userId);

    DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated);

}
