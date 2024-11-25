package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponseDTO {

    private Integer id;

    private String nome;

    private String codigo;

    private Integer cargaHoraria;

    public CursoResponseDTO(Curso curso){
        this.id = curso.getId();
        this.nome = curso.getNome();
        this.cargaHoraria = curso.getCargaHoraria();
        this.codigo = curso.getCodigo();
    }
}
