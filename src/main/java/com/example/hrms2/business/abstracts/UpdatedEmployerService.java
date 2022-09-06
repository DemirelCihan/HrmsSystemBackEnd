package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.UpdatedEmployer;

public interface UpdatedEmployerService extends BaseEntityService<UpdatedEmployer>{
    DataResult<UpdatedEmployer> getByEmployerId(int employerId);

}
