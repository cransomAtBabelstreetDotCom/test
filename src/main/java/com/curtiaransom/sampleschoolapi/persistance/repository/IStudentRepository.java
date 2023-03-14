package com.curtiaransom.sampleschoolapi.persistance.repository;

import com.curtiaransom.sampleschoolapi.persistance.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Long> {
}
