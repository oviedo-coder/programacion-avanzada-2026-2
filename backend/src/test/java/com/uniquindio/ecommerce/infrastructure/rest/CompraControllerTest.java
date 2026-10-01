package com.uniquindio.ecommerce.infrastructure.rest;

import com.uniquindio.ecommerce.application.usecase.RealizarCompraUseCase;
import com.uniquindio.ecommerce.application.usecase.ConfirmarCompraUseCase;
import com.uniquindio.ecommerce.infrastructure.rest.mapper.CompraMapper;
import com.uniquindio.ecommerce.domain.entity.Compra;
import com.uniquindio.ecommerce.domain.valueobject.Precio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CompraController.class)// levanta lo necesario para probar este controller
class CompraControllerTest {

    @Autowired // Postman Interno
    private MockMvc mockMvc;

    @MockitoBean
    private RealizarCompraUseCase realizarCompraUseCase;

    @MockitoBean
    private ConfirmarCompraUseCase confirmarCompraUseCase;

    @MockitoBean
    private CompraMapper mapper;

    @Test
    void deberiaCrearCompraCuandoDatosValidos () throws Exception {
        //Arrange
        String requestJson= """
            {
                "modeloId": "modelo-1",
                "compradorId": "usuario-1"
            }
            """;

        // Doblete FALSO
        Compra compraSimulada = Compra.realizar("id-1", "modelo-1", "usuario-1", new Precio(15000, "COP"));
        when(realizarCompraUseCase.ejecutar(any(), any(), any(), any()))
                .thenReturn(compraSimulada);

        // ACT & ASSERT
        mockMvc.perform(post("/api/compras") // simular POST
                .contentType(MediaType.APPLICATION_JSON) //esto que envio aqui es Json ->415
                .content(requestJson)) //adjunta el cuerpo Json
                .andExpect(status().isCreated())   // HTTP -> 201 (CREATED)
                .andExpect(header().exists("Location"));
    }

    @Test
    void deberiaRetornar400CuandoFaltaModeloId() throws Exception{
        //Arrange
        String requestJson= """
           {
                "compradorId": "usuario-1"
           }
           """;


        // Act & Assert
        mockMvc.perform(post("/api/compras")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isBadRequest()); // ->400

    }


}