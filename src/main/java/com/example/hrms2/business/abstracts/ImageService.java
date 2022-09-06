package com.example.hrms2.business.abstracts;

import com.example.hrms2.core.results.DataResult;
import com.example.hrms2.core.results.Result;
import com.example.hrms2.entities.concretes.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService extends BaseEntityService<Image> {
    Result upload(int userId, MultipartFile file);
/*MultipartFile ile dosya yükleme işlemleri gerçekleştirilir.
* Dosya yükleme işlemleri için MultipartResolver ayarlarının yapılması gerekmektedir.
*Dosya yükleme işlemi MultipartResolver arayüzünü kullanan Apache Commons(CommonsMultipartResolver)
* veya Servlet 3.0(StandardServletMultipartResolver) ile birlikte standart olarak gelen sınıf kullanılabilir.
*  */
    DataResult<Image> getByUserId(int userId);

}
