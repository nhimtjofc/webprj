package com.prj.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prj.dto.UserCoursedto;
import com.prj.entities.UserCourse;
import com.prj.service.UserCourseService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



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
