package ru.mishgan325.docsa.pr8.dto;

import ru.mishgan325.docsa.pr8.model.Product;
import java.math.BigDecimal;

public record ProductResponse(
    Long id,
    String name,
    BigDecimal price,
    Integer quantity
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getQuantity()
        );
    }
}

