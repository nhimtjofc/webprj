package com.prj.projectweb.mapper;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.entities.CourseContent;

public class CourseContentMapper {
    // Chuyển từ CourseContent sang CourseContentdto
    public static CourseContentdto mapCourseContentdto(CourseContent courseContent) {
        return new CourseContentdto(
                courseContent.getSession(),
                courseContent.getTitle(),
                courseContent.getDetails()
        );
    }

    // Chuyển từ CourseContentdto sang CourseContent
    public static CourseContent mapCourseContent(CourseContentdto courseContentdto, Course course) {
        return new CourseContent(
                courseContentdto.getSession(),
                courseContentdto.getTitle(),
                courseContentdto.getDetails(),
                course // Thiết lập course liên kết
        );
    }
}
