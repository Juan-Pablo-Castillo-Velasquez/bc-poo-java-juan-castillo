# 🧩 Proyecto Final Aplicado – Semana 09: Aplicación Integral de POO

## 📘 Sistema Integral de Gestión: Agencia de Publicidad "Creativa Digital"

En esta semana se integraron y aplicaron todos los conceptos de Programación Orientada a Objetos (POO) a un dominio real, utilizando las colecciones para la gestión de datos. El proyecto cumple con la implementación de:

* **Abstracción** (Clase Abstracta e Interface)
* **Herencia** (Jerarquía Persona)
* **Polimorfismo** (Sobrecarga y Sobrescritura)
* **Encapsulación** (Atributos privados y Validaciones)
* **Colecciones Genéricas** (`ArrayList<T>`, `HashMap<K, V>`)
* **Excepciones Personalizadas**

---

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

---

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

---

# 🧩 2. Servicios de la Agencia (Interface y Clases Concretas)

### ✔ Interface Servicio

Define el contrato para cualquier actividad comercial de la agencia.

* **Abstracción:** Define `calcularCostoTotal()` y `ejecutarServicio()`.

### ✔ Clase CampanaPublicitaria

**Implementa `Servicio`**. Modelo de un proyecto con asociación a un `Cliente`.

* **Encapsulación:** Incluye `setPresupuesto()` con validación para evitar valores negativos.
* Usa **HashMap** en la gestión para búsquedas eficientes.

### ✔ Clase DisenoGrafico

**Implementa `Servicio`**. Modelo para proyectos de diseño.

* **Implementación:** Define su propia lógica para `calcularCostoTotal()` (tarifa x horas).

---

# 🧩 3. Gestión y Colecciones (Control y CRUD)

### ✔ Clase GestionAgencia (HashMap & ArrayList)

Contiene la lógica de negocio y las estructuras de datos para cumplir los requisitos de la Semana 09:

* **Colección List:**
  `private List<Persona> nomina = new ArrayList<>();`
  (Aprovecha el **Polimorfismo** al almacenar `Cliente` y `Empleado`).

* **Colección Map:**
  `private Map<String, CampanaPublicitaria> campañasActivas = new HashMap<>();`
  (Permite búsquedas rápidas por código, eficiencia O(1)).

* **CRUD Completo:**

    * Crear Cliente
    * Crear Campaña
    * Leer Nómina
    * Leer Campaña
    * Actualizar Presupuesto
    * Eliminar Campaña

### ✔ Excepciones Personalizadas

* **`CampanaNoEncontradaException`:** Lanzada si se intenta buscar/modificar una campaña inexistente.
* **`PresupuestoInvalidoException`:** Lanzada si se intenta asignar un presupuesto negativo.

---

# 🎯 Conceptos de la Semana 09 Aplicados

## ✔ Herencia y Abstracción

* **Clase Abstracta:** `Persona` establece una estructura base.
* **Interface:** `Servicio` establece un contrato de comportamiento.
* **Jerarquía:** `Cliente` y `Empleado` heredan la estructura.

## ✔ Polimorfismo

* **Sobrescritura:** Implementado en `mostrarRol()` de Cliente y Empleado.
* **Sobrecarga:** Implementada en `calcularBono()` de Empleado.

## ✔ Colecciones Genéricas

* **ArrayList<Persona>:** Para almacenar individuos y aplicar polimorfismo.
* **HashMap<String, CampanaPublicitaria>:** Para campañas por código.

## ✔ Excepciones Personalizadas

* Implementación de `try-catch` para validar operaciones críticas.

---

# 📊 Comparativa por Pilar POO

| Pilar POO        | Estructura          | Uso                                              | Archivos Clave              |
| ---------------- | ------------------- | ------------------------------------------------ | --------------------------- |
| **Abstracción**  | Interface/Abstracta | Contratos de comportamiento y clase base         | Servicio.java, Persona.java |
| **Herencia**     | Clase Hija          | Reutilización de atributos/métodos con `super()` | Cliente.java, Empleado.java |
| **Polimorfismo** | Override/Overload   | Comportamiento distinto según el tipo de objeto  | Cliente.java, Empleado.java |
| **Colecciones**  | ArrayList/HashMap   | CRUD y gestión de datos                          | GestionAgencia.java         |
| **Excepciones**  | Custom Exceptions   | Validación de errores de negocio                 | excepciones/*.java          |

---

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
* [x] CRUD completo (agregar, buscar, listar, modificar, eliminar campañas)

---

# 🚀 Versión Final

**Semana 09 – Proyecto Final Aplicado de POO**
**Estado:** Arquitectura y Requisitos Mínimos Completados
**Versión:** 1.0

