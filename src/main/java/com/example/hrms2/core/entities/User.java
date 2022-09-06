package com.example.hrms2.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
/*InheritanceTyoe.JOINED kullanımı:
* Bu strateji ile hiyerarşide tanımlanan her sınıf kendi tablosu ile eşlenir.
* Yani superclass lar ile subclasslar ayrı ayrı tablolara kaydedilir.
* Ayrıca subclass larda superclass ların primary keyleri bulunur.
*/
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})//istenilen bir nesne aramasında loob a girmemek için kullanılır.
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Email(message = "Geçerli bir e-posta adresi giriniz.")
    @NotNull(message = "E-posta adresi boş geçilmez.")
    @NotBlank(message = "E-posta adresi boş geçilmez.")
    @Column(name = "email",unique = true)
    private String email;

    @NotNull(message = "Şifre alanı boş geçilmez")
    @NotBlank(message = "Şifre alanı boş geçilmez")
    @Column(name = "password")
    private String password;

}
