package com.uniquindio.ecommerce.infrastructure.rest;


import com.uniquindio.ecommerce.application.dto.response.ModeloResponse;
import com.uniquindio.ecommerce.application.dto.response.PageResponse;
import com.uniquindio.ecommerce.application.usecase.ConsultarCatalogoUseCase;
import com.uniquindio.ecommerce.domain.valueobject.Licencia;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.uniquindio.ecommerce.application.dto.response.MasVendidoResponse;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@RequiredArgsConstructor
public class ModeloController {

    private  final ConsultarCatalogoUseCase consultarCatalogoUseCase;

    @GetMapping
    public PageResponse<ModeloResponse> buscar(
            @RequestParam(name = "busqueda", required = false) String busqueda,
            @RequestParam(name = "licencia", required = false) Licencia licencia, //400
            @RequestParam(name = "page", defaultValue = "0")int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        return PageResponse.desde(
                consultarCatalogoUseCase.buscar(busqueda,licencia, page, size),
                ModeloResponse::desde);
    }

    @GetMapping("/mas-vendidos")
    public List<MasVendidoResponse> masVendidos(@RequestParam(name = "limite", defaultValue = "3") int limite) {
        return consultarCatalogoUseCase.masVendidos(limite).stream()
                .map(MasVendidoResponse::desde)
                .toList();
    }

    @GetMapping("{id}")//casa-munecas
    public ModeloResponse obtener (@PathVariable("id") String id){
        return  ModeloResponse.desde(consultarCatalogoUseCase.obtener(id)); //404
    }

}
