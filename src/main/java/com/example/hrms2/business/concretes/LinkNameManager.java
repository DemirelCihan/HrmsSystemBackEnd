package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.LinkNameService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.LinkNameDao;
import com.example.hrms2.entities.concretes.LinkName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkNameManager implements LinkNameService {
    private LinkNameDao linkNameDao;
    @Autowired
    public LinkNameManager(LinkNameDao linkNameDao){
        this.linkNameDao = linkNameDao;
    }

    @Override
    public Result add(LinkName linkName) {
        this.linkNameDao.save(linkName);
        return new SuccessResult("Link ismi eklendi.");
    }

    @Override
    public Result update(LinkName linkName) {
        this.linkNameDao.save(linkName);
        return new SuccessResult("Link ismi güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.linkNameDao.deleteById(id);
        return new SuccessResult("Link ismi silindi.");
    }

    @Override
    public DataResult<List<LinkName>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        return new SuccessDataResult<List<LinkName>>
                (this.linkNameDao.findAll(sort));
    }

    @Override
    public DataResult<LinkName> getById(int id) {
        return new SuccessDataResult<LinkName>
                (this.linkNameDao.getById(id));
    }

}
