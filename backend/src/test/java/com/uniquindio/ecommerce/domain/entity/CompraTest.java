package com.uniquindio.ecommerce.domain.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.uniquindio.ecommerce.domain.valueobject.Precio;
import com.uniquindio.ecommerce.domain.valueobject.EstadoCompra;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;

class CompraTest {

    private Compra compraPendiente() {
        return Compra.realizar("1", "modelo-1", "usuario-1", new Precio(15000, "COP"));
    }

    @Test
    void realizarCreaUnaCompraEnEstadoPendiente() {
        Compra compra = compraPendiente();
        assertEquals(EstadoCompra.PENDIENTE, compra.getEstado());
    }

    @Test
    void noDebePermitirReembolsarUnaCompraPendiente() {
        Compra compra = compraPendiente();

        assertThrows(ReglaDominioException.class, () -> {
            compra.solicitarReembolso("No sirvió");
        });
        assertEquals(EstadoCompra.PENDIENTE, compra.getEstado());
    }

    @Test
    void noDebePermitirConfirmarUnaCompraYaReembolsada(){
        Compra compra = compraPendiente();
        compra.confirmar();;
        compra.solicitarReembolso("El archivo estaba dañado");

        assertThrows(ReglaDominioException.class, compra::confirmar);
    }


}