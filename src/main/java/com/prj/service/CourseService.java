package com.prj.service;

import java.util.List;

import com.prj.dto.Coursedto;
import com.prj.entities.Course;

public interface CourseService {
    Coursedto createCourse(Coursedto coursedto);

    Coursedto getCourseById(Long courseID);

    List<Coursedto> getAllCourses();

    Coursedto updateCourse(Long courseID, Coursedto updatedCourse);

    void deleteCourse(Long courseID);
}
