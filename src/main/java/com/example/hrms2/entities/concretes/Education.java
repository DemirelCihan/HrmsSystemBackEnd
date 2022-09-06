package com.example.hrms2.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @NotNull
    @Column(name = "school_department")
    private String schoolDepartment;

    @Column(name = "degree")
    private String degree;

    @Column(name = "starting_date")
    private LocalDateTime startingDate;

    @Column(name = "graduation_year")
    private LocalDateTime graduationDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

    public String getGraduationDate(){
        if (graduationDate==null){
            return "Devam ediyor.";
        }
        return graduationDate.toString();
    }
}
