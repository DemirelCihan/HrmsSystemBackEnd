package com.example.hrms2.entities.concretes;

import com.example.hrms2.core.entities.User;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="company_personnels")
@EqualsAndHashCode(callSuper = true)//oluşturacağımız sınıf herhangi bir class ı extend etmesi halinde callSuper = true
//hatasız çalışacaktır.
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class CompanyPersonnel extends User {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

}
