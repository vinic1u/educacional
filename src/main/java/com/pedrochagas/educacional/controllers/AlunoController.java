package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.AlunoRequestDTO;
import com.pedrochagas.educacional.dtos.AlunoResponseDTO;
import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.entities.Aluno;
import com.pedrochagas.educacional.projections.AlunoNotaProjection;
import com.pedrochagas.educacional.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> listarAlunos(){
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> buscarAlunoPorId(
            @PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @GetMapping("/{id}/notas")
    public ResponseEntity<List<AlunoNotaProjection>> listarNotasDoAluno(
            @PathVariable Integer id
    ){
        return ResponseEntity.ok(alunoService.listarNotasDoAluno(id));
    }

    @PostMapping
    public ResponseEntity<AlunoResponseDTO> salvarAluno(@RequestBody AlunoRequestDTO dto){
        AlunoResponseDTO aluno = alunoService.salvarAluno(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aluno.getId())
                .toUri();
        return ResponseEntity.created(location).body(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAlunoPorId(@PathVariable Integer id){
        alunoService.deletarAlunoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoResponseDTO> atualizarAluno(
            @PathVariable Integer id,
            @RequestBody AlunoRequestDTO dto
    ){
        AlunoResponseDTO aluno = alunoService.atualizarAluno(dto,id);
        return ResponseEntity.ok(aluno);
    }


}
