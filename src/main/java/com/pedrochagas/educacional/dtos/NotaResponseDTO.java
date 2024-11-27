package com.pedrochagas.educacional.dtos;

import com.pedrochagas.educacional.entities.Nota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotaResponseDTO {
    private Integer id;
    private MatriculaResponseDTO matricula;
    private DisciplinaResponseDTO disciplina;
    private Double nota;
    private LocalDate dataLancamento;

    public NotaResponseDTO(Nota nota){
        this.id = nota.getId();
        this.matricula = new MatriculaResponseDTO(nota.getMatricula());
        this.disciplina = new DisciplinaResponseDTO(nota.getDisciplina());
        this.nota = nota.getNota();
        this.dataLancamento = nota.getDataLancamento();
    }

}
