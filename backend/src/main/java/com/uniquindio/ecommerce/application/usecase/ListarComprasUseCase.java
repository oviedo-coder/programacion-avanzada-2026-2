package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarComprasUseCase {

    private final CompraRepository repository;

    @Transactional (readOnly = true)
    public List<Compra> ejecutar (String compradorId){
        return repository.obtenerPorCompradorId(compradorId);
    }


}