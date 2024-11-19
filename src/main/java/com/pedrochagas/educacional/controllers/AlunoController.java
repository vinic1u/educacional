package com.pedrochagas.educacional.controllers;

import com.pedrochagas.educacional.entities.Aluno;
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
    public ResponseEntity<List<Aluno>> listarAlunos(){
        return ResponseEntity.ok(alunoService.listarAlunos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(
            @PathVariable(name = "id") Integer id){
        return ResponseEntity.ok(alunoService.buscarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno){
        aluno = alunoService.salvarAluno(aluno);
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
    public ResponseEntity<Aluno> atualizarAluno(
            @PathVariable Integer id,
            @RequestBody Aluno novosDados
    ){
        Aluno aluno = alunoService.atualizarAluno(novosDados,id);
        return ResponseEntity.ok(aluno);
    }
}
