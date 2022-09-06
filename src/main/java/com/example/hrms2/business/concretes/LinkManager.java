package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.LinkService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.LinkDao;
import com.example.hrms2.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkManager implements LinkService {

    private LinkDao linkDao;
    @Autowired
    public LinkManager(LinkDao linkDao){
        this.linkDao = linkDao;
    }
    @Override
    public Result add(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link eklendi.");
    }

    @Override
    public Result update(Link link) {
        this.linkDao.save(link);
        return new SuccessResult("Link güncellendi.");
    }

    @Override
    public Result delete(int id) {
        this.linkDao.deleteById(id);
        return new SuccessResult("Link silindi.");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>
                (this.linkDao.findAll());
    }

    @Override
    public DataResult<Link> getById(int id) {
        return new SuccessDataResult<Link>
                (this.linkDao.getById(id));
    }
}
