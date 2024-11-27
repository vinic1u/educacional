package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.NotaRequestDTO;
import com.pedrochagas.educacional.dtos.NotaResponseDTO;
import com.pedrochagas.educacional.dtos.ProfessorRequestDTO;
import com.pedrochagas.educacional.dtos.ProfessorResponseDTO;
import com.pedrochagas.educacional.services.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @GetMapping
    public ResponseEntity<List<NotaResponseDTO>> listarNotas(){
        return ResponseEntity.ok(notaService.listarNotas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> buscarNotaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(notaService.buscarNotaPorId(id));
    }

    @PostMapping
    public ResponseEntity<NotaResponseDTO> salvarNota(@RequestBody NotaRequestDTO dto){
        NotaResponseDTO nota = notaService.salvarNota(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(nota.getId())
                .toUri();
        return ResponseEntity.created(location).body(nota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarNotaPorId(@PathVariable Integer id){
        notaService.deletarNotaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaResponseDTO> atualizarNota(
            @PathVariable Integer id,
            @RequestBody NotaRequestDTO dto
    ){
        NotaResponseDTO nota = notaService.atualizarNotaPorId(id,dto);
        return ResponseEntity.ok(nota);
    }
}
