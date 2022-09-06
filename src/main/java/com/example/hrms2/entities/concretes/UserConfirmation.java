package com.example.hrms2.entities.concretes;


import com.example.hrms2.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "user_confirmations")
public class UserConfirmation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_confirmed_date")
    private LocalDateTime isConfirmedDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "company_personnel_id")
    private CompanyPersonnel companyPersonnel;

    @ManyToOne()
    @JoinColumn(name = "user_confirmation_type_id")
    private UserConfirmationType userConfirmationType;

    public UserConfirmation(User user, CompanyPersonnel companyPersonnel, UserConfirmationType userConfirmationType, boolean isConfirmed) {
        this.setUser(user);
        this.setCompanyPersonnel(companyPersonnel);
        this.setUserConfirmationType(userConfirmationType);
        this.setConfirmed(isConfirmed);
    }
}
