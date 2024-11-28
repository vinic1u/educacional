package com.pedrochagas.educacional.repositories;

import com.pedrochagas.educacional.entities.Nota;
import com.pedrochagas.educacional.projections.AlunoNotaProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota,Integer> {


    @Query(nativeQuery = true,
        value = "SELECT n.nota,n.data_lancamento,a.nome as aluno,d.nome as disciplina " +
                "FROM tb_nota n " +
                "INNER JOIN tb_matricula m ON n.matricula_id  = m.id " +
                "INNER JOIN tb_aluno a ON m.aluno_id  = a.id " +
                "INNER JOIN tb_disciplina d ON n.disciplina_id = d.id " +
                "WHERE a.id = :alunoId"
    )
    List<AlunoNotaProjection> listarNotasPorAluno(Integer alunoId);
}
