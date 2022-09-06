package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.SkillService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.SkillDao;
import com.example.hrms2.entities.concretes.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;
    @Autowired
    public SkillManager(SkillDao skillDao){
        this.skillDao = skillDao;
    }

    @Override
    public Result add(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Yeni bir beceri eklendi");
    }

    @Override
    public Result update(Skill skill) {
        this.skillDao.save(skill);
        return new SuccessResult("Beceriler güncellendi") ;
    }

    @Override
    public Result delete(int id) {
        this.skillDao.deleteById(id);
        return new SuccessResult("Beceri silindi");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>
                (this.skillDao.findAll());
    }

    @Override
    public DataResult<Skill> getById(int id) {
        return new SuccessDataResult<Skill>
                (this.skillDao.getById(id));
    }


}
