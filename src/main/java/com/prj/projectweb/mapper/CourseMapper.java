
package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.Coursedto;
import com.prj.projectweb.entities.Course;

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
