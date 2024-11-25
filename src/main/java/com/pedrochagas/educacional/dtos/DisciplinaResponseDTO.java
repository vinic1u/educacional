package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaResponseDTO {

    private Integer id;
    private String nome;
    private String codigo;
    private CursoResponseDTO curso;
    private ProfessorResponseDTO professor;

    public DisciplinaResponseDTO(Disciplina disciplina){
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.codigo = disciplina.getCodigo();
        this.curso = new CursoResponseDTO(disciplina.getCurso());
        this.professor = new ProfessorResponseDTO(disciplina.getProfessor());
    }
}
