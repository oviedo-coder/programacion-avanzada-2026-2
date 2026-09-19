package com.uniquindio.ecommerce.domain.valueobject;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;

class PrecioTest {

    @Test
    void dosPreciosConElMismoValorDebenSerIguales (){
        Precio p1 = new Precio (15000, "COP");
        Precio p2 = new Precio (15000 , "COP");

        assertEquals(p1, p2);
    }

    @Test
    void noDebeCrearPrecioNegativo (){
        assertThrows(ReglaDominioException.class, () -> {
            new Precio (-1000, "COP");
        });

    }

    @Test
    void conLicenciaDebeMultiplicarElMontoSegunElFactor(){
        Precio base = new Precio (10000, "COP");
        Precio conComercial = base.conLicencia(Licencia.COMERCIAL);

        assertEquals(30000, conComercial.monto());
        assertEquals(10000, base.monto());

    }



}