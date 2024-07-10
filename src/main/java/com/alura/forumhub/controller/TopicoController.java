package com.alura.forumhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.alura.forumhub.model.Topico;
import com.alura.forumhub.repository.TopicoRepository;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')") // Apenas usuários com a role USER podem criar tópicos
    public ResponseEntity<Topico> criar(@RequestBody Topico topico) {
        Topico novoTopico = topicoRepository.save(topico);
        return ResponseEntity.ok(novoTopico);
    }

    // Outros endpoints podem ser configurados de forma semelhante
}
