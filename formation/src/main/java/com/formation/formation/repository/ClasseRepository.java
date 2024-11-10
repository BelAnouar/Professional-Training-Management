package com.formation.formation.repository;

import com.formation.formation.Entity.Classe;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClasseRepository  extends JpaRepository<Classe,Integer> {
    Optional<Classe> findByName(String name);

    Optional<Classe> findByRoomNumber(Integer roomNumber);

    @Query("SELECT c FROM Classe c WHERE SIZE(c.apprenant) > :threshold")
    List<Classe> findClassroomsWithMoreThanStudents(@Param("threshold") int threshold);

    boolean existsByName(String name);
    boolean existsByRoomNumber(Integer roomNumber);


}
