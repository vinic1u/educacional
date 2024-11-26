package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.TurmaRequestDTO;
import com.pedrochagas.educacional.dtos.TurmaResponseDTO;
import com.pedrochagas.educacional.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<TurmaResponseDTO>> listarTurmas(){
        return ResponseEntity.ok(turmaService.listarTurmas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> buscarTurmaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(turmaService.buscarTurmaPorId(id));
    }

    @PostMapping
    public ResponseEntity<TurmaResponseDTO> salvarTurma(@RequestBody TurmaRequestDTO dto){
        TurmaResponseDTO turma = turmaService.salvarTurma(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(turma.getId())
                .toUri();
        return ResponseEntity.created(location).body(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarTurmaPorId(@PathVariable Integer id){
        turmaService.deletarTurmaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaResponseDTO> atualizarTurmaPorId(@PathVariable Integer id,@RequestBody TurmaRequestDTO dto){
        TurmaResponseDTO turma = turmaService.atualizarTurmaPorId(dto,id);
        return ResponseEntity.ok(turma);
    }
}
