package com.uniquindio.ecommerce.domain.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.uniquindio.ecommerce.domain.valueobject.Precio;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;

class Modelo3DTest {

    @Test
    void publicarCreaUnModeloEnEstadoInicialCorrecto() {
        Modelo3D modelo = Modelo3D.publicar("1", "Silla ajustable", new Precio(15000, "COP"));
        assertFalse(modelo.estaEliminado());
    }

    @Test
    void dosModelosConLaMismaIdentidadSonElMismo() {
        Precio precio = new Precio(15000, "COP");
        Modelo3D original = Modelo3D.publicar("1", "Silla", precio);
        Modelo3D conOtroTitulo = Modelo3D.publicar("1", "Otro título", precio);

        assertEquals(original, conOtroTitulo);
    }

    @Test
    void eliminarLogicamenteDosVecesDebeLanzarExcepcion() {
        Modelo3D modelo = Modelo3D.publicar("1", "Silla", new Precio(15000, "COP"));
        modelo.eliminarLogicamente();

        assertThrows(ReglaDominioException.class, modelo::eliminarLogicamente);
    }
}