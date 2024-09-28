package com.prj.projectweb.entities;

import jakarta.persistence.*;
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
@Entity
@Table(name = "course")
public class Course {
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CourseContent> courseContent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    @Column(name = "Course_name")
    private String courseName;

    @Column(name = "Course_content")
    private String content;

    @Column(name = "Course_aim")
    private String courseAim;

    @Column(name = "Course_duration")
    private String courseDuration;

    @Column(name = "Course_cost")
    private Long courseCost;

    @Column(name = "Study_method")
    private String courseMethod;

    @Column(name = "Course_certificate")
    private String courseCertificate;

    @Column(name = "Course_likes")
    private Long courseLikes;

    // Các trường mới được thêm vào
    @Column(name = "Start_time")
    private LocalDateTime startTime; // Ngày bắt đầu

    @Column(name = "End_time")
    private LocalDateTime endTime; // Ngày kết thúc

    @ElementCollection
    @Column(name = "Schedule")
    private List<String> schedule; // Lịch học

    @Column(name = "Image")
    private String image; // Hình ảnh

    @Column(name = "Number_of_students")
    private int numberOfStudents; // Số lượng học viên

    @Column(name = "Target_audience")
    private String object; // Đối tượng học viên

    @ManyToOne
    @JoinColumn(name = "lecturer_id") // Liên kết với lớp Lecturer
    private Lecturer lecturer;

}
