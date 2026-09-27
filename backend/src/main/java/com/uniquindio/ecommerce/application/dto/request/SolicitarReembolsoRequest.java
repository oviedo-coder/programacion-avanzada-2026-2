package com.uniquindio.ecommerce.application.dto.request;

import jakarta.validation.constraints.*;

// Mapea a: Compra.solicitarReembolso()
public record SolicitarReembolsoRequest(
    @NotBlank(message = "El motivo es obligatorio")
    @Size(min = 10, max = 500)
    String motivo

) {}