package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorResponseDTO {

    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String especialidade;

    public ProfessorResponseDTO(Professor professor){
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.email = professor.getEmail();
        this.telefone = professor.getTelefone();
        this.especialidade = professor.getEspecialidade();
    }
}
