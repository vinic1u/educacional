package com.pedrochagas.educacional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequestDTO {

    private String nome;

    private String codigo;

    private Integer cargaHoraria;
}
