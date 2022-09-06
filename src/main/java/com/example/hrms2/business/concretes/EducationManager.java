package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.EducationService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.EducationDao;
import com.example.hrms2.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;
    @Autowired
    public EducationManager(EducationDao educationDao){
        this.educationDao = educationDao;
    }

    @Override
    public Result add(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Yeni bir eğitim bigisi eklendi");
    }

    @Override
    public Result update(Education education) {
        this.educationDao.save(education);
        return new SuccessResult("Eğitim bilgisi güncellendi");
    }

    @Override
    public Result delete(int id) {
        this.educationDao.deleteById(id);
        return new SuccessResult("Eğitim bilgisi silindi");
    }


    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>
                (this.educationDao.findAll());
    }

    @Override
    public DataResult<Education> getById(int id) {
        return new SuccessDataResult<Education>
                (this.educationDao.getById(id));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeId(int resumeId) {
        return new SuccessDataResult<List<Education>>
                (this.educationDao.getByResume_Id(resumeId));
    }

    @Override
    public DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId) {

        Sort sort = Sort.by(Sort.Direction.DESC, "graduationDate");
        //mezuniyet yılına göre sıralama işlemi yapılmaktadır.
        return new SuccessDataResult<List<Education>>
                (this.educationDao.getByResume_Id(resumeId,sort));
    }

}
