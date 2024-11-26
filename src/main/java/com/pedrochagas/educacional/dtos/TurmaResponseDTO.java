package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Turma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaResponseDTO {

    private Integer id;

    private Integer ano;

    private Integer semestre;

    private CursoResponseDTO curso;

    public TurmaResponseDTO(Turma turma){
        this.id = turma.getId();
        this.ano = turma.getAno();
        this.semestre = turma.getSemestre();
        this.curso = new CursoResponseDTO(turma.getCurso());
    }
}
