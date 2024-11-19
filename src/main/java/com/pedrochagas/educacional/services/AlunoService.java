package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.entities.Aluno;
import com.pedrochagas.educacional.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> listarAlunos(){
        return alunoRepository.findAll();
    }

    public Aluno buscarAlunoPorId(Integer id){
        return alunoRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Aluno com ID: " + id + " não encontrado"));
    }

    public Aluno salvarAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public Aluno atualizarAluno(Aluno novosDados,Integer id){
        Aluno aluno = buscarAlunoPorId(id);
        aluno.setNome(novosDados.getNome());
        aluno.setEmail(novosDados.getEmail());
        aluno.setDataNascimento(novosDados.getDataNascimento());
        aluno.setMatricula(novosDados.getMatricula());
        return alunoRepository.save(aluno);
    }

    public void deletarAlunoPorId(Integer id){
        Aluno aluno = buscarAlunoPorId(id);
        alunoRepository.delete(aluno);
    }

}
