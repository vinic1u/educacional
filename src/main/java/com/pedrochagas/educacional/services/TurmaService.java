package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.dtos.TurmaRequestDTO;
import com.pedrochagas.educacional.dtos.TurmaResponseDTO;
import com.pedrochagas.educacional.entities.Curso;
import com.pedrochagas.educacional.entities.Nota;
import com.pedrochagas.educacional.entities.Turma;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.CursoRepository;
import com.pedrochagas.educacional.repositories.NotaRepository;
import com.pedrochagas.educacional.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private NotaRepository notaRepository;

    public List<TurmaResponseDTO> listarTurmas(){
        return turmaRepository.findAll().stream().map(TurmaResponseDTO::new).toList();
    }

    public TurmaResponseDTO buscarTurmaPorId(Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + id + " não encontrado"));
        return new TurmaResponseDTO(turma);
    }

    public TurmaResponseDTO salvarTurma(TurmaRequestDTO dto){
        Turma turma = new Turma();
        turma.setAno(dto.getAno());
        turma.setSemestre(dto.getSemestre());

        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow(()->new RecursoNaoEncontradoException("Curso com ID: " + dto.getCursoId() + " não encontrado"));
        turma.setCurso(curso);

        turmaRepository.save(turma);
        return new TurmaResponseDTO(turma);
    }

    public void deletarTurmaPorId(Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + id + " não encontrado"));
        turmaRepository.delete(turma);
    }

    public TurmaResponseDTO atualizarTurmaPorId(TurmaRequestDTO dto,Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + id + " não encontrado"));
        turma.setAno(dto.getAno());
        turma.setSemestre(dto.getSemestre());

        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow(()->new RecursoNaoEncontradoException("Curso com ID: " + dto.getCursoId() + " não encontrado"));
        turma.setCurso(curso);

        turmaRepository.save(turma);
        return new TurmaResponseDTO(turma);
    }

    public List<NotaResponseDTO> listarNotasPorTurma(Integer id){
        Turma turma = turmaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Turma com ID: " + id + " não encontrado"));
        List<Nota> notas = notaRepository.listarNotasPorTurma(id);
        return notas.stream().map(NotaResponseDTO::new).toList();
    }
}
