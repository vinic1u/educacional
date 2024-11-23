package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.AlunoRequestDTO;
import com.pedrochagas.educacional.dtos.AlunoResponseDTO;
import com.pedrochagas.educacional.dtos.ProfessorRequestDTO;
import com.pedrochagas.educacional.dtos.ProfessorResponseDTO;
import com.pedrochagas.educacional.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDTO>> listarProfessores(){
        return ResponseEntity.ok(professorService.listarProfessores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> buscarProfessorPorId(@PathVariable Integer id){
        return ResponseEntity.ok(professorService.buscarProfessorPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDTO> salvarProfessor(@RequestBody ProfessorRequestDTO dto){
        ProfessorResponseDTO professor = professorService.salvarProfessor(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(professor.getId())
                .toUri();
        return ResponseEntity.created(location).body(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Integer id){
        professorService.deleterProfessorPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDTO> atualizarAluno(
            @PathVariable Integer id,
            @RequestBody ProfessorRequestDTO dto
    ){
        ProfessorResponseDTO professor = professorService.atualizarProfessorPorId(id,dto);
        return ResponseEntity.ok(professor);
    }


}
