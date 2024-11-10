package com.formation.formation.repository;

import com.formation.formation.Entity.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository  extends JpaRepository<Formation, Integer> {
}
