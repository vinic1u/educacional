package com.pedrochagas.educacional.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String codigo;

    private Integer cargaHoraria;

    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;

    public Curso() {
    }

    public Curso(Integer id, String nome, String codigo, Integer cargaHoraria, List<Turma> turmas) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.turmas = turmas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

}
