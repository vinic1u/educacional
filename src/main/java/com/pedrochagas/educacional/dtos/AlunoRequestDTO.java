package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequestDTO {

    private String nome;
    private String email;
    private String matricula;
    private LocalDate dataNascimento;

}
