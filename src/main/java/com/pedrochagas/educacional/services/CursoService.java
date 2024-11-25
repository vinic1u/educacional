package com.pedrochagas.educacional.services;

import com.pedrochagas.educacional.dtos.CursoRequestDTO;
import com.pedrochagas.educacional.dtos.CursoResponseDTO;
import com.pedrochagas.educacional.entities.Curso;
import com.pedrochagas.educacional.exceptions.RecursoNaoEncontradoException;
import com.pedrochagas.educacional.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<CursoResponseDTO> listarCursos(){
        return cursoRepository.findAll().stream().map(CursoResponseDTO::new).toList();
    }

    public CursoResponseDTO buscarCursoPorId(Integer id){
        Curso curso = cursoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Curso com ID: " + id + " não encontrado"));
        return new CursoResponseDTO(curso);
    }

    public CursoResponseDTO salvarCurso(CursoRequestDTO dto){
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setCargaHoraria(dto.getCargaHoraria());
        curso.setCodigo(dto.getCodigo());

        cursoRepository.save(curso);
        return new CursoResponseDTO(curso);
    }

    public void deletarCursoPorId(Integer id){
        Curso curso = cursoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Curso com ID: " + id + " não encontrado"));
        cursoRepository.delete(curso);
    }

    public CursoResponseDTO atualizarCursoPorId(CursoRequestDTO dto,Integer id){
        Curso curso = cursoRepository.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Curso com ID: " + id + " não encontrado"));
        curso.setNome(dto.getNome());
        curso.setCodigo(dto.getCodigo());
        curso.setCargaHoraria(dto.getCargaHoraria());

        cursoRepository.save(curso);
        return new CursoResponseDTO(curso);
    }
}
