package com.example.hrms2.entities.concretes;


import com.example.hrms2.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")

public class Candidate extends User {

    @Column(name = "first_name")
    private String candidateFirstName;

    @Column(name = "last_name")
    private String candidateLastName;

    @Column(name = "identity_number")
    private String identityNumber;

    @Column(name = "birth_year")
    private LocalDate birthYear;

    @JsonIgnore
    @OneToOne(mappedBy = "user")//bire bir ilişki
    private UserActivation userActivation;



}
