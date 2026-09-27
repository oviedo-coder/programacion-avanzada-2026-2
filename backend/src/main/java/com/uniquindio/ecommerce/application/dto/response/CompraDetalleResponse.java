package com.uniquindio.ecommerce.application.dto.response;

import java.time.LocalDateTime;

// Usado en: GET /compras/{id}
public record CompraDetalleResponse(
        String id,
        String modeloId,
        String compradorId,
        double montoPrecio,
        String estado,
        LocalDateTime fechaCompra

) {}
