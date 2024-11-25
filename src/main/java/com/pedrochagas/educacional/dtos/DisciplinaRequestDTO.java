package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Curso;
import com.pedrochagas.educacional.entities.Professor;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaRequestDTO {
    private String nome;

    private String codigo;

    private Integer cursoId;

    private Integer professorId;
}
