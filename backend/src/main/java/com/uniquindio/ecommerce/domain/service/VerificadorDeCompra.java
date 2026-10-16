package com.uniquindio.ecommerce.domain.service;

import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;

public class VerificadorDeCompra {

    private final CompraRepository compraRepository;

    public VerificadorDeCompra(CompraRepository compraRepository){

        this.compraRepository = compraRepository;
    }
    public void verificarQuePuedeComentar (String compradorId, String modeloId){

        boolean tieneCompraCompletada = compraRepository.existeCompraCompletada(compradorId, modeloId);
        if (!tieneCompraCompletada){
            throw new ReglaDominioException("Solo puede comentar quien ya compró este producto");

        }
    }

}