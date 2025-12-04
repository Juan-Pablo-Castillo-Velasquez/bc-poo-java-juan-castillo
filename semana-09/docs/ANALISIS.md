Entendido. No inventaré la estructura. Adaptaré exactamente la estructura de Markdown y las secciones del documento de la **Semana 08** (`Inventario, Agenda y Conjuntos`) para documentar el contenido y la arquitectura del **Proyecto Final de la Semana 09** (`Agencia de Publicidad Creativa Digital`).

-----

# 🧩 Proyecto Final Aplicado – Semana 09: Aplicación Integral de POO

## 📘 Sistema Integral de Gestión: Agencia de Publicidad "Creativa Digital"

En esta semana se integraron y aplicaron todos los conceptos de Programación Orientada a Objetos (POO) a un dominio real, utilizando las colecciones para la gestión de datos. El proyecto cumple con la implementación de:

* **Abstracción** (Clase Abstracta e Interface)
* **Herencia** (Jerarquía Persona)
* **Polimorfismo** (Sobrecarga y Sobrescritura)
* **Encapsulación** (Atributos privados y Validaciones)
* **Colecciones Genéricas** (`ArrayList<T>`, `HashMap<K, V>`)
* **Excepciones Personalizadas**

-----

# 📂 Estructura del Proyecto

El proyecto está organizado en paquetes para una arquitectura limpia, tal como se requiere para el Proyecto Final.

```
semana-09-proyecto-final/
├── com.CreatividadDigital/
│     ├── App/                      // Ejecución y Menú Principal
│     │     └── Main.java
│     ├── excepciones/              // Errores del Dominio
│     │     ├── CampanaNoEncontradaException.java
│     │     └── PresupuestoInvalidoException.java
│     ├── Modelo/                   // Clases de Entidad y Abstracción
│     │     ├── Persona.java          // CLASE ABSTRACTA
│     │     ├── Cliente.java          // HIJO 1
│     │     ├── Empleado.java         // HIJO 2
│     │     ├── Servicio.java         // INTERFACE
│     │     ├── CampanaPublicitaria.java
│     │     └── DisenoGrafico.java
│     └── Servicio/                 // Lógica de Negocio y CRUD
│           └── GestionAgencia.java
└── README.md
```

-----

# 🧩 1. Jerarquía de Personas (Clase Abstracta y Herencia)

### ✔ Clase Abstracta Persona

Modela las características base de cualquier individuo en la agencia:

* `id`, `nombre`, `email`
* **Método Abstracto:** `mostrarRol()` (Polimorfismo por Sobrescritura)
* **Encapsulación:** Atributos `private` con *getters/setters*

### ✔ Clase Cliente (Hijo 1)

**Extiende de `Persona`**. Añade atributos específicos: `empresa`, `tipoCliente`.

* **Herencia:** Usa `super()` en el constructor.
* **Polimorfismo:** Sobrescribe `mostrarRol()` y `toString()`.

### ✔ Clase Empleado (Hijo 2)

**Extiende de `Persona`**. Añade atributos específicos: `puesto`, `salario`.

* **Polimorfismo por Sobrecarga:** Implementa `calcularBono()` y `calcularBono(double porcentaje)`.

-----

# 🧩 2. Servicios de la Agencia (Interface y Clases Concretas)

### ✔ Interface Servicio

Define el contrato para cualquier actividad comercial de la agencia.

* **Abstracción:** Define `calcularCostoTotal()` y `ejecutarServicio()`.

### ✔ Clase CampanaPublicitaria

**Implementa `Servicio`**. Modelo de un proyecto con asociación a un `Cliente`.

* **Encapsulación:** Incluye `setPresupuesto()` con validación para evitar valores negativos.

### ✔ Clase DisenoGrafico

**Implementa `Servicio`**. Modelo para proyectos de diseño.

* **Implementación:** Define su propia lógica para `calcularCostoTotal()` (tarifa x horas).

-----

# 🧩 3. Gestión y Colecciones (Control y CRUD)

### ✔ Clase GestionAgencia (HashMap & ArrayList)

Contiene la lógica de negocio y las estructuras de datos para cumplir los requisitos de la Semana 09:

* **Colección List:** `private List<Persona> nomina = new ArrayList<>();` (Aprovecha el **Polimorfismo** al almacenar `Cliente` y `Empleado`).
* **Colección Map:** `private Map<String, CampanaPublicitaria> campañasActivas = new HashMap<>();` (Permite búsquedas rápidas por el código de campaña).
* **CRUD:** Implementa `agregarCliente()`, `listarNominaCompleta()`, `modificarPresupuestoCampana()`, entre otros.

### ✔ Excepciones Personalizadas

* **`CampanaNoEncontradaException`:** Lanzada si se intenta buscar/modificar una campaña inexistente.
* **`PresupuestoInvalidoException`:** Lanzada si se intenta asignar un presupuesto negativo.

-----

# 🎯 Conceptos de la Semana 09 Aplicados

## ✔ Herencia y Abstracción

* **Clase Abstracta:** `Persona` establece una estructura base.
* **Interface:** `Servicio` establece un contrato de comportamiento.
* **Jerarquía:** `Cliente` y `Empleado` heredan la estructura.

## ✔ Polimorfismo

* **Sobrescritura:** El método `mostrarRol()` es diferente en `Cliente` y `Empleado`.
* **Sobrecarga:** Múltiples versiones de `calcularBono()` en `Empleado`.

## ✔ Colecciones Genéricas

* **ArrayList\<Persona\>:** Utilizado para la nómina y listar objetos de diferentes tipos (Cliente/Empleado) de manera polimórfica.
* **HashMap\<String, CampanaPublicitaria\>:** Utilizado para el acceso eficiente (O(1)) a campañas por su código.

## ✔ Excepciones Personalizadas

* **Try-Catch:** Implementado en la funcionalidad de modificar presupuesto para manejar errores de búsqueda y validación de datos.

-----

# 📊 Comparativa por Pilar POO

| Pilar POO  | Estructura | Uso                            | Archivos Clave                       |
| ---------- | ---------- | ------------------------------ | ------------------------------------ |
| **Abstracción** | Interface/Abstracta  | Define Contratos y Estructura Padre | Servicio.java, Persona.java          |
| **Herencia** | Clase Hija | Reutilización de código y uso de `super()` | Cliente.java, Empleado.java          |
| **Polimorfismo** | Sobrescritura/Sobrecarga | Diferente comportamiento del mismo método | Cliente.java, Empleado.java          |
| **Colecciones** | ArrayList / HashMap | Gestión de la nómina y campañas (CRUD) | GestionAgencia.java                  |
| **Excepciones** | Custom Exceptions | Manejo de errores de negocio y validación | excepciones/\*.java                   |

-----

# 📝 Checklist Semana 09 (PROYECTO FINAL)

* [x] Mínimo 5 Clases del Dominio
* [x] Jerarquía de Herencia (1 Padre Abstracto + 2 Hijos)
* [x] Uso de Clase Abstracta O Interface (ambos implementados)
* [x] Encapsulación Completa (Atributos privados + Validaciones)
* [x] Polimorfismo Aplicado (Sobrecarga y Sobrescritura)
* [x] Uso de ArrayList O LinkedList
* [x] Uso de HashMap O TreeMap
* [x] Mínimo 2 Excepciones Personalizadas
* [x] Try-Catch implementado
* [x] Menú Interactivo Funcional
* [x] Operación CREATE y READ implementadas

-----

# 🚀 Versión Final

**Semana 09 – Proyecto Final Aplicado de POO**
**Estado:** Arquitectura y Requisitos Mínimos Completados
**Versión:** 1.0