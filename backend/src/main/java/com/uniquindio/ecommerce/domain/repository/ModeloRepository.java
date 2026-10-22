package com.uniquindio.ecommerce.domain.repository;

import com.uniquindio.ecommerce.domain.entity.Modelo3D;
import com.uniquindio.ecommerce.domain.valueobject.Licencia;

import java.util.List;
import java.util.Optional;

public interface ModeloRepository {

    Optional<Modelo3D> obtenerPorId(String id); //Cajita etiqueta No exista

    Pagina<Modelo3D> buscar(String texto, Licencia licencia, int pagina, int tamano);

    List<ModeloVentas> masVendidos(int limite);
}