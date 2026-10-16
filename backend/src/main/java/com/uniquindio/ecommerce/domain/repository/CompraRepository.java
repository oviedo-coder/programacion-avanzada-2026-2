package com.uniquindio.ecommerce.domain.repository;

import java.util.List;
import java.util.Optional;
import com.uniquindio.ecommerce.domain.entity.Compra;

    public interface CompraRepository {
        Optional<Compra> obtenerPorId(String id);
        void guardar(Compra compra);
        boolean existeCompraCompletada (String compradorId, String modeloID);
        List<Compra> obtenerPorCompradorId(String compradorId);
    }
