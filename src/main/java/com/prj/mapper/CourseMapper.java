package com.prj.mapper;

import com.prj.dto.Coursedto;
import com.prj.entities.Course;

public class CourseMapper {
    public static Coursedto mapCoursedto(Course course)
    {
        return new Coursedto(
            course.getCourseId(),
            course.getCourseName(),
            course.getContent(),
            course.getCourseAim(),
            course.getCourseDuration(),
            course.getCourseCost(),
            course.getCourseMethod(),
            course.getCourseCertificate(),
            course.getCourseLikes()
        );
    }

    public static Course mapCourse(Coursedto coursedto)
    {
        return new Course(
            coursedto.getCourseId(),
            coursedto.getCourseName(),
            coursedto.getContent(),
            coursedto.getCourseAim(),
            coursedto.getCourseDuration(),
            coursedto.getCourseCost(),
            coursedto.getCourseMethod(),
            coursedto.getCourseCertificate(),
            coursedto.getCourseLikes()
        );
    }
}
