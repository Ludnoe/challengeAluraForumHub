package com.alura.forumhub.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private Boolean solucao = false;

    @ManyToOne
    private Topico topico;

    @ManyToOne
    private Usuario autor;

    // Getters e Setters
}
