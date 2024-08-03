package br.com.example.clean_architecture.application.web;

public record TaskResponse(
        Long id,
        String title,
        String description,
        String status
) {}
