INSERT INTO modelos3d (id, titulo, precio_monto, precio_moneda, licencia, eliminado) VALUES
                                                                                         ('casa-munecas',      'Casa modular de coleccion',      25000, 'COP', 'COMERCIAL', FALSE),
                                                                                         ('engranaje-reloj',   'Engranaje de reloj mecanico',     8000, 'COP', 'PERSONAL',  FALSE),
                                                                                         ('dragon-articulado', 'Dragon articulado',              30000, 'COP', 'ILIMITADA', FALSE),
                                                                                         ('soporte-celular',   'Soporte de celular plegable',     5000, 'COP', 'PERSONAL',  FALSE),
                                                                                         ('molde-anillo',      'Molde de anillo para joyeria',   12000, 'COP', 'COMERCIAL', FALSE),
                                                                                         ('dragon-chino',      'Dragon chino de escritorio',     18000, 'COP', 'PERSONAL',  FALSE),
                                                                                         ('llavero-engranaje', 'Llavero de engranaje',            3000, 'COP', 'PERSONAL',  FALSE),
                                                                                         ('soporte-viejo',     'Soporte de monitor (descatalogado)', 9000, 'COP', 'PERSONAL', TRUE);

INSERT INTO compras (id, comprador_id, modelo_id, precio_monto, precio_moneda, estado, fecha_compra) VALUES
                                                                                                         ('C-001', 'ana',   'casa-munecas',      25000, 'COP', 'COMPLETADA', '2026-09-01 10:00:00'),
                                                                                                         ('C-002', 'ana',   'engranaje-reloj',    8000, 'COP', 'COMPLETADA', '2026-09-03 11:30:00'),
                                                                                                         ('C-003', 'bruno', 'dragon-articulado', 30000, 'COP', 'COMPLETADA', '2026-09-05 09:15:00'),
                                                                                                         ('C-004', 'bruno', 'soporte-celular',    5000, 'COP', 'PENDIENTE',  '2026-09-20 16:40:00'),
                                                                                                         ('C-005', 'carla', 'casa-munecas',      25000, 'COP', 'COMPLETADA', '2026-09-07 14:05:00'),
                                                                                                         ('C-006', 'carla', 'molde-anillo',      12000, 'COP', 'REEMBOLSADA','2026-09-09 18:20:00'),
                                                                                                         ('C-007', 'diego', 'dragon-articulado', 30000, 'COP', 'REEMBOLSADA','2026-09-10 08:50:00'),
                                                                                                         ('C-008', 'diego', 'casa-munecas',      25000, 'COP', 'REEMBOLSADA','2026-09-11 08:55:00'),
                                                                                                         ('C-009', 'diego', 'molde-anillo',      12000, 'COP', 'REEMBOLSADA','2026-09-12 09:02:00'),
                                                                                                         ('C-010', 'diego', 'soporte-celular',    5000, 'COP', 'COMPLETADA', '2026-09-15 21:10:00'),
                                                                                                         ('C-011', 'elena', 'dragon-articulado', 30000, 'COP', 'COMPLETADA', '2026-09-16 10:45:00'),
                                                                                                         ('C-012', 'elena', 'casa-munecas',      25000, 'COP', 'COMPLETADA', '2026-09-18 12:00:00'),
                                                                                                         ('C-013', 'elena', 'engranaje-reloj',    8000, 'COP', 'COMPLETADA', '2026-09-19 19:30:00'),
                                                                                                         ('C-014', 'ana',   'dragon-articulado', 30000, 'COP', 'COMPLETADA', '2026-09-22 15:15:00'),
                                                                                                         ('C-015', 'bruno', 'casa-munecas',      25000, 'COP', 'COMPLETADA', '2026-09-25 13:25:00'),
                                                                                                         ('C-016', 'carla', 'engranaje-reloj',    8000, 'COP', 'PENDIENTE',  '2026-09-28 17:50:00');

INSERT INTO comentarios (id, comprador_id, modelo_id, texto) VALUES
                                                                 ('K-001', 'ana',   'casa-munecas',      'Imprimio perfecto en PLA'),
                                                                 ('K-002', 'bruno', 'dragon-articulado', 'Las articulaciones quedan sueltas'),
                                                                 ('K-003', 'diego', 'dragon-articulado', 'Mala calidad, pedi reembolso'),
                                                                 ('K-004', 'elena', 'casa-munecas',      'Excelente detalle'),
                                                                 ('K-005', 'carla', 'casa-munecas',      'Me encanto');