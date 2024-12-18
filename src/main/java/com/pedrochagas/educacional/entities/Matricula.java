package com.pedrochagas.educacional.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_matricula")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "aluno_id",referencedColumnName = "id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "turma_id",referencedColumnName = "id")
    private Turma turma;

    @OneToMany(mappedBy = "matricula")
    private List<Nota> notas = new ArrayList<>();
}
