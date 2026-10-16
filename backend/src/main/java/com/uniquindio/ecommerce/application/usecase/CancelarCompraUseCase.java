package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CancelarCompraUseCase {

    private final CompraRepository repository;

    @Transactional
    public void ejecutar(String compraId, String motivo) {
        Compra compra = repository.obtenerPorId(compraId).orElseThrow();
        compra.solicitarReembolso(motivo);
        repository.guardar(compra);
    }
}