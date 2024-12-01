package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.DisciplinaRequestDTO;
import com.pedrochagas.educacional.dtos.DisciplinaResponseDTO;
import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {


    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> listarDisciplinas(){
        return ResponseEntity.ok(disciplinaService.listarDisciplinas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> buscarDisciplinaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(disciplinaService.buscarDisciplinaPorId(id));
    }

    @GetMapping("/{id}/notas")
    public ResponseEntity<List<NotaResponseDTO>> listarNotasPorDisciplina(@PathVariable Integer id){
        return ResponseEntity.ok(disciplinaService.listarNotasPorDisciplina(id));
    }

    @PostMapping
    public ResponseEntity<DisciplinaResponseDTO> salvarDisciplina(@RequestBody DisciplinaRequestDTO dto){
        DisciplinaResponseDTO disciplina = disciplinaService.salvarDisciplina(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(disciplina.getId())
                .toUri();
        return ResponseEntity.created(location).body(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplinaPorId(@PathVariable Integer id){
        disciplinaService.deletarDisciplinaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaResponseDTO> atualizarDisciplinaPorId(@RequestBody DisciplinaRequestDTO dto,@PathVariable Integer id){
        DisciplinaResponseDTO disciplina = disciplinaService.atualizarDisciplinaPorId(dto,id);
        return ResponseEntity.ok(disciplina);
    }
}
