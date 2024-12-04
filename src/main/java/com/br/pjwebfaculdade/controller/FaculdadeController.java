package com.br.pjwebfaculdade.controller;

import com.br.pjwebfaculdade.exception.ResourceNotFoundException;
import com.br.pjwebfaculdade.model.Faculdade;
import com.br.pjwebfaculdade.respository.FaculdadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cfaculdade")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class FaculdadeController {

    @Autowired
    private FaculdadeRepository faculdadeRepository;

    //Listar Faculdades
    @GetMapping("/faculdade")
    public List<Faculdade> listar(){
        return this.faculdadeRepository.findAll();
    }

    //Consultar Faculdades
    @GetMapping("/faculdade/{id}")
    public ResponseEntity<Faculdade> consultar(@PathVariable Long id) {

        Faculdade faculdade = this.faculdadeRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Faculdade não encontrada " + id));

        return ResponseEntity.ok(faculdade);
    }

    //Inserir Faculdades
    @PostMapping("/faculdade")
    public Faculdade inserir(@RequestBody Faculdade faculdade) {
        return this.faculdadeRepository.save(faculdade);
    }

    //Alterar Faculdades
    @PutMapping("/faculdade/{id}")
    public ResponseEntity<Faculdade> alterar(@PathVariable Long id, @RequestBody Faculdade faculdade) {

        Faculdade faculdadeRecuperado = this.faculdadeRepository.findById(id).orElseThrow(()
            -> new ResourceNotFoundException("Faculdade não encontrada " + id));

        faculdadeRecuperado.setId(faculdade.getId());
        faculdadeRecuperado.setNome(faculdade.getNome());
        faculdadeRecuperado.setEmail(faculdade.getEmail());

        Faculdade faculdadeAtualizado = this.faculdadeRepository.save(faculdadeRecuperado);

        return ResponseEntity.ok(faculdadeAtualizado);
    }

    //Excluir Faculdade
    @DeleteMapping("/faculdade/{id}")
    public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id) {

        Faculdade faculdadeRecuperado = this.faculdadeRepository.findById(id).orElseThrow(()
        -> new ResourceNotFoundException("Faculdade não encontrada " + id));

        this.faculdadeRepository.delete(faculdadeRecuperado);

        Map<String, Boolean> resposta = new HashMap<>();

        resposta.put("Excluido com sucesso: ", Boolean.TRUE);

        return ResponseEntity.ok(resposta);
    }
}
