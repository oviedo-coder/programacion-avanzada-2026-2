package com.uniquindio.ecommerce.domain.repository;

import java.util.Optional;
import com.uniquindio.ecommerce.domain.entity.Compra;

public interface CompraRepository {
    Optional<Compra> obtenerPorId(String id);
    void guardar(Compra compra);



}