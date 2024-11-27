package com.pedrochagas.educacional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaRequestDTO {

    private Integer alunoId;
    private Integer turmaId;
}
