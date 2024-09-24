package com.prj.service;

import java.util.List;

import com.prj.dto.UserCoursedto;
import com.prj.entities.UserCourse;

public interface UserCourseService {
    UserCoursedto addUserCourse(UserCoursedto coursedto);

    UserCoursedto getUserCourseById(Long courseID);

    List<UserCoursedto> getAllUserCourses();

    UserCoursedto updateUserCourse(Long courseID, UserCoursedto updatedUserCourse);

    void deleteUserCourse(Long courseID);
}
