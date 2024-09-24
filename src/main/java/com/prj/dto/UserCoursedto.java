package com.prj.dto;

import com.prj.entities.Course;
import com.prj.entities.User;

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
