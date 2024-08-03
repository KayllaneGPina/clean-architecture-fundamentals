package br.com.example.clean_architecture.application.web;

public record TaskRequest(
        String title,
        String description,
        String status
)
{ }
