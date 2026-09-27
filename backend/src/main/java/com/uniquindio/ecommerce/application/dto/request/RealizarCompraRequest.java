package com.uniquindio.ecommerce.application.dto.request;

import jakarta.validation.constraints.*;

// Mapea a: Compra.realizar()
public record RealizarCompraRequest(
        @NotBlank(message = "El modelo es obligatorio")
        String modeloId,

        @NotBlank(message = "El comprador es obligatorio")
        String compradorId


) {}

