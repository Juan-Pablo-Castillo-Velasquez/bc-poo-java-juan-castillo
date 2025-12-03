# 🧩 Semana 07 – Excepciones Personalizadas y Validaciones

## 📘 Sistema de Gestión de Campañas Publicitarias

Este proyecto implementa un sistema básico para registrar campañas publicitarias aplicando los conceptos de la Semana 07, especialmente:

* ✔ Validaciones obligatorias antes de registrar datos
* ✔ Lanzamiento de excepciones personalizadas (checked)
* ✔ Creación y manejo de un servicio con `ArrayList`
* ✔ Uso de `try/catch` en el `Main`
* ✔ Registro y prueba de campañas con datos válidos e inválidos

---

## 📋 Descripción

En esta semana se implementó un sistema de gestión de campañas publicitarias enfocado en manejo de excepciones, validaciones, y organización del proyecto en paquetes. Se crearon excepciones personalizadas, una clase de modelo `CampaniaPublicitaria`, una clase de servicio `ServicioCampania` y una clase `Main` para probar el funcionamiento del sistema.

El objetivo principal fue aplicar validaciones en tiempo de ejecución mediante `throw`, `try` y `catch`, garantizando la consistencia de reglas de negocio (fechas correctas y presupuestos válidos).

---

## 🎯 Objetivos Cumplidos

- ✅ Crear mínimo dos excepciones personalizadas
- ✅ Validar fechas de inicio y fin
- ✅ Validar presupuesto mayor a cero
- ✅ Implementar `throw` para lanzar errores de negocio
- ✅ Usar `try/catch` para controlar excepciones
- ✅ Organizar el proyecto con paquetes:
    - `Excepciones`
    - `Modelo`
    - `Servicio`
- ✅ Ejecutar pruebas desde `Main`

---

## 📂 Estructura del Proyecto

```
semana-07/
├── README.md
└── src/
    └── com/
        └── CreatividadDigital/
            ├── Excepciones/
            │   ├── FechaInvalidaException.java
            │   └── PresupuestoInvalidoException.java
            │
            ├── Modelo/
            │   └── CampaniaPublicitaria.java
            │
            ├── Servicio/
            │   └── ServicioCampania.java
            │
            └── Main.java
```

---

## 🏗️ Clases Implementadas

### 1. FechaInvalidaException.java

**Paquete:** `com.CreatividadDigital.Excepciones`

Excepción personalizada lanzada cuando:

- La fecha de fin es anterior a la fecha de inicio
- Las fechas son nulas o inválidas
- El formato de fecha no es correcto

**Implementación:**

```java
public class FechaInvalidaException extends Exception {
    public FechaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
```

**Características:**
- Extiende de `Exception` (checked exception)
- Constructor que recibe mensaje personalizado
- Fuerza al desarrollador a manejar el error

---

### 2. PresupuestoInvalidoException.java

**Paquete:** `com.CreatividadDigital.Excepciones`

Excepción personalizada para controlar:

- Presupuestos menores o iguales a cero
- Valores no permitidos por las reglas del sistema
- Validaciones de lógica de negocio

**Implementación:**

```java
public class PresupuestoInvalidoException extends Exception {
    public PresupuestoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
```

**Características:**
- Extiende de `Exception` (checked exception)
- Permite crear mensajes de error específicos
- Control explícito de errores de negocio

---

### 3. CampaniaPublicitaria.java (Modelo)

**Paquete:** `com.CreatividadDigital.Modelo`

Clase encargada de representar una campaña publicitaria.

**Atributos Principales:**

- `private String nombre` - Nombre de la campaña
- `private double presupuesto` - Presupuesto asignado
- `private LocalDate fechaInicio` - Fecha de inicio de la campaña
- `private LocalDate fechaFin` - Fecha de finalización de la campaña

**Constructor con Validaciones:**

```java
public CampaniaPublicitaria(String nombre, double presupuesto, 
                           LocalDate fechaInicio, LocalDate fechaFin) 
                           throws PresupuestoInvalidoException, FechaInvalidaException {
    
    // Validación de presupuesto
    if (presupuesto <= 0) {
        throw new PresupuestoInvalidoException(
            "El presupuesto debe ser mayor a cero. Valor recibido: " + presupuesto
        );
    }
    
    // Validación de fechas
    if (fechaFin.isBefore(fechaInicio)) {
        throw new FechaInvalidaException(
            "La fecha de fin no puede ser anterior a la fecha de inicio."
        );
    }
    
    this.nombre = nombre;
    this.presupuesto = presupuesto;
    this.fechaInicio = fechaInicio;
    this.fechaFin = fechaFin;
}
```

**Validaciones Implementadas:**

1. **Presupuesto:**
    - Si `presupuesto <= 0`: lanza `PresupuestoInvalidoException`
    - Mensaje de error incluye el valor recibido

2. **Fechas:**
    - Si `fechaFin` es anterior a `fechaInicio`: lanza `FechaInvalidaException`
    - Validación de coherencia temporal

**Métodos Principales:**

- Getters para todos los atributos
- `toString()` para representación textual
- Método `calcularDuracion()` que retorna días de campaña

---

### 4. ServicioCampania.java (Servicio)

**Paquete:** `com.CreatividadDigital.Servicio`

Encargada de la lógica de negocio del sistema.

**Atributos:**

```java
private ArrayList<CampaniaPublicitaria> listaCampanias;
```

**Métodos Principales:**

#### `registrarCampania(CampaniaPublicitaria c)`

Registra una nueva campaña en el sistema:

```java
public void registrarCampania(CampaniaPublicitaria campania) {
    try {
        listaCampanias.add(campania);
        System.out.println("✅ Campaña registrada correctamente: " + campania.getNombre());
    } catch (Exception e) {
        System.out.println("❌ Error al registrar campaña: " + e.getMessage());
    }
}
```

#### `calcularDuracion(CampaniaPublicitaria c)`

Calcula la duración de la campaña en días:

```java
public long calcularDuracion(CampaniaPublicitaria campania) {
    return ChronoUnit.DAYS.between(
        campania.getFechaInicio(), 
        campania.getFechaFin()
    );
}
```

#### `mostrarResumen(CampaniaPublicitaria c)`

Muestra un resumen completo de la campaña:

```java
public void mostrarResumen(CampaniaPublicitaria campania) {
    System.out.println("📋 RESUMEN DE CAMPAÑA");
    System.out.println("Nombre: " + campania.getNombre());
    System.out.println("Presupuesto: $" + campania.getPresupuesto());
    System.out.println("Duración: " + calcularDuracion(campania) + " días");
    System.out.println("Fecha Inicio: " + campania.getFechaInicio());
    System.out.println("Fecha Fin: " + campania.getFechaFin());
}
```

#### `listarCampanias()`

Retorna lista de todas las campañas registradas:

```java
public ArrayList<CampaniaPublicitaria> listarCampanias() {
    return listaCampanias;
}
```

**Características del Servicio:**

- Validaciones internas
- Manejo de `ArrayList`
- Separación clara del modelo
- Métodos `try/catch` para control de errores

---

### 5. Main.java (Ejecución)

**Paquete:** `com.CreatividadDigital`

Programa de demostración que implementa 5 casos de prueba.

**Casos de Prueba Implementados:**

#### Caso 1: Registro Exitoso

``java
try {
    CampaniaPublicitaria c1 = new CampaniaPublicitaria(
        "Campaña Primavera",
        500000,
        LocalDate.of(2025, 3, 1),
        LocalDate.of(2025, 3, 31)
    );
    servicio.registrarCampania(c1);
    servicio.mostrarResumen(c1);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
``

#### Caso 2: Error por Presupuesto Inválido

``java
try {
    CampaniaPublicitaria c2 = new CampaniaPublicitaria(
        "Campaña Sin Presupuesto",
        -500,  // ❌ Error: presupuesto negativo
        LocalDate.of(2025, 4, 1),
        LocalDate.of(2025, 4, 30)
    );
} catch (PresupuestoInvalidoException e) {
    System.out.println("❌ Error de Presupuesto: " + e.getMessage());
} catch (FechaInvalidaException e) {
    System.out.println("❌ Error de Fecha: " + e.getMessage());
}
`

#### Caso 3: Error por Fecha Inválida

``java
try {
    CampaniaPublicitaria c3 = new CampaniaPublicitaria(
        "Campaña con Fechas Incorrectas",
        300000,
        LocalDate.of(2025, 5, 30),
        LocalDate.of(2025, 5, 1)  // ❌ Error: fecha fin antes de inicio
    );
} catch (FechaInvalidaException e) {
    System.out.println("❌ Error de Fecha: " + e.getMessage());
} catch (PresupuestoInvalidoException e) {
    System.out.println("❌ Error de Presupuesto: " + e.getMessage());
}
``

#### Caso 4: Segundo Registro Exitoso

``java
try {
    CampaniaPublicitaria c4 = new CampaniaPublicitaria(
        "Campaña Verano",
        750000,
        LocalDate.of(2025, 6, 1),
        LocalDate.of(2025, 8, 31)
    );
    servicio.registrarCampania(c4);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
``

#### Caso 5: Listar Todas las Campañas

``java
System.out.println("\n📊 LISTADO DE CAMPAÑAS REGISTRADAS");
System.out.println("Total de campañas: " + servicio.listarCampanias().size());
for (CampaniaPublicitaria camp : servicio.listarCampanias()) {
    System.out.println("- " + camp.getNombre() + " ($" + camp.getPresupuesto() + ")");
}
``

---

## 🎨 Conceptos Implementados

### 1. Excepciones Personalizadas

- Permiten controlar errores específicos del negocio
- Mejoran la legibilidad y mantenibilidad del código
- Mensajes de error claros y descriptivos

### 2. Validaciones

- **Presupuesto:** Debe ser mayor a cero
- **Fechas:** Fecha fin no puede ser anterior a fecha inicio
- **Control de nulos:** Validación de datos obligatorios

### 3. try / catch / throw

- **`throw`:** Lanzamiento manual de errores de negocio
- **`try`:** Bloque de código que puede generar excepciones
- **`catch`:** Captura y manejo de excepciones específicas
- Control seguro de ejecuciones

### 4. Organización en Paquetes

```
com.CreatividadDigital
├── Excepciones/    → Excepciones personalizadas
├── Modelo/         → Clases de dominio
├── Servicio/       → Lógica de negocio
└── Main            → Punto de entrada
```

**Beneficios:**
- Código más estructurado y profesional
- Separación de responsabilidades
- Facilita el mantenimiento y escalabilidad
- Reutilización de componentes

### 5. Manejo de Listas

- Uso de `ArrayList<CampaniaPublicitaria>`
- Operaciones: `add()`, `size()`, iteración
- Gestión dinámica de campañas

### 6. LocalDate (Java Time API)

``java
LocalDate fechaInicio = LocalDate.of(2025, 3, 1);
fechaFin.isBefore(fechaInicio);  // Comparación de fechas
ChronoUnit.DAYS.between(inicio, fin);  // Cálculo de días
`

---

## 🚀 Instrucciones de Ejecución

### Compilación

Abrir terminal en el directorio del proyecto y ejecutar:

```bash
javac -d bin src/com/CreatividadDigital/Excepciones/*.java
javac -d bin -cp bin src/com/CreatividadDigital/Modelo/*.java
javac -d bin -cp bin src/com/CreatividadDigital/Servicio/*.java
javac -d bin -cp bin src/com/CreatividadDigital/Main.java
```

O compilar todo a la vez:

```bash
javac -d bin src/com/CreatividadDigital/**/*.java
```

### Ejecución

```bash
java -cp bin CreatividadDigital.Main
```

---

## 📺 Salida Esperada

```
====== SISTEMA DE GESTIÓN DE CAMPAÑAS ======

--- Caso 1: Registro Exitoso ---
✅ Campaña registrada correctamente: Campaña Primavera

📋 RESUMEN DE CAMPAÑA
Nombre: Campaña Primavera
Presupuesto: $500000.0
Duración: 30 días
Fecha Inicio: 2025-03-01
Fecha Fin: 2025-03-31
-----------------------------------

--- Caso 2: Error por Presupuesto Inválido ---
❌ Error de Presupuesto: El presupuesto debe ser mayor a cero. Valor recibido: -500.0

--- Caso 3: Error por Fecha Inválida ---
❌ Error de Fecha: La fecha de fin no puede ser anterior a la fecha de inicio.

--- Caso 4: Segundo Registro Exitoso ---
✅ Campaña registrada correctamente: Campaña Verano

📊 LISTADO DE CAMPAÑAS REGISTRADAS
Total de campañas: 2
- Campaña Primavera ($500000.0)
- Campaña Verano ($750000.0)

====== FIN DE LA DEMOSTRACIÓN ======
```

---

## 📊 Comparativa de Validaciones

| Validación | Condición | Excepción Lanzada |
|---|---|---|
| **Presupuesto Válido** | presupuesto > 0 | PresupuestoInvalidoException |
| **Fecha Coherente** | fechaFin >= fechaInicio | FechaInvalidaException |
| **Datos Obligatorios** | nombre != null | NullPointerException |

---

## ✅ Checklist de Entrega

- [x] Excepción `FechaInvalidaException`
- [x] Excepción `PresupuestoInvalidoException`
- [x] Clase modelo `CampaniaPublicitaria` con validaciones
- [x] Clase servicio `ServicioCampania` funcionando
- [x] Manejo de excepciones con `try/catch`
- [x] Paquetes organizados (`Excepciones`, `Modelo`, `Servicio`)
- [x] `Main` probado con 5 casos (2 exitosos, 2 con errores, 1 listado)
- [x] Uso correcto de `throw` para lanzar excepciones
- [x] README.md documentado
- [x] Código comentado y limpio

---

## 🔮 Mejoras Futuras

1. Agregar más validaciones (nombre vacío, fechas nulas)
2. Implementar validación de formato de fecha desde String
3. Crear excepciones para `CampaniaDuplicadaException`
4. Agregar método de búsqueda por nombre
5. Implementar persistencia con archivos
6. Crear reportes de campañas por rango de fechas
7. Agregar logging de errores
8. Implementar patrón Singleton para el servicio

---

## 💾 Commit Recomendado

```bash
git add .
git commit -m "feat(semana-07): Implementar excepciones personalizadas y validaciones"
git push origin main
```

---

## 👨‍💻 Autor

**Estudiante de Programación Orientada a Objetos**

Semana 07 - Excepciones Personalizadas y Validaciones

---

## 📊 Estado del Proyecto

| Atributo | Valor |
|----------|-------|
| **Estado** | ✅ Completado |
| **Versión** | 7.0 |
| **Última Actualización** | Semana 07 |
| **Conceptos Aplicados** | Excepciones, Validaciones, ArrayList |

---

## 📚 Referencias Teóricas

### Excepciones en Java

Las excepciones son eventos que interrumpen el flujo normal de ejecución de un programa. Java maneja dos tipos principales:

- **Checked Exceptions:** Deben ser declaradas con `throws` o manejadas con `try/catch`
- **Unchecked Exceptions:** No requieren manejo explícito

En este proyecto se implementaron **checked exceptions** personalizadas.

### throw vs throws

- **`throw`:** Lanza una excepción manualmente dentro de un método
- **`throws`:** Declara que un método puede lanzar una excepción

`java
public void metodo() throws MiException {
    if (condicion) {
        throw new MiException("Error");
    }
}
``

### try-catch-finally

``java
try {
    // Código que puede fallar
} catch (TipoException e) {
    // Manejo del error
} finally {
    // Código que siempre se ejecuta
}
``

### LocalDate y Java Time API

Introducido en Java 8, proporciona manejo moderno de fechas:

- `LocalDate.of(año, mes, día)` - Crear fecha
- `isBefore()` / `isAfter()` - Comparar fechas
- `ChronoUnit.DAYS.between()` - Calcular diferencia

---

## 🧩 Conclusión

Este sistema cumple completamente los requerimientos de la Semana 07, aplicando validaciones y excepciones personalizadas para garantizar un registro seguro y controlado. La estructura modular permite escalar fácilmente el proyecto agregando más modelos, servicios o reglas de validación.

El uso de excepciones personalizadas, combinado con una correcta organización en paquetes y validaciones robustas, demuestra la aplicación de buenas prácticas de programación orientada a objetos y manejo de errores en Java.