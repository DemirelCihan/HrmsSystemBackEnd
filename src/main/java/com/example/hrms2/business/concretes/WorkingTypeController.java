package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.WorkingTypeService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.WorkingTypeDao;
import com.example.hrms2.entities.concretes.WorkingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkingTypeController implements WorkingTypeService {

    private WorkingTypeDao workingTypeDao;
    @Autowired
    public WorkingTypeController(WorkingTypeDao workingTypeDao){
        this.workingTypeDao = workingTypeDao;
    }
    @Override
    public Result add(WorkingType workingType) {
        this.workingTypeDao.save(workingType);
        return new SuccessResult("Yeni iş tipi eklendi");
    }

    @Override
    public Result update(WorkingType workingType) {
      this.workingTypeDao.save(workingType);
        return new SuccessResult("İş tipi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.workingTypeDao.deleteById(id);
        return new SuccessResult("İş tipi silindi");
    }

    @Override
    public DataResult<List<WorkingType>> getAll() {

        Sort sort = Sort.by(Sort.Direction.ASC,"type");
        return new SuccessDataResult<List<WorkingType>>
                (this.workingTypeDao.findAll(sort));
    }


    @Override
    public DataResult<WorkingType> getById(int id) {
        return new SuccessDataResult<WorkingType>
                (this.workingTypeDao.getById(id));
    }
}
