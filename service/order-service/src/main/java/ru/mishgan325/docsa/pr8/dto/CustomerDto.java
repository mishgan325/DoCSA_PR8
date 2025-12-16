package ru.mishgan325.docsa.pr8.dto;

public record CustomerDto(
    Long id,
    Long userId,
    String name,
    String phone,
    String address
) {}

