package com.pedrochagas.educacional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequestDTO {
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;
}
