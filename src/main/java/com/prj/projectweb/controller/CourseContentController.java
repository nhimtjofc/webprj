package com.prj.projectweb.controller;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.service.CourseContentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course-content")
public class CourseContentController {

    private final CourseContentService courseContentService;

    public CourseContentController(CourseContentService courseContentService) {
        this.courseContentService = courseContentService;
    }

    // Thêm CourseContent
    @PostMapping
    public CourseContentdto addCourseContent(@RequestBody CourseContentdto courseContentdto, @RequestParam Long courseId) {
        // Bạn có thể lấy course từ repository bằng courseId nếu cần
        Course course = new Course(); // Tạm thời tạo Course, nên lấy từ database
        course.setCourseId(courseId);
        return courseContentService.addCourseContent(courseContentdto, course);
    }

    // Lấy tất cả CourseContent
    @GetMapping
    public List<CourseContentdto> getAllCourseContents() {
        return courseContentService.getAllCourseContents();
    }

    // Có thể thêm các phương thức khác như getById, update, delete
}
