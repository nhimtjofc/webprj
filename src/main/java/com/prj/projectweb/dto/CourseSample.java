package com.prj.projectweb.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CourseSample {
    public static void main(String[] args) {
        // Tạo một đối tượng Coursedto
        Coursedto coursedto = new Coursedto();

        // Thiết lập các thông tin khóa học
        coursedto.setCourseId(1L); // ID của khóa học
        coursedto.setCourseName("Khóa học lập trình Java cơ bản");
        coursedto.setContent("Nội dung khóa học sẽ bao gồm cơ bản về Java.");
        coursedto.setCourseAim("Giúp học viên nắm vững kiến thức lập trình Java.");
        coursedto.setCourseDuration("3 tháng");
        coursedto.setCourseCost(3000000L); // Giá khóa học
        coursedto.setCourseMethod("Học trực tuyến");
        coursedto.setCourseCertificate("Chứng nhận hoàn thành khóa học");
        coursedto.setCourseLikes(0L); // Số lượt thích
        coursedto.setStartTime(LocalDateTime.parse(LocalDateTime.now().toString())); // Ngày bắt đầu
        coursedto.setEndTime(LocalDateTime.parse(LocalDateTime.now().plusMonths(3).toString())); // Ngày kết thúc
        coursedto.setSchedule(new ArrayList<>()); // Thêm lịch học
        coursedto.setImage("link-to-image.jpg"); // Link hình ảnh
        coursedto.setNumberOfStudents(0); // Số lượng học viên
        coursedto.setObject("Dành cho tất cả học viên yêu thích lập trình");

        // Tạo giảng viên mẫu (nếu cần)
        Lecturerdto lecturer = new Lecturerdto();
        lecturer.setId(1L); // ID giảng viên
        lecturer.setName("Nguyễn Văn A"); // Tên giảng viên
        coursedto.setLecturer(lecturer); // Thêm giảng viên vào khóa học

        // Gọi API để thêm khóa học vào database
        addCourseToDatabase(coursedto);
    }

    private static void addCourseToDatabase(Coursedto coursedto) {
        // Sử dụng RestTemplate hoặc một thư viện HTTP client khác để gửi request
        // Đảm bảo bạn đã cấu hình RestTemplate trong ứng dụng của bạn

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/api/course/create";

        ResponseEntity<ResponseMessage> response = restTemplate.postForEntity(url, coursedto, ResponseMessage.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Khóa học đã được thêm thành công: " + response.getBody().getCourseName());
        } else {
            System.out.println("Lỗi khi thêm khóa học: " + response.getBody().getMessage());
        }
    }
}
