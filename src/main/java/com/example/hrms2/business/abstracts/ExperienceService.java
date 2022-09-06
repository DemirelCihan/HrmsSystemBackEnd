package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.Experience;
import javassist.CodeConverter;

import java.util.List;

public interface ExperienceService extends BaseEntityService<Experience> {
    DataResult<List<Experience>> getAllByResumeId(int resumeId);

    DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);

}
