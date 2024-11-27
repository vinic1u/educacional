package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT * " +
                    "FROM tb_matricula " +
                    "WHERE aluno_id = :idAluno AND " +
                    "turma_id = :idTurma"
    )
    Matricula encontrarMatriculaPorAlunoETurma(Integer idAluno,Integer idTurma);
}
