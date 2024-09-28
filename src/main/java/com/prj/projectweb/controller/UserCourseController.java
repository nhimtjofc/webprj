package com.prj.projectweb.controller;

import com.prj.projectweb.dto.UserCoursedto;
import com.prj.projectweb.service.UserCourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@AllArgsConstructor
@RestController
@RequestMapping("/api/user-course")
public class UserCourseController {
    private UserCourseService usercourseService;

    @PostMapping("/create")
    public ResponseEntity<UserCoursedto> createUserCourse(@RequestBody UserCoursedto usercoursedto)
    {
        UserCoursedto SavedUserCourse = usercourseService.addUserCourse(usercoursedto);
        return new ResponseEntity<>(SavedUserCourse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserCoursedto> getUserCourseById(@PathVariable("id") Long usercourseID)
    {
        UserCoursedto usercoursedto = usercourseService.getUserCourseById(usercourseID);
        if (usercoursedto != null) {
            return ResponseEntity.ok(usercoursedto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserCoursedto>> getAllUserCourses()
    {
        List<UserCoursedto> usercourses = usercourseService.getAllUserCourses();
        return ResponseEntity.ok(usercourses);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserCoursedto> updateUserCourse (@PathVariable("id") Long usercourseID, @RequestBody UserCoursedto updatedUserCourse) {
        UserCoursedto usercoursedto = usercourseService.updateUserCourse(usercourseID, updatedUserCourse);
        if (usercoursedto != null) {
            return ResponseEntity.ok(usercoursedto);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserCourse(@PathVariable("id") Long usercourseID)
    {
        usercourseService.deleteUserCourse(usercourseID);
        return ResponseEntity.noContent().build();
    }
}