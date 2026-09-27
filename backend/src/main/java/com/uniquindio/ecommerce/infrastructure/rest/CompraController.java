package com.uniquindio.ecommerce.infrastructure.rest;

import com.uniquindio.ecommerce.application.usecase.RealizarCompraUseCase;
import com.uniquindio.ecommerce.application.usecase.CancelarCompraUseCase;
import com.uniquindio.ecommerce.application.usecase.ConfirmarCompraUseCase;
import com.uniquindio.ecommerce.application.dto.request.RealizarCompraRequest;
import com.uniquindio.ecommerce.application.dto.response.CompraDetalleResponse;
import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.valueobject.Precio;
import com.uniquindio.ecommerce.infrastructure.rest.mapper.CompraMapper;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController    //Está maneja peticiones HTTP -> JSON
@RequestMapping("/api/compras")
public class CompraController {

    private final RealizarCompraUseCase realizarCompraUseCase;
    private final ConfirmarCompraUseCase confirmarCompraUseCase;
    private final CompraMapper mapper;

    public CompraController(RealizarCompraUseCase realizarCompraUseCase,
                            ConfirmarCompraUseCase confirmarCompraUseCase,
                            CompraMapper mapper) {
        this.realizarCompraUseCase = realizarCompraUseCase;
        this.confirmarCompraUseCase = confirmarCompraUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CompraDetalleResponse> crear (@Valid @RequestBody RealizarCompraRequest request){
        Precio precioActual = new Precio(15000, "COP");
        Compra compra = realizarCompraUseCase.ejecutar("id-generado", request.modeloId(), request.compradorId(),  precioActual);

        CompraDetalleResponse response = mapper.toDetalleResponse(compra);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(compra.getId())
                .toUri();
        return ResponseEntity.created(location).body(response); //-> 201 = created

    }
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Void> confirmar (@PathVariable String id){
        confirmarCompraUseCase.ejecutar(id);
        return ResponseEntity.ok().build(); // 200 OK

    }

}