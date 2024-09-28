package com.prj.projectweb.service;

import com.prj.projectweb.dto.CourseContentdto;
import com.prj.projectweb.entities.CourseContent;
import com.prj.projectweb.entities.Course;
import com.prj.projectweb.mapper.CourseContentMapper;
import com.prj.projectweb.repositories.CourseContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseContentService {

    @Autowired
    private CourseContentRepository courseContentRepository;

    // Phương thức để thêm CourseContent
    public CourseContentdto addCourseContent(CourseContentdto courseContentdto, Course course) {
        CourseContent courseContent = CourseContentMapper.mapCourseContent(courseContentdto, course);
        CourseContent savedContent = courseContentRepository.save(courseContent);
        return CourseContentMapper.mapCourseContentdto(savedContent);
    }

    // Phương thức để lấy tất cả CourseContent
    public List<CourseContentdto> getAllCourseContents() {
        return courseContentRepository.findAll().stream()
                .map(CourseContentMapper::mapCourseContentdto)
                .collect(Collectors.toList());
    }

    // Có thể thêm các phương thức khác như getById, update, delete
}
