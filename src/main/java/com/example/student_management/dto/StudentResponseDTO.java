package com.example.student_management.dto;

public record StudentResponseDTO(
        int id,
        String firstName,
        String lastName,
        String email,
        String major,
        Integer age,
        Integer courId,
        String courTitre
) {
}
