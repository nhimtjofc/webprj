package com.prj.mapper;

import com.prj.dto.UserCoursedto;
import com.prj.entities.UserCourse;

public class UserCourseMapper {
    public static UserCoursedto mapUserCoursedto(UserCourse user_course)
    {
        return new UserCoursedto(
            user_course.getUserCourseId(),
            user_course.getUser(),
            user_course.getCourse()
        );
    }

    public static UserCourse mapUserCourse(UserCoursedto user_coursedto)
    {
        return new UserCourse(
            user_coursedto.getUserCourseId(),
            user_coursedto.getUser(),
            user_coursedto.getCourse()
        );
    }
}
