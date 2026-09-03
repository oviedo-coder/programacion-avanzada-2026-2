# Proyecto Final — Programación Avanzada

```
Programa de Ingeniería de Sistemas y Computación
Universidad del Quindío
Título: Proyecto Final del espacio académico
Docente: [tu nombre]
```

## 🎯 Objetivo

Desarrollar una aplicación web de e-commerce para la venta de **productos digitales** (ebooks, cursos, plantillas, software, música, etc.), con roles diferenciados para compradores y vendedores, utilizando **Spring Boot** (JPA) y **Angular**, con despliegue en la nube.

---

## ✅ Funcionalidades esenciales (obligatorias)

### Roles y acciones

**Comprador**
- Registrarse e iniciar sesión.
- Buscar productos digitales (por categoría, precio, popularidad).
- Comprar productos (simulación de pago) y descargarlos tras la compra.
- Cancelar/solicitar reembolso de una compra (sujeto a políticas, ej. antes de descargar).
- Dejar comentarios y calificaciones (solo después de una compra confirmada).
- Ver su historial de compras (activas, canceladas).
- Ver el detalle completo de cada producto (galería/preview, descripción, comentarios).

**Vendedor**
- Registrarse e iniciar sesión (con rol "vendedor").
- Gestionar sus productos (CRUD).
  - Ver la lista de sus propios productos.
  - Crear o editar un producto (incluye subir el archivo digital y su preview/portada).
  - Eliminar: solo si no tiene compras activas recientes sujetas a reembolso. Eliminación lógica (soft delete).
- Ver métricas básicas por producto: número de ventas, promedio de calificaciones (con filtro por rango de fechas).
- Ver historial de ventas de sus productos (filtros por fecha, estado).
- Responder a comentarios de compradores.

### Gestión de usuarios

- **Registro**: nombre, email (único), contraseña (encriptada), teléfono, rol, fecha de nacimiento.
  - Validación: formato de email, contraseña segura (mínimo 8 caracteres, mayúsculas/números).
- **Autenticación**: JWT para sesiones persistentes.
- **Edición de perfil**: nombre, teléfono, foto de perfil; el vendedor puede añadir descripción/datos de pago.
- **Cambio de contraseña**: por código de recuperación enviado al correo (válido 15 min) o cambio directo con contraseña actual.

### Gestión de productos digitales

**Atributos básicos**
- Título, descripción detallada, categoría (ebook, curso, plantilla, software, etc.).
- Precio, tipo de archivo, tamaño.
- Imágenes/preview (mínimo 1, máximo 10, con imagen principal destacada).
- Archivo digital real (almacenado en un servicio externo, no en la base de datos).

**Relaciones**
- Un vendedor puede tener múltiples productos.
- Cada producto tiene una lista de compras y comentarios.

### Compras

**Creación de compra**
- El comprador selecciona el producto y confirma la compra (simulación de pago).
- El sistema valida:
  - Que el comprador no haya comprado ya el mismo producto (evitar doble cobro).
  - Stock/disponibilidad si aplica (ej. licencias limitadas — opcional).
- Al confirmar: recibe correo con el link/token de descarga.
- Puede ver el estado de su compra (Pendiente, Completada, Reembolsada).

**Reembolso**
- El comprador puede solicitar reembolso dentro de un plazo definido (ej. 48 horas y sin haber descargado el archivo).
- El vendedor recibe notificación de la solicitud.

**Listado de compras**
- Comprador y vendedor: listado de compras/ventas, más reciente primero, con filtros.

### Comentarios y calificaciones

- Solo puede comentar quien tenga una compra completada.
- Máximo 1 comentario por compra.
- Calificación (1-5 estrellas, obligatorio) + comentario (texto, máx. 500 caracteres).
- Listado de comentarios por producto, ordenado por fecha, con promedio de calificación visible.
- El vendedor puede responder comentarios y recibe notificación de nuevos comentarios.

### Búsqueda de productos

Filtros disponibles:
- Por categoría.
- Por rango de precio (deslizador).
- Por calificación mínima.
- Búsqueda predictiva por nombre.

### Vista de resultados

- Tarjetas con imagen principal, precio, categoría y calificación promedio.
- Paginación (10 resultados por página), ignorando productos en estado "eliminado".
- Detalle del producto: galería/preview, descripción, comentarios, botón de compra.

---

## 🟡 Funcionalidades opcionales (elegir mínimo una)

1. **Descuentos por temporada**: el vendedor crea promociones (ej. "20% off en diciembre"); el comprador ve el precio con descuento.
2. **Sistema de recomendaciones**: sugerencias basadas en historial de compras o productos similares.
3. **Chat en vivo** (WebSockets) para que los usuarios (compradores) puedan hacerle preguntas al vendedor sobre un producto, antes o después de comprarlo.
4. **Pagos en línea simulados** con confirmación automática y estado "Pagado" visible para el vendedor.
5. **Lista de favoritos/wishlist** para guardar productos y revisarlos después.
6. **Cupones de descuento personalizados** que el comprador ingresa al momento de comprar.

---

## ⚠️ Para tener en cuenta

- Implementar con Spring Boot (backend) y Angular (frontend); MariaDB para los datos.
- Los archivos digitales y las imágenes deben manejarse con un servicio externo (Cloudinary, Firebase, AWS S3, Google Cloud Storage, etc.) — nunca en base64 dentro de la base de datos.
- Código fuente en un repositorio de GitHub. Todos los integrantes del grupo deben contribuir en el desarrollo del proyecto.
- Eliminaciones (productos o usuarios) deben ser lógicas (soft delete), nunca reales.
- Desplegar la aplicación completa en la nube al finalizar el curso.
- Debe elegirse al menos una funcionalidad opcional.

---

## Mapa con los núcleos temáticos del syllabus

| Núcleo temático (syllabus) | Cómo se cubre en este proyecto |
|---|---|
| 1. Introducción / arquitecturas | Diseño de la arquitectura del proyecto (capas, patrones), setup inicial |
| 2. Capa de persistencia | Entidades (Usuario, Producto, Compra, Comentario), JPA/ORM |
| 3. Servicios de negocio | Lógica de compras, validaciones, reembolsos, notificaciones |
| 4. Capa de presentación | Angular: catálogo, formularios reactivos, seguridad básica en frontend |
| 5. Despliegue en la nube | Deploy del backend y frontend, integración continua |

Universidad del Quindío 💚 2026
