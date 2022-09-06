package com.example.hrms2.api.controllers;

import com.example.hrms2.business.abstracts.ImageService;
import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images")
@CrossOrigin
public class ImagesController {
private ImageService imageService;
@Autowired
    public ImagesController(ImageService imageService){
    this.imageService = imageService;
}

   @PutMapping("/upload")
   public  Result upload(@RequestParam int userId, @RequestParam MultipartFile file){
    return imageService.upload(userId,file);
   }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam int id) {
        return imageService.delete(id);
    }

    @GetMapping("/getAll")
    public DataResult<List<Image>> getAll() {
        return imageService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Image> getById(@RequestParam int id) {
        return imageService.getById(id);
    }

    @GetMapping("/getByUserId")
    public DataResult<Image> getByUserId(@RequestParam int userId) {
        return imageService.getById(userId);
    }


}
