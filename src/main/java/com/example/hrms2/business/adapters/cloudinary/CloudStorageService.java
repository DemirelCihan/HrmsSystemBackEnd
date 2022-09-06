package com.example.hrms2.business.adapters.cloudinary;

import com.example.hrms2.core.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudStorageService {
    DataResult<?> upload (MultipartFile multipartFile);

    DataResult<?> delete (String publicIdOfImage);

}
