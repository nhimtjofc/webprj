
package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.UserCoursedto;
import com.prj.projectweb.entities.UserCourse;

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
