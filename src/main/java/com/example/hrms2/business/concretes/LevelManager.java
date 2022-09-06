package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.LevelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.LevelDao;
import com.example.hrms2.entities.concretes.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelManager implements LevelService {

    private LevelDao levelDao;
    @Autowired
    public LevelManager(LevelDao levelDao){
        this.levelDao = levelDao;
    }
    @Override
    public Result add(Level level) {
        this.levelDao.save(level);
        return new SuccessResult("Seeviye bilgisi eklendi.");
    }

    @Override
    public Result update(Level level) {
        this.levelDao.save(level);
        return new SuccessResult("Seviye bilgisi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.levelDao.deleteById(id);
        return new SuccessResult("Seviye bilgisi silindi.");
    }

    @Override
    public DataResult<List<Level>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"level");
        return new SuccessDataResult<List<Level>>
                (this.levelDao.findAll(sort));
    }


    @Override
    public DataResult<Level> getById(int id) {
        return new SuccessDataResult<Level>
                (this.levelDao.getById(id));
    }

}
