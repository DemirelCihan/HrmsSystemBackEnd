package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.LanguageLevelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.LanguageLevelDao;
import com.example.hrms2.entities.concretes.LanguageLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageLevelManager implements LanguageLevelService {
    private LanguageLevelDao languageLevelDao;
    @Autowired
    public LanguageLevelManager(LanguageLevelDao languageLevelDao){
        this.languageLevelDao = languageLevelDao;
    }
    @Override
    public Result add(LanguageLevel languageLevel) {
        this.languageLevelDao.save(languageLevel);
        return new SuccessResult("Dil seviyesi eklendi.");
    }

    @Override
    public Result update(LanguageLevel languageLevel) {
        this.languageLevelDao.save(languageLevel);
        return new SuccessResult("Dil seviyesi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.languageLevelDao.deleteById(id);
        return new SuccessResult("Dil seviyesi silindi");
    }

    @Override
    public DataResult<List<LanguageLevel>> getAll() {
        return new SuccessDataResult<List<LanguageLevel>>
                (this.languageLevelDao.findAll());
    }

    @Override
    public DataResult<LanguageLevel> getById(int id) {
        return new SuccessDataResult<LanguageLevel>
                (this.languageLevelDao.getById(id));
    }

}
