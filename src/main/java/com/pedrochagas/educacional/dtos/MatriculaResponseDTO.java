package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Aluno;
import com.pedrochagas.educacional.entities.Matricula;
import com.pedrochagas.educacional.entities.Turma;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaResponseDTO {

    private Integer id;
    private AlunoResponseDTO aluno;
    private TurmaResponseDTO turma;

    public MatriculaResponseDTO(Matricula matricula){
        this.id = matricula.getId();
        this.aluno = new AlunoResponseDTO(matricula.getAluno());
        this.turma = new TurmaResponseDTO(matricula.getTurma());
    }
}
