package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import org.springframework.stereotype.Service;

@Service
public class ConfirmarCompraUseCase {

    private final CompraRepository repository;

    public ConfirmarCompraUseCase(CompraRepository repository) {
        this.repository = repository;
    }

    public void ejecutar(String compraId) {
        Compra compra = repository.obtenerPorId(compraId).orElseThrow();
        compra.confirmar();
        repository.guardar(compra);
    }
}