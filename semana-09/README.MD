# 🧩 Proyecto Final Aplicado – Semana 09: Aplicación Integral de POO

## 📘 Sistema Integral de Gestión: Agencia de Publicidad "Creativa Digital"

Este proyecto implementa un sistema modular que demuestra la **aplicación integral de la Programación Orientada a Objetos (POO)** en Java, cumpliendo con todos los criterios de la rúbrica de evaluación de la Semana 09.

---

# 🎯 Objetivos de la Semana 09 (Proyecto Final)

* Diseñar una arquitectura con **5+ Clases del Dominio**, incluyendo **Herencia** y **Abstracción**.
* Aplicar los pilares de POO: **Encapsulación, Herencia, Polimorfismo y Abstracción**.
* Utilizar **Colecciones Genéricas** (`ArrayList`, `HashMap`) para el manejo de datos.
* Implementar **Excepciones Personalizadas** del dominio.
* Crear un **Sistema CRUD funcional** con un menú interactivo.
* Manejar errores mediante `try-catch` y validaciones lógicas.

---

# 📂 Archivos Entregados (Semana 09)

La estructura final del proyecto quedó organizada en cuatro paquetes principales:

```
src/
 ├── com.CreatividadDigital/
 │     ├── App/
 │     │     └── Main.java                   // MENÚ PRINCIPAL (6 opciones)
 │     ├── excepciones/
 │     │     ├── CampanaNoEncontradaException.java
 │     │     └── PresupuestoInvalidoException.java
 │     ├── Modelo/
 │     │     ├── Persona.java                // Clase ABSTRACTA
 │     │     ├── Cliente.java                // Hijo 1
 │     │     ├── Empleado.java               // Hijo 2
 │     │     ├── Servicio.java               // Interface
 │     │     ├── CampanaPublicitaria.java    // Implementa Servicio
 │     │     └── DisenoGrafico.java          // Implementa Servicio
 │     └── Servicio/
 │           └── GestionAgencia.java         // CRUD + Colecciones
```

---

# 📐 Diagrama UML General

```mermaid
classDiagram
    direction LR
    
    class GestionAgencia {
        -Map~String, Cliente~ clientes
        -List~Persona~ nomina
        -Map~String, CampanaPublicitaria~ campañasActivas
        +agregarCliente(Cliente)
        +listarNominaCompleta()
        +buscarCampanaPorCodigo(String)
        +modificarPresupuestoCampana(String,double)
        +eliminarCampana(String)
    }
    
    abstract class Persona {
        -String id
        -String nombre
        -String email
        +saludar()
        +abstract mostrarRol()
    }
    
    class Cliente {
        -String empresa
        -String tipoCliente
        +mostrarRol()
        +toString()
    }
    
    class Empleado {
        -String puesto
        -double salario
        +mostrarRol()
        +calcularBono()
        +calcularBono(double)
    }
    
    interface Servicio {
        +calcularCostoTotal() double
        +ejecutarServicio()
    }
    
    class CampanaPublicitaria {
        -String codigo
        -String nombre
        -double presupuesto
        -Cliente clienteAsignado
        +calcularCostoTotal()
        +ejecutarServicio()
        +setPresupuesto(double)
    }

    class DisenoGrafico {
        -String codigo
        -String tipoDiseno
        -double tarifaPorHora
        -int horasDedicadas
        +calcularCostoTotal()
        +ejecutarServicio()
    }

    Persona <|-- Cliente
    Persona <|-- Empleado
    Servicio <|.. CampanaPublicitaria
    Servicio <|.. DisenoGrafico
    
    GestionAgencia --> Persona : * nomina
    GestionAgencia --> CampanaPublicitaria : * campañasActivas
    CampanaPublicitaria --> Cliente : clienteAsignado
```

---

# 🏛️ Descripción de la Aplicación Integral de POO

## 🟦 1. Abstracción y Herencia (Jerarquía `Persona`)

* La clase **`Persona`** es **abstracta**, obliga a implementar `mostrarRol()` en sus subclases.
* `Cliente` y `Empleado` son clases hijas que heredan atributos comunes y añaden características propias.
* Se utiliza `super()` en sus constructores.

Esto cumple la relación **Padre → Hijos** y demuestra **abstracción + herencia**.

---

## 🟩 2. Polimorfismo y Encapsulación

### ✔ Polimorfismo por Sobrescritura

`Cliente` y `Empleado` implementan su propia versión de `mostrarRol()`.

### ✔ Polimorfismo por Sobrecarga

`Empleado` implementa dos versiones de `calcularBono()`.

### ✔ Encapsulación

Todos los atributos de modelo son **privados**, con `get/set`.

Además:
`CampanaPublicitaria.setPresupuesto()` valida que el valor sea positivo.

---

## 🟨 3. Colecciones y Excepciones

### ✔ Colecciones

* `ArrayList<Persona>` → nomina polimórfica
* `HashMap<String, Cliente>` → clientes por ID
* `HashMap<String, CampanaPublicitaria>` → campañas por código

### ✔ Excepciones Personalizadas

* `CampanaNoEncontradaException`
* `PresupuestoInvalidoException`

### ✔ Manejo con `try-catch`

Usado en:

* `modificarPresupuestoCampana()`
* operaciones del menú en `Main.java`

---

# 🍽️ Menú Final (6 Opciones CRUD)

`java
==== MENÚ PRINCIPAL ====
1. Listar Nómina y Clientes (Polimorfismo)
2. Agregar Nuevo Cliente (CREATE)
3. Agregar Nueva Campaña Publicitaria (CREATE)
4. Modificar Presupuesto de Campaña (UPDATE)
5. Buscar Campaña por Código (READ)
6. Eliminar Campaña (DELETE)
0. Salir
Seleccione una opción:
``

Todos los métodos están implementados en `Main.java` usando `GestionAgencia`.

---

# 🔄 Ejecución del Proyecto

```bash
# Compilar
javac -d bin src/com/CreatividadDigital/**/*.java

# Ejecutar
java -cp bin com.CreatividadDigital.App.Main
```

---

# 📌 Conceptos Aplicados (Rúbrica)

| Pilar             | Descripción                            | Clase                    |
| ----------------- | -------------------------------------- | ------------------------ |
| **Abstracción**   | Clase abstracta y métodos obligatorios | `Persona`                |
| **Herencia**      | Estructura padre/hijo                  | `Cliente`, `Empleado`    |
| **Encapsulación** | Atributos privados + setters validados | Todas las clases         |
| **Polimorfismo**  | Sobrescritura y sobrecarga             | `Cliente`, `Empleado`    |
| **Colecciones**   | `ArrayList` + `HashMap` generics       | `GestionAgencia`         |
| **Excepciones**   | Lanzadas y manejadas                   | `GestionAgencia`, `Main` |
| **CRUD**          | 6 opciones del menú funcionando        | `Main`, `GestionAgencia` |

---

# 🧩 Conclusión

Este proyecto integra correctamente **todos los pilares de la Programación Orientada a Objetos**, acompañados de un **sistema CRUD completo**, colecciones genéricas, excepciones personalizadas y un menú interactivo funcional.

La agencia "Creativa Digital" sirve como dominio ideal para demostrar la modularidad y flexibilidad de una arquitectura basada en POO.

