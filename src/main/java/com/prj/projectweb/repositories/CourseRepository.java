package com.prj.projectweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prj.projectweb.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{

}