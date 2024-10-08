package com.prj.projectweb.controller;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.dto.Coursedto;
import com.prj.projectweb.dto.ResponseMessage;
import com.prj.projectweb.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/api/course")
public class CourseController {
    private CourseService courseService;

    @PostMapping("/create-with-details")
    public ResponseEntity<ResponseMessage> createCourseWithDetails(@RequestBody CourseContentdto contentDto) {
        // Tạo khóa học mới (tên khóa học có thể lấy từ contentDto hoặc một giá trị mặc định)
        Coursedto savedCourse = courseService.createCourseWithDetails(contentDto);

        ResponseMessage responseMessage = new ResponseMessage(1000, "create course successfully!", savedCourse.getCourseName());
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Coursedto> getCourseById(@PathVariable("id") Long courseID)
    {
        Coursedto coursedto = courseService.getCourseById(courseID);
        return ResponseEntity.ok(coursedto);
    }

    @GetMapping
    public ResponseEntity<List<Coursedto>> getAllCourses()
    {
        List<Coursedto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @PutMapping("{id}")
    public ResponseEntity<Coursedto> updateCourse (@PathVariable("id") Long courseID, @RequestBody Coursedto updatedCourse) {
        Coursedto coursedto = courseService.updateCourse(courseID, updatedCourse);
        return ResponseEntity.ok(coursedto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id") Long courseID)
    {
        courseService.deleteCourse(courseID);
        return ResponseEntity.ok("Course deleted successfully!");
    }
}

