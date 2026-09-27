package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import org.springframework.stereotype.Service;

@Service
public class CancelarCompraUseCase {

    private final CompraRepository repository;

    public CancelarCompraUseCase(CompraRepository repository){
        this.repository = repository;
    }

    public void ejecutar(String compraId, String motivo){
        Compra compra = repository.obtenerPorId(compraId).orElseThrow();
        compra.solicitarReembolso(motivo);
        repository.guardar(compra);

    }

}