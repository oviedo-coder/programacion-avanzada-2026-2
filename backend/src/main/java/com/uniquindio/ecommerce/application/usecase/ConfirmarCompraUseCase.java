package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConfirmarCompraUseCase {

    private final CompraRepository repository;

    @Transactional
    public void ejecutar(String compraId) {
        Compra compra = repository.obtenerPorId(compraId).orElseThrow();
        compra.confirmar();
        repository.guardar(compra);
    }
}