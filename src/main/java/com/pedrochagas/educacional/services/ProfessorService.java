package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.ProfessorRequestDTO;
import com.pedrochagas.educacional.dtos.ProfessorResponseDTO;
import com.pedrochagas.educacional.entities.Professor;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;


    public List<ProfessorResponseDTO> listarProfessores(){
        return professorRepository.findAll().stream().map(ProfessorResponseDTO::new).toList();
    }

    public ProfessorResponseDTO buscarProfessorPorId(Integer id){
        Professor professor = professorRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Professor com ID: " + id + " não encontrado"));
        return new ProfessorResponseDTO(professor);
    }

    public ProfessorResponseDTO salvarProfessor(ProfessorRequestDTO dto){
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setTelefone(dto.getTelefone());
        professor.setEspecialidade(dto.getEspecialidade());

        professorRepository.save(professor);
        return new ProfessorResponseDTO(professor);
    }

    public ProfessorResponseDTO atualizarProfessorPorId(Integer id,ProfessorRequestDTO dto){
        Professor professor = professorRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Professor com ID: " + id + " não encontrado"));
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setTelefone(dto.getTelefone());
        professor.setEspecialidade(dto.getEspecialidade());

        professorRepository.save(professor);
        return new ProfessorResponseDTO(professor);
    }

    public void deleterProfessorPorId(Integer id){
        Professor professor = professorRepository.findById(id).orElseThrow(()-> new RecursoNaoEncontradoException("Professor com ID: " + id + " não encontrado"));
        professorRepository.delete(professor);
    }
}
