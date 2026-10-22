package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.entity.Modelo3D;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.repository.ModeloRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RealizarCompraUseCase {

    private final CompraRepository compraRepository;
    private final ModeloRepository modeloRepository;

    @Transactional
    public Compra ejecutar(String id, String modeloId, String compradorId) {
        Modelo3D modelo = modeloRepository.obtenerPorId(modeloId).orElseThrow();
        if (modelo.estaEliminado()) {
            throw new ReglaDominioException("El modelo ya no está disponible");
        }
        Compra compra = Compra.realizar(id, modeloId, compradorId, modelo.getPrecio());
        compraRepository.guardar(compra);
        return compra;
    }
}