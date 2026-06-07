package com.example.student_management.dto;

import java.util.Date;
import java.util.List;

public record CourResponseDTO(
        int id,
        String titre,
        String description,
        Date dateDebut,
        Date dateFin
 ) {
}
