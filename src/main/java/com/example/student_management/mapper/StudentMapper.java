package com.example.student_management.mapper;

import com.example.student_management.dto.StudentRequestDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.entity.Cour;
import com.example.student_management.entity.Student;
import com.example.student_management.repositories.CourRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    private final CourRepository courRepository;

    public StudentMapper(CourRepository courRepository) {
        this.courRepository = courRepository;
    }

    public Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setMajor(dto.major());
        student.setAge(dto.age());




        return student;
    }

    public StudentResponseDTO toResponseDTO(Student student) {
        return new StudentResponseDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getMajor(),
                student.getAge(),
                student.getCour().getId(),
                student.getCour().getTitre()
        );
    }

    public void updateEntityFromDTO(StudentRequestDTO dto, Student student) {
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());
        student.setMajor(dto.major());
        student.setAge(dto.age());


    }
}
