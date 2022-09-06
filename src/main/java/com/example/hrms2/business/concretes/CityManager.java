package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.CityService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.CityDao;
import com.example.hrms2.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityManager implements CityService {

    private CityDao cityDao;
    @Autowired
    public CityManager(CityDao cityDao){
        this.cityDao = cityDao;
    }

    @Override
    public Result add(City city) {
        this.cityDao.save(city);
        return new SuccessResult("Kullanıcıya ait şehir bilgisi girildi.");
    }

    @Override
    public Result update(City city) {
        this.cityDao.save(city);
        return new SuccessResult("Şehir bilgisi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.cityDao.deleteById(id);
        return new SuccessResult("Şehir bilgisi kaldırıldı");
    }

    @Override
    public DataResult<List<City>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "city");
        return new SuccessDataResult<List<City>>
                (this.cityDao.findAll(sort));
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>
                (this.cityDao.getById(id));
    }

}
