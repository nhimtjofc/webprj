package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.dto.Coursedto;
import com.prj.projectweb.dto.Lecturerdto;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.CourseContent;
import com.prj.projectweb.entities.Lecturer;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static Coursedto mapCourseDto(Course course) {
        if (course == null) return null;

        return new Coursedto(
                mapCourseContentToDto(course.getCourseContent()),
                course.getCourseId(),
                course.getCourseName(),
                course.getContent(),
                course.getCourseAim(),
                course.getCourseDuration(),
                course.getCourseCost(),
                course.getCourseMethod(),
                course.getCourseCertificate(),
                course.getCourseLikes(),
                course.getStartTime(),
                course.getEndTime(),
                course.getSchedule(),
                course.getImage(),
                course.getNumberOfStudents(),
                course.getObject(),
                mapLecturerToDto(course.getLecturer())
        );
    }

    public static Course mapCourse(Coursedto courseDto) {
        if (courseDto == null) return null;

        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        course.setContent(courseDto.getContent());
        course.setCourseAim(courseDto.getCourseAim());
        course.setCourseDuration(courseDto.getCourseDuration());
        course.setCourseCost(courseDto.getCourseCost());
        course.setCourseMethod(courseDto.getCourseMethod());
        course.setCourseCertificate(courseDto.getCourseCertificate());
        course.setCourseLikes(courseDto.getCourseLikes());
        course.setStartTime(courseDto.getStartTime());
        course.setEndTime(courseDto.getEndTime());
        course.setSchedule(courseDto.getSchedule());
        course.setImage(courseDto.getImage());
        course.setNumberOfStudents(courseDto.getNumberOfStudents());
        course.setObject(courseDto.getObject());
        course.setLecturer(mapDtoToLecturer(courseDto.getLecturer()));

        List<CourseContent> courseContents = mapDtoToCourseContent(courseDto.getCourseContent(), course);
        course.setCourseContent(courseContents);

        return course;
    }

    private static List<CourseContentdto> mapCourseContentToDto(List<CourseContent> courseContents) {
        if (courseContents == null) return Collections.emptyList(); // Return an empty list instead of null
        return courseContents.stream()
                .map(content -> new CourseContentdto(content.getSession(), content.getTitle(), content.getDetails()))
                .collect(Collectors.toList());
    }

    private static List<CourseContent> mapDtoToCourseContent(List<CourseContentdto> dtos, Course course) {
        if (dtos == null) return Collections.emptyList(); // Return an empty list instead of null
        return dtos.stream()
                .map(dto -> new CourseContent(dto.getSession(), dto.getTitle(), dto.getDetails(), course))
                .collect(Collectors.toList());
    }

    private static Lecturerdto mapLecturerToDto(Lecturer lecturer) {
        return (lecturer == null) ? null : new Lecturerdto(lecturer.getName(), lecturer.getId());
    }

    private static Lecturer mapDtoToLecturer(Lecturerdto lecturerDto) {
        if (lecturerDto == null) return null;

        Lecturer lecturer = new Lecturer();
        lecturer.setId(lecturerDto.getId());
        lecturer.setName(lecturerDto.getName());
        return lecturer;
    }
}
