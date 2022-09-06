package com.example.hrms2.business.concretes;

import com.example.hrms2.business.abstracts.ImageService;
import com.example.hrms2.business.abstracts.UserService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.core.results.SuccessDataResult;
import com.example.hrms2.core.results.SuccessResult;
import com.example.hrms2.dataAccess.abstracts.ImageDao;
import com.example.hrms2.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ImageManager implements ImageService {

   private ImageDao imageDao;
   private UserService userService;

   @Autowired
   public ImageManager(ImageDao imageDao, UserService userService){
       this.imageDao = imageDao;
       this.userService = userService;
   }

    @Override
    public Result add(Image image) {
        this.imageDao.save(image);
        return new SuccessResult("Fotoğraf eklendi");
    }

    @Override
    public Result update(Image image) {
       this.imageDao.save(image);
        return new SuccessResult("Fotoğraf güncellendi");
    }


    @Override
    public Result delete(int id) {
        return null;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<List<Image>>
                (this.imageDao.findAll());
    }

    @Override
    public DataResult<Image> getById(int id) {
        return new SuccessDataResult<Image>
                (this.imageDao.getById(id));
    }

    @Override
    public Result upload(int userId, MultipartFile file) {
        return null;
    }

    @Override
    public DataResult<Image> getByUserId(int userId) {
        return new SuccessDataResult<Image>
                (this.imageDao.getByUser_Id(userId));
    }
}
