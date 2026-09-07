# Instrucciones: Glosario de Lenguaje Ubicuo (Entrega 1)

## Qué tienen que entregar

Un archivo `glosario-lenguaje-ubicuo.md` en la raíz de su repositorio de grupo, con **mínimo 5 términos** propios de su nicho de e-commerce, siguiendo el mismo formato que vieron en clase (el ejemplo del sistema de Solicitudes).

## Reglas

- **Ninguno de los 5 términos puede ser** "Producto", "Comprador", "Vendedor" o "Compra" a secas — esos ya vienen dados en el proyecto base y no cuentan como lenguaje propio.
- Deben ser palabras específicas de SU nicho (ej. "lote" y "fecha de vencimiento" si venden perecederos; "módulo" y "certificado" si venden cursos; "talla" y "variante" si venden ropa).
- Cada término debe tener: definición, precondiciones o reglas asociadas (si aplica), y un ejemplo de cómo se vería en código.
- Todos los integrantes del grupo deben estar de acuerdo con los términos — es el vocabulario que van a usar TODOS en el código de aquí en adelante, no la idea de una sola persona.

## Cómo entregarlo

1. Creen el archivo dentro de la carpeta raíz de su repo (junto al README, no dentro de `backend/`):
   ```
   touch glosario-lenguaje-ubicuo.md
   ```
2. Complétenlo usando la plantilla de abajo.
3. Súbanlo con el flujo normal:
   ```
   git add glosario-lenguaje-ubicuo.md
   git commit -m "docs: glosario de lenguaje ubicuo"
   git push
   ```

---

## Plantilla para copiar y completar

```markdown
# Glosario del Lenguaje Ubicuo - [Nombre de su e-commerce / nicho]

## Conceptos Centrales

### [Término 1]
**Definición:** [qué significa en su negocio]

**Sinónimos aceptados:** [si aplica]
**No usar:** [términos genéricos que NO deben usar en su lugar]

**Ejemplo de uso en código:**
\`\`\`java
[una línea de código de ejemplo usando este término]
\`\`\`

---

### [Término 2]
**Definición:** [...]

**Precondiciones:** [reglas que deben cumplirse antes de esta acción, si aplica]

**Ejemplo de uso:**
\`\`\`java
[...]
\`\`\`

---

### [Término 3]
[repitan la misma estructura]

---

### [Término 4]
[repitan la misma estructura]

---

### [Término 5]
[repitan la misma estructura]

---

## Anti-patrones (Términos a EVITAR en nuestro proyecto)

| No usar | Usar |
|---|---|
| [genérico 1] | [su término] |
| [genérico 2] | [su término] |
| [genérico 3] | [su término] |
```

---

## Checklist antes de entregar

- [ ] Mínimo 5 términos, ninguno es "Producto", "Comprador", "Vendedor" ni "Compra".
- [ ] Cada término tiene definición + ejemplo de código.
- [ ] La tabla de anti-patrones tiene al menos 3 filas.
- [ ] El archivo está en la raíz del repo y ya fue subido con `git push`.
- [ ] Todo el grupo está de acuerdo con estos términos — los van a usar en el código de aquí en adelante.
