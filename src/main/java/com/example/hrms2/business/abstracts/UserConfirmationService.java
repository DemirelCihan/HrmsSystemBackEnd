package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UserConfirmation;

import java.util.List;

public interface UserConfirmationService  extends BaseEntityService<UserConfirmation>{
    DataResult<List<UserConfirmation>> getAllByUserId (int userId);

    DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);

}
