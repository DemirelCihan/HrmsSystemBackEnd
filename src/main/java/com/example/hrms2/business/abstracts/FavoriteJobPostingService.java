package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.entities.concretes.FavoriteJobPosting;
import com.example.hrms2.entities.concretes.JobPosting;

import java.util.List;

public interface FavoriteJobPostingService extends BaseEntityService<FavoriteJobPosting>{
    DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId);

    DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId);

    DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId);

}
