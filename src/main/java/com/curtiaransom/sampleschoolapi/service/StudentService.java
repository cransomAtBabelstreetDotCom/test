package com.curtiaransom.sampleschoolapi.service;

import com.curtiaransom.sampleschoolapi.persistance.model.Student;
import com.curtiaransom.sampleschoolapi.persistance.repository.IStudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{

    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
