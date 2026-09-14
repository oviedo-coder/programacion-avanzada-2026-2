package com.uniquindio.ecommerce.demo;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.exception.ReglaDominioException;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

public class DemoCompra {
    public static void main(String[] args) {

        Compra compra = Compra.realizar("1", "modelo-1", "usuario-1", new Precio (15000, "COP"));
        System.out.println("Estado inicial: " + compra.getEstado());

        try {

            compra.solicitarReembolso("no sirvio");
        } catch (ReglaDominioException e){
            System.out.println("Error esperado: " + e.getMessage());
        }

        compra.confirmar();
        System.out.println("Después de confirmar: " + compra.getEstado());

        compra.solicitarReembolso(" El archivo estaba dañado");
        System.out.println("Despues de reembolsar: " + compra.getEstado());

        try{
            compra.confirmar();
        }catch (ReglaDominioException e){
            System.out.println("Error esperado: " + e.getMessage());
        }

    }
}