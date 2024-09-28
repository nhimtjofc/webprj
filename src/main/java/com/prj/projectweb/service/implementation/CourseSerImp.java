
package com.prj.projectweb.service.implementation;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.dto.Coursedto;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.CourseContent;
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
        // Xử lý ánh xạ CourseContent từ DTO sang Entity
        if (coursedto.getCourseContent() != null) {
            List<CourseContent> courseContents = coursedto.getCourseContent().stream()
                    .map(contentDTO -> {
                        CourseContent content = new CourseContent();
                        content.setSession(contentDTO.getSession());
                        content.setTitle(contentDTO.getTitle());
                        content.setDetails(contentDTO.getDetails());
                        content.setCourse(course);  // Liên kết với khóa học
                        return content;
                    }).collect(Collectors.toList());

            course.setCourseContent(courseContents);
        }
        Course courseSaved = courseRepository.save(course);
        return CourseMapper.mapCourseDto(courseSaved);
    }

    @Override
    public Coursedto getCourseById(Long courseID) {
        Course course = courseRepository.findById(courseID).orElseThrow(() -> new ResourceNotFound("This course id " + courseID + " doesn't exist"));
        return CourseMapper.mapCourseDto(course);
    }

    @Override
    public List<Coursedto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseMapper::mapCourseDto).collect(Collectors.toList());
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
        // Xử lý cập nhật CourseContent
        if (updatedCourse.getCourseContent() != null) {
            // Xóa nội dung cũ và thêm nội dung mới (nếu cần)
            course.getCourseContent().clear();
            List<CourseContent> updatedCourseContents = updatedCourse.getCourseContent().stream()
                    .map(contentDTO -> {
                        CourseContent content = new CourseContent();
                        content.setSession(contentDTO.getSession());
                        content.setTitle(contentDTO.getTitle());
                        content.setDetails(contentDTO.getDetails());
                        content.setCourse(course);
                        return content;
                    }).collect(Collectors.toList());

            course.setCourseContent(updatedCourseContents);
        }
        Course updatedCourseObj = courseRepository.save(course);

        return CourseMapper.mapCourseDto(updatedCourseObj);
    }

    @Override
    public void deleteCourse(Long courseID) {
        Course course = courseRepository.findById(courseID).orElseThrow(() -> new ResourceNotFound("This course id " + courseID + " doesn't exist"));

        courseRepository.deleteById(courseID);
    }
    @Override
    public Coursedto createCourseWithDetails(CourseContentdto contentDto) {
        // Tạo nội dung khóa học từ DTO
        CourseContent courseContent = new CourseContent();
        courseContent.setSession(contentDto.getSession());
        courseContent.setTitle(contentDto.getTitle());
        courseContent.setDetails(contentDto.getDetails());

        // Tạo khóa học mới
        Course course = new Course();
        // Set tên khóa học
        course.setCourseName(contentDto.getTitle()); // Có thể chỉnh sửa tên khóa học tại đây

        // Liên kết nội dung khóa học với khóa học
        courseContent.setCourse(course);
        course.setCourseContent(List.of(courseContent)); // Đặt danh sách nội dung khóa học

        // Lưu khóa học
        Course courseSaved = courseRepository.save(course);
        return CourseMapper.mapCourseDto(courseSaved);
    }

}
