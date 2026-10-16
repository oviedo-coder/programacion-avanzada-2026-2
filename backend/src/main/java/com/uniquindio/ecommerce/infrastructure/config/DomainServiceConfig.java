package com.uniquindio.ecommerce.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.uniquindio.ecommerce.domain.repository.CompraRepository;
import com.uniquindio.ecommerce.domain.service.VerificadorDeCompra;

@Configuration // Esta clase define como construir ciertos objetos (beans)
public class DomainServiceConfig{

    @Bean
    public VerificadorDeCompra verificadorDeCompra(CompraRepository compraRepository){
        return new VerificadorDeCompra(compraRepository);
    }


}
