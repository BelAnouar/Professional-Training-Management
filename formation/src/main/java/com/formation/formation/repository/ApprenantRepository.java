package com.formation.formation.repository;

import com.formation.formation.Entity.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ApprenantRepository extends JpaRepository<Apprenant, Integer> {

    Optional<Apprenant> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Apprenant> findByPrenomContainingIgnoreCase(String prenom);


    @Query("SELECT s FROM Apprenant s WHERE s.niveau = :level AND s.classe.id = :classroomId")
    List<Apprenant> findByLevelAndClassroom(@Param("level") String level, @Param("classroomId") Long classroomId);


    @Query(value = "SELECT * FROM students s WHERE s.created_at > :date", nativeQuery = true)
    List<Apprenant> findRecentStudents(@Param("date") LocalDateTime date);



}

