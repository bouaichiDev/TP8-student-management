package com.example.student_management.mapper;

import com.example.student_management.dto.CourRequestDTO;
import com.example.student_management.dto.CourResponseDTO;
import com.example.student_management.entity.Cour;
import org.springframework.stereotype.Component;

@Component
public class CourMapper {



    public Cour toEntity(CourRequestDTO dto) {
        Cour cour = new Cour();
        cour.setTitre(dto.titre());
        cour.setDescription(dto.description());
        cour.setDateDebut(dto.dateDebut());
        cour.setDateFin(dto.dateFin());
        return cour;
    }

    public CourResponseDTO toResponseDTO(Cour cour) {
        return new CourResponseDTO(
                cour.getId(),
                cour.getTitre(),
                cour.getDescription(),
                cour.getDateDebut(),
                cour.getDateFin()

        );
    }

    public void updateEntityFromDTO(CourRequestDTO dto, Cour cour) {
        cour.setTitre(dto.titre());
        cour.setDescription(dto.description());
        cour.setDateDebut(dto.dateDebut());
        cour.setDateFin(dto.dateFin());
    }
}
