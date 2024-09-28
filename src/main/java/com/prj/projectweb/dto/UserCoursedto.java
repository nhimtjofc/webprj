package com.prj.projectweb.dto;

import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserCoursedto {
    private Long userCourseId;
    private User user;
    private Course course;
}