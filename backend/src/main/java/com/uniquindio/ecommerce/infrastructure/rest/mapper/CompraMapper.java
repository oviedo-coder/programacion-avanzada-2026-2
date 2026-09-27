package com.uniquindio.ecommerce.infrastructure.rest.mapper;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.application.dto.response.CompraDetalleResponse;
import org.springframework.stereotype.Component;

@Component // Crea una instancia de esta clase y tenla lista para inyectar donde se necesite
public class CompraMapper {

    public CompraDetalleResponse toDetalleResponse(Compra compra){
        return new CompraDetalleResponse(
                compra.getId(),
                compra.getModeloId(),
                compra.getCompradorId(),
                compra.getPrecioCongelado().monto(),
                compra.getEstado().toString(),
                compra.getFechaCompra()

        );

    }


}