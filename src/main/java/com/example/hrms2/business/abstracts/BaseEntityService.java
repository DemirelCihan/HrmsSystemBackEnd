package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;

import java.util.List;

public interface BaseEntityService<T>{

    /*Bu alan içerisine yazılan kodlar bir çok classta kullanılmakadır.*/
    Result add(T entity);

    Result update(T entity);

    Result delete(int id);

    DataResult<List<T>> getAll();

    DataResult<T> getById(int id);

}
