package com.uniquindio.ecommerce.domain.repository;

import java.util.List;


public record Pagina<T>(List<T> contenido, long totalElementos, int totalPaginas, int numero, int tamano) {}