package com.prj.projectweb.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(name = "Course_name")
    private String CourseName;

    @Column(name = "Course_content")
    private String content;

    @Column(name = "Course_aim")
    private String CourseAim;

    @Column(name = "Course_duration")
    private String CourseDuration;

    @Column(name = "Course_cost")
    private Long CourseCost;

    @Column(name = "Study_method")
    private String CourseMethod;

    @Column(name = "Course_certificate")
    private String CourseCertificate;

    @Column(name = "Course_likes")
    private Long CourseLikes;
}