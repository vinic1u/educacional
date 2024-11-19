package com.pedrochagas.educacional.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer ano;

    private Integer semestre;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Turma() {
    }

    public Turma(Integer id, Integer ano, Integer semestre, Curso curso) {
        this.id = id;
        this.ano = ano;
        this.semestre = semestre;
        this.curso = curso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
