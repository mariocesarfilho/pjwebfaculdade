package com.br.pjwebfaculdade.controller;

import com.br.pjwebfaculdade.exception.ResourceNotFoundException;
import com.br.pjwebfaculdade.model.Curso;
import com.br.pjwebfaculdade.respository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ccurso")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping("/curso")
    public List<Curso> listar() {
        return this.cursoRepository.findAll();
    }

    @GetMapping("/curso/{id}")
    public ResponseEntity<Curso> consultar(@PathVariable Long id) {

        Curso curso = this.cursoRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Curso não encontrado " + id));

        return ResponseEntity.ok(curso);
    }

    @PostMapping("/curso")
    public Curso inserir(@RequestBody Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @PutMapping("/curso/{id}")
    public ResponseEntity<Curso> alterar(@PathVariable Long id, @RequestBody Curso curso) {
        Curso cursoRecuperado = this.cursoRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Curso não encontrado " + id));

        cursoRecuperado.setNome(curso.getNome());
        cursoRecuperado.setArea(curso.getArea());

        Curso cursoAtualizado = this.cursoRepository.save(cursoRecuperado);

        return ResponseEntity.ok(cursoAtualizado);
    }

    @DeleteMapping("/curso/{id}")
    public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {

        Curso cursoRecuperado = this.cursoRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Curso não encontrado " + id));

        this.cursoRepository.delete(cursoRecuperado);

        Map<String, Boolean> resposta = new HashMap<>();

        resposta.put("Curso excluído com sucesso", Boolean.TRUE);

        return ResponseEntity.ok(resposta);
    }

}
