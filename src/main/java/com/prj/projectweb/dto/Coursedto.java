package com.prj.projectweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Coursedto {
    private Long courseId;
    private String CourseName;
    private String content;
    private String CourseAim;
    private String CourseDuration;
    private Long CourseCost;
    private String CourseMethod;
    private String CourseCertificate;
    private Long CourseLikes;
}