package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RealizarCompraUseCase {

    private final CompraRepository repository;

    @Transactional
    public Compra ejecutar(String id, String modeloId, String compradorId, Precio precioActual) {
        Compra compra = Compra.realizar(id, modeloId, compradorId, precioActual);
        repository.guardar(compra);
        return compra;
    }
}