package com.uniquindio.ecommerce.infrastructure.persistence.jpa;


import com.uniquindio.ecommerce.domain.entity.Modelo3D;
import com.uniquindio.ecommerce.domain.repository.ModeloRepository;
import com.uniquindio.ecommerce.domain.repository.Pagina;
import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.entity.Modelo3DEntity;
import com.uniquindio.ecommerce.infrastructure.persistence.jpa.mapper.ModeloPersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.uniquindio.ecommerce.domain.repository.ModeloVentas;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import java.util.List;

import java.util.EnumSet;
import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class ModeloRepositoryJpa implements ModeloRepository {

    private final ModeloJpaDataRepository dataRepository;
    private final ModeloPersistenceMapper mapper;

    @Override
    public Optional<Modelo3D> obtenerPorId(String id){
        return dataRepository.findById(id).map(mapper::toDomain);

    }

    @Override
    public Pagina<Modelo3D> buscar(String texto, Licencia licencia, int pagina, int tamano){
        String patron= (texto==null) ? "" : texto.trim();
        Set<Licencia> licencias = (licencia==null) ? EnumSet.allOf(Licencia.class) : EnumSet.of(licencia);

        Page<Modelo3DEntity> resultado = dataRepository.buscar(
                patron, licencias, PageRequest.of(pagina, tamano, Sort.by("titulo")));

        return new Pagina<>(
                resultado.getContent().stream().map(mapper::toDomain).toList(),
                resultado.getTotalElements(),
                resultado.getTotalPages(),
                resultado.getNumber(),
                resultado.getSize());

    }

    @Override
    public List<ModeloVentas> masVendidos(int limite) {
        return dataRepository.masVendidos(EstadoCompra.COMPLETADA, PageRequest.of(0, limite));
    }


}
