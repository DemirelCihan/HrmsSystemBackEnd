package com.example.hrms2;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import com.cloudinary.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;


@SpringBootApplication
@EnableSwagger2//swageer ı başlatan anatasyon
public class Hrms2Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Hrms2Application.class, args);

        //Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
          //      "cloud_name", "demirel",
            //    "api_key", "697532558677694",
              //  "api_secret", "TFT6TzZdo4jDbmIz1qkxRUsRJdc",
                //"secure", true));
/*burada yaptığımız işlermler ile olusturacağımı hrsm sisteminde kullanıcı yani bir profil yarattığında fotoğraf ekleyebilecektir.
* import com.cloudinary.*; import edip clooudinary.com adresinden ücretsiz hesap olusturup kendi cloud_name, api_key ve api_secret
* bilgilerimizi alıp Hrms2Application içerisine yazıyoruz.*/
        //File file = new File("my_image.jpg");
        //Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        /*eğer sistemde url olarak fotoğramızıın görünmesi için:*/
        //System.out.println(uploadResult.get("url"));
    }

    @Bean

    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                     .select()
                       .apis(RequestHandlerSelectors
                        .basePackage("com.example.hrms2."))/*Burada yapılan işlem com.example.hrms2
                     yi gez ve içerisinde bulunan apileri dökümantasyona yaz komutudur. */
                    .build();
    }


}
