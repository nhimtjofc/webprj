
package com.prj.projectweb.service;

import com.prj.projectweb.dto.UserCoursedto;

import java.util.List;

public interface UserCourseService {
    UserCoursedto addUserCourse(UserCoursedto coursedto);

    UserCoursedto getUserCourseById(Long courseID);

    List<UserCoursedto> getAllUserCourses();

    UserCoursedto updateUserCourse(Long courseID, UserCoursedto updatedUserCourse);

    void deleteUserCourse(Long courseID);
}
