package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
