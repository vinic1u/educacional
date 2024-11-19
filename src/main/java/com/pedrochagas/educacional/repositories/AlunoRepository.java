package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno,Integer> {
}
