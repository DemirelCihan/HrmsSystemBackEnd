package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.WorkingTimeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.WorkingTimeDao;
import com.example.hrms2.entities.concretes.WorkingTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkingTimeManager implements WorkingTimeService {

    private WorkingTimeDao workingTimeDao;
    @Autowired
    public WorkingTimeManager(WorkingTimeDao workingTimeDao){
        this.workingTimeDao = workingTimeDao;
    }
    @Override
    public Result add(WorkingTime workingTime) {
        this.workingTimeDao.save(workingTime
        );
        return new SuccessResult("Çalışma zamanı eklendi");
    }

    @Override
    public Result update(WorkingTime workingTime) {
        this.workingTimeDao.save(workingTime);
        return new SuccessResult("Çalışma zamanı güncellendi");
    }


    @Override
    public Result delete(int id) {
    this.workingTimeDao.deleteById(id);
        return new SuccessResult("Çalışma zamanı silindi");
    }

    @Override
    public DataResult<List<WorkingTime>> getAll() {

        Sort sort = Sort.by(Sort.Direction.ASC, "time");
        return new SuccessDataResult<List<WorkingTime>>
                (this.workingTimeDao.findAll(sort));//arama işlemini sıralama kuralına göre yapacaktır.
    }


    @Override
    public DataResult<WorkingTime> getById(int id) {
        return new SuccessDataResult<WorkingTime>
                (this.workingTimeDao.getById(id));
    }
}
