package com.pedrochagas.educacional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaRequestDTO {

    private Integer ano;
    private Integer semestre;
    private Integer cursoId;

}
