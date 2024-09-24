package com.prj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}
