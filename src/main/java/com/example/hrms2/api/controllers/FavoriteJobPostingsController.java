package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.FavoriteJobPostingService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.FavoriteJobPosting;
import com.example.hrms2.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoriteJobPostings")
@CrossOrigin
public class FavoriteJobPostingsController {
private FavoriteJobPostingService favoriteJobPostingService;
@Autowired
    public FavoriteJobPostingsController(FavoriteJobPostingService favoriteJobPostingService){
    this.favoriteJobPostingService = favoriteJobPostingService;
}
@PostMapping("/add")
    public Result add(@RequestBody FavoriteJobPosting favoriteJobPosting){
    return this.favoriteJobPostingService.add(favoriteJobPosting);
}

@DeleteMapping("/delete")
    public Result delete(@RequestParam int id){
    return this.favoriteJobPostingService.delete(id);
}

@GetMapping("getAll")
    public DataResult<List<FavoriteJobPosting>> getAll(){
    return this.favoriteJobPostingService.getAll();
}

@GetMapping("/getById")
    public DataResult<FavoriteJobPosting> getById(@RequestParam int id){
    return this.favoriteJobPostingService.getById(id);
}

    @GetMapping("/getAllByCandidateId")
    public DataResult<List<FavoriteJobPosting>> getAllByCandidateId(@RequestParam int candidateId) {
        return favoriteJobPostingService.getAllByCandidateId(candidateId);
    }

    @GetMapping("/getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites")
    public DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(@RequestParam int candidateId) {
        return this.favoriteJobPostingService.getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(candidateId);
    }
}
