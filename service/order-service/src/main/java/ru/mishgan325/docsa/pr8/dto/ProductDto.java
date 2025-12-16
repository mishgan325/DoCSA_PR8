package ru.mishgan325.docsa.pr8.dto;

import java.math.BigDecimal;

public record ProductDto(
    Long id,
    String name,
    BigDecimal price,
    Integer quantity
) {}

