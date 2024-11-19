package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
