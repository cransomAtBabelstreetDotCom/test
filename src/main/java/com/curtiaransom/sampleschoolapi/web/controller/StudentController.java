package com.curtiaransom.sampleschoolapi.web.controller;

import com.curtiaransom.sampleschoolapi.persistance.model.Student;
import com.curtiaransom.sampleschoolapi.service.StudentService;
import com.curtiaransom.sampleschoolapi.web.dto.StudentDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value ="/{id}")
    public StudentDto findOne(@PathVariable Long id) {
        Student student = studentService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(student);
    }

    @GetMapping
    public Collection<StudentDto> findAll() {
        Iterable<Student> allStudents = studentService.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        allStudents.forEach(s -> studentDtos.add(convertToDto(s)));
        return studentDtos;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createStudent(@RequestBody StudentDto newStudentDto) {
        Student entity = convertToEntity(newStudentDto);
        Student student = studentService.save(entity);
        return convertToDto(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
    }

    protected StudentDto convertToDto(Student student) {
        return new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName());
    }
    protected Student convertToEntity(StudentDto studentDto) {
        Student student = new Student(studentDto.firstName(), studentDto.lastName());

        if (!Objects.isNull(studentDto.id())) {
            student.setId(studentDto.id());
        }

        return student;
    }

}
