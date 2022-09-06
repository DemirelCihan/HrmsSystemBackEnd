package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.JobTitleService;
import com.example.hrms2.core.results.*;
import com.example.hrms2.dataAccess.abstracts.JobTitleDao;
import com.example.hrms2.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;
    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao){
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public Result add(JobTitle jobTitle) {
        if (!checkIfJobTitleExists(jobTitle.getTitle())){
            return new ErrorResult("Eklenmek istenen iş pozisyonu mevcut.");
        }
        this.jobTitleDao.save(jobTitle);

        return new SuccessResult("İş pozisyonu eklendi");
    }

    @Override
    public Result update(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("İş pozisyonu güncellendi");
    }


    @Override
    public Result delete(int id) {
        this.jobTitleDao.deleteById(id);
        return new SuccessResult("İş pozisyonu silindi");
    }


    @Override
    public DataResult<List<JobTitle>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"title");
        return new SuccessDataResult<List<JobTitle>>
                (this.jobTitleDao.findAll(sort));
        /*iş ilanları ASC sıralamaya göre bulunacaktır*/
    }

    @Override
    public DataResult<JobTitle> getById(int id) {
        return new SuccessDataResult<JobTitle>
                (this.jobTitleDao.getById(id));

    }

    @Override
    public DataResult<JobTitle> getByTitle(String title) {
        return new SuccessDataResult<JobTitle>
                (this.jobTitleDao.getByTitle(title));
    }

    private boolean checkIfJobTitleExists(String title) {

        boolean result = false;

        if (getByTitle(title).getData() == null) {
            result = true;
        }

        return result;
    }
}
