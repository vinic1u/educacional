package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.NotaRequestDTO;
import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.entities.Disciplina;
import com.pedrochagas.educacional.entities.Matricula;
import com.pedrochagas.educacional.entities.Nota;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.DisciplinaRepository;
import com.pedrochagas.educacional.repositories.MatriculaRepository;
import com.pedrochagas.educacional.repositories.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<NotaResponseDTO> listarNotas(){
        return notaRepository.findAll().stream().map(NotaResponseDTO::new).toList();
    }

    public NotaResponseDTO buscarNotaPorId(Integer id){
        Nota nota = notaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Nota com ID: " + id + " não encontrada!"));
        return new NotaResponseDTO(nota);
    }

    public NotaResponseDTO salvarNota(NotaRequestDTO dto){
        Nota nota = new Nota();
        nota.setNota(dto.getNota());
        nota.setDataLancamento(dto.getDataLancamento());

        Integer matriculaId = dto.getMatriculaId();
        Matricula matricula = matriculaRepository.findById(matriculaId).orElseThrow(()-> new RecursoNaoEncontradoException("Matricula com ID: " + matriculaId + " não encontrado"));

        Integer disciplinaId = dto.getDisciplinaId();
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + disciplinaId + " não encontrada"));

        nota.setDisciplina(disciplina);
        nota.setMatricula(matricula);

        notaRepository.save(nota);
        return new NotaResponseDTO(nota);
    }

    public NotaResponseDTO atualizarNotaPorId(Integer id,NotaRequestDTO dto){
        Nota nota = notaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Nota com ID: " + id + " não encontrada!"));
        nota.setNota(dto.getNota());
        nota.setDataLancamento(dto.getDataLancamento());

        Integer matriculaId = dto.getMatriculaId();
        Matricula matricula = matriculaRepository.findById(matriculaId).orElseThrow(()-> new RecursoNaoEncontradoException("Matricula com ID: " + matriculaId + " não encontrado"));

        Integer disciplinaId = dto.getDisciplinaId();
        Disciplina disciplina = disciplinaRepository.findById(disciplinaId).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + disciplinaId + " não encontrada"));

        nota.setDisciplina(disciplina);
        nota.setMatricula(matricula);

        notaRepository.save(nota);
        return new NotaResponseDTO(nota);
    }

    public void deletarNotaPorId(Integer id){
        Nota nota = notaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Nota com ID: " + id + " não encontrada!"));
        notaRepository.delete(nota);
    }
}
