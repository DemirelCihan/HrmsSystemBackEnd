package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.FavoriteJobPostingService;
import com.example.hrms2.core.results.*;
import com.example.hrms2.dataAccess.abstracts.FavoriteJobPostingDao;
import com.example.hrms2.entities.concretes.FavoriteJobPosting;
import com.example.hrms2.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class FavoriteJobPostingManager implements FavoriteJobPostingService {

    private FavoriteJobPostingDao favoriteJobPostingDao;
    @Autowired
    public FavoriteJobPostingManager(FavoriteJobPostingDao favoriteJobPostingDao){
        this.favoriteJobPostingDao = favoriteJobPostingDao;
    }
    @Override
    public Result add(FavoriteJobPosting favoriteJobPosting) {
        if (getByCandidateIdAndJobPostingId(favoriteJobPosting.getCandidate().getId(), favoriteJobPosting.getJobPosting().getId()).getData() == null) {
            favoriteJobPosting.setDateOfAddToFavorites(LocalDateTime.now());
            this.favoriteJobPostingDao.save(favoriteJobPosting);

            return new SuccessResult("İlan favorilere eklendi.");
        }
        return new ErrorResult();
    }

    @Override
    public Result update(FavoriteJobPosting favoriteJobPosting) {
        this.favoriteJobPostingDao.save(favoriteJobPosting);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.favoriteJobPostingDao.deleteById(id);
        return new SuccessResult("İlan favorilerden kaldırıldı.");
    }

    @Override
    public DataResult<List<FavoriteJobPosting>> getAll() {
        return new SuccessDataResult<List<FavoriteJobPosting>>
                (this.favoriteJobPostingDao.findAll());
    }

    @Override
    public DataResult<FavoriteJobPosting> getById(int id) {
        return new SuccessDataResult<FavoriteJobPosting>
                (this.favoriteJobPostingDao.getById(id));
    }

    @Override
    public DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId) {
        return new SuccessDataResult<List<FavoriteJobPosting>>
                (this.favoriteJobPostingDao.getByCandidate_Id(candidateId));
    }

    @Override
    public DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId) {

        List<JobPosting> jobPostings = new ArrayList<JobPosting>();
        Sort sort = Sort.by(Sort.Direction.DESC,"dateOfAddToFavorites");

        for (FavoriteJobPosting favoriteJobPosting : favoriteJobPostingDao.getByCandidate_Id(candidateId, sort)) {
            if (favoriteJobPosting.getJobPosting().isActive()) {
                jobPostings.add(favoriteJobPosting.getJobPosting());
            } else {
                delete(favoriteJobPosting.getId());
            }
        }
        return new SuccessDataResult<List<JobPosting>>(jobPostings);
    }

    @Override
    public DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId) {
        return new SuccessDataResult<FavoriteJobPosting>
                (this.favoriteJobPostingDao.getByCandidate_IdAndJobPosting_Id(candidateId, jobPostingId));
    }
}
