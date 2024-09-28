package com.prj.projectweb.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coursedto {
    private List<CourseContentdto> courseContent;
    private Long courseId;
    private String courseName;
    private String content;
    private String courseAim;
    private String courseDuration;
    private Long courseCost;
    private String courseMethod;
    private String courseCertificate;
    private Long courseLikes;
    private LocalDateTime startTime; // Ngày bắt đầu
    private LocalDateTime endTime; // Ngày kết thúc
    private List<String> schedule; // Lịch học
    private String image; // Hình ảnh
    private int numberOfStudents; // Số lượng học viên
    private String object; // Đối tượng học viên
    private Lecturerdto lecturer; // Thêm lớp lecturer cho giảng viên
}

