package com.uniquindio.ecommerce.application.usecase;


import com.uniquindio.ecommerce.domain.entity.Modelo3D;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import com.uniquindio.ecommerce.domain.repository.ModeloRepository;
import com.uniquindio.ecommerce.domain.repository.Pagina;
import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.uniquindio.ecommerce.domain.repository.ModeloVentas;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultarCatalogoUseCase {

    private static final int TAMANO_MAXIMO = 50;
    private static final int RANKING_MAXIMO = 20;

    private final ModeloRepository repository;


    @Transactional(readOnly = true)
    public Pagina<Modelo3D> buscar (String texto, Licencia licencia, int pagina, int tamano){
        if (pagina< 0){
            throw new ReglaDominioException("La página no puede ser negativa");
        }
        if (tamano < 1 || tamano > TAMANO_MAXIMO){
            throw new ReglaDominioException("El tam de la pag debe estar entre 1 y " + TAMANO_MAXIMO);
        }
        return repository.buscar(texto,licencia,pagina,tamano);
    }

    @Transactional(readOnly = true)
    public Modelo3D obtener(String id){
        return repository.obtenerPorId(id).orElseThrow();
    }

    @Transactional(readOnly = true)
    public List<ModeloVentas> masVendidos(int limite) {
        if (limite < 1 || limite > RANKING_MAXIMO) {
            throw new ReglaDominioException("El límite debe estar entre 1 y " + RANKING_MAXIMO);
        }
        return repository.masVendidos(limite);
    }

}
