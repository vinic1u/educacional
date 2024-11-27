package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.MatriculaRequestDTO;
import com.pedrochagas.educacional.dtos.MatriculaResponseDTO;
import com.pedrochagas.educacional.services.MatriculaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<MatriculaResponseDTO>> listarMatriculas(){
        return ResponseEntity.ok(matriculaService.listarMatriculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> buscarMatriculaPorId(@PathVariable Integer id){
        return ResponseEntity.ok(matriculaService.buscarMatriculaPorId(id));
    }

    @PostMapping
    public ResponseEntity<MatriculaResponseDTO> salvarMatricula(@RequestBody MatriculaRequestDTO dto){
        MatriculaResponseDTO matricula = matriculaService.salvarMatricula(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(matricula.getId())
                .toUri();
        return ResponseEntity.created(location).body(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMatriculaPorId(@PathVariable Integer id){
        matriculaService.deletarMatriculaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaResponseDTO> atualizarMatriculaPorId(@PathVariable Integer id,@RequestBody MatriculaRequestDTO dto){
        MatriculaResponseDTO matricula = matriculaService.atualizarMatriculaPorId(dto, id);
        return ResponseEntity.ok(matricula);
    }
}
