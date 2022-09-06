package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.JobTitle;


public interface JobTitleService extends BaseEntityService<JobTitle>{
    DataResult<JobTitle> getByTitle(String title);

}
