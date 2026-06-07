package com.example.student_management.services;

import com.example.student_management.dto.StudentRequestDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDTO addStudent(StudentRequestDTO dto) {
        Student student = studentMapper.toEntity(dto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toResponseDTO)
                .toList();
    }

    public StudentResponseDTO getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        return studentMapper.toResponseDTO(student);
    }

    public StudentResponseDTO updateStudent(int id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        studentMapper.updateEntityFromDTO(dto, student);
        Student updatedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(updatedStudent);
    }

    public void deleteStudent(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Étudiant introuvable avec l'id : " + id));

        studentRepository.delete(student);
    }
}
