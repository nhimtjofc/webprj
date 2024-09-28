package com.prj.projectweb.service;

import com.prj.projectweb.entities.Lecturer;
import com.prj.projectweb.repositories.LecturerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    public List<Lecturer> findAll() {
        return lecturerRepository.findAll();
    }

    public Lecturer save(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    public Lecturer findById(Long id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        lecturerRepository.deleteById(id);
    }
}
