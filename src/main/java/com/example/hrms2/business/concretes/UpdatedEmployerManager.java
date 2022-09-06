package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.UpdatedEmployerService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.UpdatedEmployerDao;
import com.example.hrms2.entities.concretes.UpdatedEmployer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdatedEmployerManager implements UpdatedEmployerService {

    private UpdatedEmployerDao updatedEmployerDao;
    @Autowired
    public UpdatedEmployerManager(UpdatedEmployerDao updatedEmployerDao){
        this.updatedEmployerDao = updatedEmployerDao;
    }
    @Override
    public Result add(UpdatedEmployer updatedEmployer) {
        this.updatedEmployerDao.save(updatedEmployer);
        return new SuccessResult("Güncel işveren sisteme eklendi.");
    }

    @Override
    public Result update(UpdatedEmployer updatedEmployer) {
        this.updatedEmployerDao.save(updatedEmployer);
        return new SuccessResult("Güncel işveren bilgileri güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.updatedEmployerDao.deleteById(id);
        return new SuccessResult("Güncel işveren sistemden silindi.");
    }


    @Override
    public DataResult<List<UpdatedEmployer>> getAll() {
        return new SuccessDataResult<List<UpdatedEmployer>>
                (this.updatedEmployerDao.findAll());
    }

    @Override
    public DataResult<UpdatedEmployer> getById(int id) {
        return new SuccessDataResult<UpdatedEmployer>
                (this.updatedEmployerDao.getById(id));
    }

    @Override
    public DataResult<UpdatedEmployer> getByEmployerId(int employerId) {
        return new SuccessDataResult<UpdatedEmployer>
                (this.updatedEmployerDao.getByEmployer_Id(employerId));
    }

}
