
package com.prj.projectweb.service.implementation;

import com.prj.projectweb.dto.Coursedto;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.exception.ResourceNotFound;
import com.prj.projectweb.mapper.CourseMapper;
import com.prj.projectweb.repositories.CourseRepository;
import com.prj.projectweb.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseSerImp implements CourseService{

    private CourseRepository courseRepository;

    @Override
    public Coursedto createCourse(Coursedto coursedto) {
        Course course = CourseMapper.mapCourse(coursedto);
        Course courseSaved = courseRepository.save(course);
        return CourseMapper.mapCoursedto(courseSaved);
    }

    @Override
    public Coursedto getCourseById(Long courseID) {
        Course course = courseRepository.findById(courseID).orElseThrow(() -> new ResourceNotFound("This course id " + courseID + " doesn't exist"));
        return CourseMapper.mapCoursedto(course);
    }

    @Override
    public List<Coursedto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseMapper::mapCoursedto).collect(Collectors.toList());
    }

    @Override
    public Coursedto updateCourse(Long courseID, Coursedto updatedCourse) {
        Course course = courseRepository.findById(courseID).orElseThrow(() -> new ResourceNotFound("This course id " + courseID + " doesn't exist"));

        course.setCourseName(updatedCourse.getCourseName());
        course.setContent(updatedCourse.getContent());
        course.setCourseAim(updatedCourse.getCourseAim());
        course.setCourseDuration(updatedCourse.getCourseDuration());
        course.setCourseCost(updatedCourse.getCourseCost());
        course.setCourseMethod(updatedCourse.getCourseMethod());
        course.setCourseCertificate(updatedCourse.getCourseCertificate());
        course.setCourseLikes(updatedCourse.getCourseLikes());

        Course updatedCourseObj = courseRepository.save(course);

        return CourseMapper.mapCoursedto(updatedCourseObj);
    }

    @Override
    public void deleteCourse(Long courseID) {
        Course course = courseRepository.findById(courseID).orElseThrow(() -> new ResourceNotFound("This course id " + courseID + " doesn't exist"));

        courseRepository.deleteById(courseID);
    }

}
