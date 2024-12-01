package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.DisciplinaRequestDTO;
import com.pedrochagas.educacional.dtos.DisciplinaResponseDTO;
import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.entities.Curso;
import com.pedrochagas.educacional.entities.Disciplina;
import com.pedrochagas.educacional.entities.Professor;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.CursoRepository;
import com.pedrochagas.educacional.repositories.DisciplinaRepository;
import com.pedrochagas.educacional.repositories.NotaRepository;
import com.pedrochagas.educacional.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<DisciplinaResponseDTO> listarDisciplinas(){
        return disciplinaRepository.findAll().stream().map(DisciplinaResponseDTO::new).toList();
    }

    public DisciplinaResponseDTO buscarDisciplinaPorId(Integer id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + id + " não encontrada"));
        return new DisciplinaResponseDTO(disciplina);
    }

    public DisciplinaResponseDTO salvarDisciplina(DisciplinaRequestDTO dto){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setCodigo(dto.getCodigo());

        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow(()-> new RecursoNaoEncontradoException("Curso com ID: " + dto.getCursoId() + " não encontrada"));
        disciplina.setCurso(curso);

        Professor professor = professorRepository.findById(dto.getProfessorId()).orElseThrow(()-> new RecursoNaoEncontradoException("Professor com ID: " + dto.getProfessorId() + " não encontrado"));
        disciplina.setProfessor(professor);

        disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDTO(disciplina);
    }

    public void deletarDisciplinaPorId(Integer id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + id + " não encontrada"));
        disciplinaRepository.delete(disciplina);
    }

    public DisciplinaResponseDTO atualizarDisciplinaPorId(DisciplinaRequestDTO dto,Integer id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + id + " não encontrada"));
        disciplina.setNome(dto.getNome());
        disciplina.setCodigo(dto.getCodigo());

        Curso curso = cursoRepository.findById(dto.getCursoId()).orElseThrow(()-> new RecursoNaoEncontradoException("Curso com ID: " + dto.getCursoId() + " não encontrada"));
        disciplina.setCurso(curso);

        Professor professor = professorRepository.findById(dto.getProfessorId()).orElseThrow(()-> new RecursoNaoEncontradoException("Professor com ID: " + dto.getProfessorId() + " não encontrado"));
        disciplina.setProfessor(professor);

        disciplinaRepository.save(disciplina);
        return new DisciplinaResponseDTO(disciplina);
    }

    public List<NotaResponseDTO> listarNotasPorDisciplina(Integer id){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Disciplina com ID: " + id + " não encontrada"));
        return notaRepository.listarNotasPorDisciplina(id).stream().map(NotaResponseDTO::new).toList();

    }
}
