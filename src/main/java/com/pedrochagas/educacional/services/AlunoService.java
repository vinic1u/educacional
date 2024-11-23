package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.AlunoRequestDTO;
import com.pedrochagas.educacional.dtos.AlunoResponseDTO;
import com.pedrochagas.educacional.entities.Aluno;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<AlunoResponseDTO> listarAlunos(){
        return alunoRepository.findAll().stream().map(AlunoResponseDTO::new).toList();
    }

    public AlunoResponseDTO buscarAlunoPorId(Integer id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Aluno com ID: " + id + " não encontrado"));
        return new AlunoResponseDTO(aluno);
    }

    public AlunoResponseDTO salvarAluno(AlunoRequestDTO dto){
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setMatricula(dto.getMatricula());

        alunoRepository.save(aluno);
        return new AlunoResponseDTO(aluno);
    }

    public AlunoResponseDTO atualizarAluno(AlunoRequestDTO dto,Integer id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Aluno com ID: " + id + " não encontrado"));
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setMatricula(dto.getMatricula());

        alunoRepository.save(aluno);
        return new AlunoResponseDTO(aluno);
    }

    public void deletarAlunoPorId(Integer id){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Aluno com ID: " + id + " não encontrado"));
        alunoRepository.delete(aluno);
    }

}
