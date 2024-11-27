package com.pedrochagas.educacional.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaRequestDTO {

    private Integer matriculaId;
    private Integer disciplinaId;
    private Double nota;
    private LocalDate dataLancamento;
}
