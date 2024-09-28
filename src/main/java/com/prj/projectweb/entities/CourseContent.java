package com.prj.projectweb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_content")
public class CourseContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session")
    private Integer session;

    @Column(name = "title")
    private String title;

    @ElementCollection
    @CollectionTable(name = "course_content_details", joinColumns = @JoinColumn(name = "content_id"))
    @Column(name = "detail")
    private List<String> details;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    public CourseContent(Integer session, String title, List<String> details, Course course) {
        this.session = session;
        this.title = title;
        this.details = details;
        this.course = course;
    }
}
