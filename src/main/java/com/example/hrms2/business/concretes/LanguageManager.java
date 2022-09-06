package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.LanguageService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.LanguageDao;
import com.example.hrms2.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    private LanguageDao languageDao;
    @Autowired
    public LanguageManager(LanguageDao languageDao){
        this.languageDao = languageDao;
    }

    @Override
    public Result add(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Dil bilgisi sisteme eklendi.");
    }

    @Override
    public Result update(Language language) {
        this.languageDao.save(language);
        return new SuccessResult("Dil bilgisi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.languageDao.deleteById(id);
        return new SuccessResult("Dil bilgisi silindi.");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"language");
        return new SuccessDataResult<List<Language>>
                (this.languageDao.findAll(sort));
    }


    @Override
    public DataResult<Language> getById(int id) {
        return new SuccessDataResult<Language>
                (this.languageDao.getById(id));
    }
}
