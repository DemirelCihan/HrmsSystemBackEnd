package com.example.hrms2.entities.dtos;

import com.example.hrms2.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeWithEntitiesDto {

    private int id;

    private LocalDateTime creationDate; //oluşturulma tarihi localdatetime ile belirlenir.

    private Candidate candidate; //adayların bilgileri alını.

    private CoverLetter coverLetter; //adaylara ait öz yazı bilgileri alınır.

    private Image image; //adaylar ait fotoğrar alınır.

    private List<Education> educations;//adaylara ait eğitim bilgileri liste şeklinde alınır

    private List<Experience> experiences;//adaylara ait iş deneyim bilgileri alınır.

    private List<LanguageLevel> languageLevels;//adayların yabancı dil seviyeleri alınır.

    private List<Link> links;

    private List<Skill> skills;//adaylara ait yeteneklerin bilgileri alınır.









}
