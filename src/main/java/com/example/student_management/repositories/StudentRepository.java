package com.example.student_management.repositories;

import com.example.student_management.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Student> findByCourId(int courId);
}
