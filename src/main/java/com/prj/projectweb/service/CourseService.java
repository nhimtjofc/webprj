
package com.prj.projectweb.service;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.dto.Coursedto;

import java.util.List;

public interface CourseService {
    Coursedto createCourse(Coursedto coursedto);

    Coursedto getCourseById(Long courseID);

    List<Coursedto> getAllCourses();

    Coursedto updateCourse(Long courseID, Coursedto updatedCourse);

    void deleteCourse(Long courseID);
    Coursedto createCourseWithDetails(CourseContentdto contentDto);

}
