package com.uniquindio.ecommerce.application.usecase;

import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) //Activa el mockito dentro JUnit 5
class ConfirmarCompraUseCaseTest{

    @Mock
    private CompraRepository repository; // doble falso (Creo)

    @InjectMocks
    private ConfirmarCompraUseCase useCase; //crea instacia real

    @Test
    void deberiaConfirmarCompraCuandoLaCompraExiste(){

        //Arrange
        Compra compra = Compra.realizar ("1", "modelo-1", "usuario-1", new Precio(15000, "COP"));
        when(repository.obtenerPorId("1")).thenReturn(Optional.of(compra));

        //Act
        useCase.ejecutar("1");

        //Assert
        verify(repository).obtenerPorId("1");
        verify(repository).guardar(compra);


    }

    @Test
    void deberiaLanzarExcepcionCuandoLaCompraNoExiste (){

        //Arrange
        when(repository.obtenerPorId("no-existe")).thenReturn(Optional.empty());

        //Act & Assert
        assertThrows(java.util.NoSuchElementException.class, () -> {
            useCase.ejecutar("no-existe");
        });

        verify(repository, never()).guardar(any());


    }



}






