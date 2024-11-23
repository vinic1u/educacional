package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponseDTO {

    private Integer id;
    private String nome;
    private String email;
    private String matricula;
    private LocalDate dataNascimento;

    public AlunoResponseDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.matricula = aluno.getMatricula();
        this.dataNascimento = aluno.getDataNascimento();
    }

}
