package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.dtos.CursoRequestDTO;
import com.pedrochagas.educacional.dtos.CursoResponseDTO;
import com.pedrochagas.educacional.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<CursoResponseDTO>> listarCursos(){
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> buscarCursoPorId(@PathVariable Integer id){
        return ResponseEntity.ok(cursoService.buscarCursoPorId(id));
    }

    @PostMapping
    public ResponseEntity<CursoResponseDTO> salvarCurso(@RequestBody CursoRequestDTO dto){
        CursoResponseDTO curso = cursoService.salvarCurso(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(curso.getId())
                .toUri();
        return ResponseEntity.created(location).body(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCursoPorId(@PathVariable Integer id){
        cursoService.deletarCursoPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDTO> atualizarCursoPorId(@RequestBody CursoRequestDTO dto,@PathVariable Integer id){
        CursoResponseDTO curso = cursoService.atualizarCursoPorId(dto,id);
        return ResponseEntity.ok(curso);
    }

}
