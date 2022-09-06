package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.Education;


import java.util.List;

public interface EducationService extends BaseEntityService<Education>{

    DataResult<List<Education>> getAllByResumeId(int resumeId);

    DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);

}
