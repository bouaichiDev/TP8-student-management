package com.example.student_management.services;

import com.example.student_management.dto.CourResponseDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.CourMapper;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repositories.CourRepository;
import com.example.student_management.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourService {

    private final CourRepository courRepository;
    private final CourMapper courMapper;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public CourService(CourRepository courRepository, CourMapper courMapper,
                       StudentRepository studentRepository, StudentMapper studentMapper) {
        this.courRepository = courRepository;
        this.courMapper = courMapper;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }


    public List<StudentResponseDTO> getStudentsByCourId(int courId) {

        return studentRepository.findByCourId(courId)
                .stream()
                .map(studentMapper::toResponseDTO)
                .toList();
    }

    public List<CourResponseDTO> getCoursBetweenDates(Date dateDebut, Date dateFin) {
        return courRepository.findCoursBetweenDates(dateDebut, dateFin)
                .stream()
                .map(courMapper::toResponseDTO)
                .toList();
    }
}
