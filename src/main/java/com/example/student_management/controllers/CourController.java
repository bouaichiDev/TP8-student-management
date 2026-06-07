package com.example.student_management.controllers;

import com.example.student_management.dto.CourResponseDTO;
import com.example.student_management.dto.StudentResponseDTO;
import com.example.student_management.services.CourService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cours")
public class CourController {

    private final CourService courService;

    public CourController(CourService courService) {
        this.courService = courService;
    }


    @GetMapping("/{id}/listStudents")
    public List<StudentResponseDTO> getStudentsByCourId(@PathVariable int id) {
        return courService.getStudentsByCourId(id);
    }

    @GetMapping("/searchDate")
    public List<CourResponseDTO> getCoursBetweenDates( @RequestParam
                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                           Date dateDebut,

                                                       @RequestParam
                                                           @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                           Date dateFin) {
        return courService.getCoursBetweenDates(dateDebut, dateFin);
    }
}
