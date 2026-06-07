package com.example.student_management.repositories;

import com.example.student_management.entity.Cour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourRepository extends JpaRepository<Cour, Integer> {

    @Query("SELECT c FROM Cour c WHERE c.dateDebut >= :dateDebut AND c.dateFin <= :dateFin")
    List<Cour> findCoursBetweenDates(Date dateDebut, Date dateFin);
}
