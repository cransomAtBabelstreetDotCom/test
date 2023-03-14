package com.curtiaransom.sampleschoolapi.service;

import com.curtiaransom.sampleschoolapi.persistance.model.Student;

import java.util.Optional;

public interface IStudentService {

    Optional<Student> findById(Long id);

    Student save(Student student);

    Iterable<Student> findAll();

    void delete(Long id);

}
