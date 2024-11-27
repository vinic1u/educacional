package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.MatriculaRequestDTO;
import com.pedrochagas.educacional.dtos.MatriculaResponseDTO;
import com.pedrochagas.educacional.entities.Aluno;
import com.pedrochagas.educacional.entities.Matricula;
import com.pedrochagas.educacional.entities.Turma;
import com.pedrochagas.educacional.exceptions.RecursoDuplicadoException;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.AlunoRepository;
import com.pedrochagas.educacional.repositories.MatriculaRepository;
import com.pedrochagas.educacional.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public List<MatriculaResponseDTO> listarMatriculas(){
        return matriculaRepository.findAll().stream().map(MatriculaResponseDTO::new).toList();
    }

    public MatriculaResponseDTO buscarMatriculaPorId(Integer id){
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Matricula com ID: " + id + " não encontrado"));
        return new MatriculaResponseDTO(matricula);
    }

    public MatriculaResponseDTO salvarMatricula(MatriculaRequestDTO dto){
        Matricula matriculaEncontrada = matriculaRepository.encontrarMatriculaPorAlunoETurma(dto.getAlunoId(),dto.getTurmaId());
        if(matriculaEncontrada != null) {
            throw new RecursoDuplicadoException("Aluno já se encontra matriculado para essa turma");
        }

        Matricula matricula = new Matricula();

        Integer alunoId = dto.getAlunoId();
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(()->new RecursoNaoEncontradoException("Aluno com ID: " + alunoId + " não encontrado"));
        matricula.setAluno(aluno);

        Integer turmaId = dto.getTurmaId();
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + turmaId + " não encontrado"));
        matricula.setTurma(turma);

        matriculaRepository.save(matricula);
        return new MatriculaResponseDTO(matricula);
    }

    public MatriculaResponseDTO atualizarMatriculaPorId(MatriculaRequestDTO dto,Integer id){
        Matricula matriculaEncontrada = matriculaRepository.encontrarMatriculaPorAlunoETurma(dto.getAlunoId(),dto.getTurmaId());
        if(matriculaEncontrada != null) {
            throw new RecursoDuplicadoException("Aluno já se encontra matriculado para essa turma");
        }

        Matricula matricula = matriculaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Matricula com ID: " + id + " não encontrado"));

        Integer alunoId = dto.getAlunoId();
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow(()->new RecursoNaoEncontradoException("Aluno com ID: " + alunoId + " não encontrado"));
        matricula.setAluno(aluno);

        Integer turmaId = dto.getTurmaId();
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + turmaId + " não encontrado"));
        matricula.setTurma(turma);

        matriculaRepository.save(matricula);
        return new MatriculaResponseDTO(matricula);
    }

    public void deletarMatriculaPorId(Integer id){
        Matricula matricula = matriculaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Matricula com ID: " + id + " não encontrado"));
        matriculaRepository.delete(matricula);
    }
}
