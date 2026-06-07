package com.example.student_management.dto;

import jakarta.validation.constraints.*;

import java.util.Date;

public record CourRequestDTO(
        @NotBlank(message = "Le titre est obligatoire")
        String titre,

        @NotBlank(message = "Le nom est description")
        String description,

        @NotNull(message = "Date debut est obligatoire")
        Date dateDebut,

        @NotNull(message = "Date fin est obligatoire")
        Date dateFin
) {
}
