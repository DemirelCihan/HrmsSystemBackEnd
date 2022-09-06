package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.CompanyPersonnelService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.CompanyPersonnelDao;
import com.example.hrms2.entities.concretes.CompanyPersonnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyPersonnelManager implements CompanyPersonnelService {

   private CompanyPersonnelDao companyPersonnelDao;
   @Autowired
   public CompanyPersonnelManager(CompanyPersonnelDao companyPersonnelDao){
       this.companyPersonnelDao = companyPersonnelDao;
   }
    @Override
    public Result add(CompanyPersonnel companyPersonnel) {
       this.companyPersonnelDao.save(companyPersonnel);
       return new SuccessResult("Şirket personeli eklendi");
    }

    @Override
    public Result update(CompanyPersonnel companyPersonnel) {

       CompanyPersonnel companyPersonnel1 = getById(companyPersonnel.getId()).getData();

       companyPersonnel.setEmail(companyPersonnel.getEmail() == null || companyPersonnel.getEmail() == ""
       ? companyPersonnel1.getEmail()
       : companyPersonnel.getEmail());

       companyPersonnel.setPassword(companyPersonnel.getPassword() == null || companyPersonnel.getPassword() == ""
       ? companyPersonnel1.getPassword()
       : companyPersonnel.getPassword());

       companyPersonnel.setFirstName(companyPersonnel.getFirstName() == null || companyPersonnel.getFirstName() == ""
       ? companyPersonnel1.getFirstName()
       : companyPersonnel.getFirstName());

       companyPersonnel.setLastName(companyPersonnel.getLastName() == null || companyPersonnel.getLastName() ==""
       ? companyPersonnel1.getLastName()
       : companyPersonnel.getLastName());
       /*güncelleme işlemleri email adresi, password bilgisi, kullanıcı firstName ve kullanıcı
       * lastName bilgileri güncellenerek gerçekleşmektedir.*/
       this.companyPersonnelDao.save(companyPersonnel);
       return new SuccessResult("Şirket personeli güncellendi");
    }

    @Override
    public Result delete(int id) {
       this.companyPersonnelDao.deleteById(id);
        return new SuccessResult("Şirket personeli bilgisi silindi");
    }

    @Override
    public DataResult<List<CompanyPersonnel>> getAll() {
        return new SuccessDataResult<List<CompanyPersonnel>>
                (this.companyPersonnelDao.findAll());
    }

    @Override
    public DataResult<CompanyPersonnel> getById(int id) {
        return new SuccessDataResult<CompanyPersonnel>
                (this.companyPersonnelDao.getById(id));
    }

}
