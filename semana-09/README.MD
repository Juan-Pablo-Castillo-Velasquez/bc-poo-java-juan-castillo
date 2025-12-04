# 🧩 Proyecto Final Aplicado – Semana 09: Aplicación Integral de POO

## 📘 Sistema Integral de Gestión: Agencia de Publicidad "Creativa Digital"

Este proyecto implementa un sistema modular que demuestra la aplicación integral de la Programación Orientada a Objetos (POO) en Java, cumpliendo con todos los criterios de la Rúbrica de Evaluación de la Semana 09.

### 🎯 Objetivos de la Semana 09 (Proyecto Final)

* Diseñar una arquitectura con **5+ Clases del Dominio** que incluya **Herencia** y **Abstracción**.
* Aplicar los cuatro pilares de POO: **Encapsulación, Herencia, Polimorfismo y Abstracción**.
* Utilizar **Colecciones Genéricas** (`ArrayList` y `HashMap`) para la gestión de datos.
* Implementar **Excepciones Personalizadas** del dominio con manejo `try-catch`.
* Desarrollar un **Sistema Funcional** con menú interactivo y operaciones CRUD.

-----

## 📂 Archivos Entregados (Semana 09)

La estructura del proyecto está organizada en cuatro paquetes principales, siguiendo las mejores prácticas de modularidad.

```
src/
 ├── com.CreatividadDigital/
 │     ├── App/                      // CLASE PRINCIPAL (Menú)
 │     │     └── Main.java
 │     ├── excepciones/              // Requisito: Excepciones Personalizadas
 │     │     ├── CampanaNoEncontradaException.java
 │     │     └── PresupuestoInvalidoException.java
 │     ├── Modelo/                   // Requisito: 5+ Clases del Dominio
 │     │     ├── Persona.java          // CLASE ABSTRACTA (Padre)
 │     │     ├── Cliente.java          // HIJO 1
 │     │     ├── Empleado.java         // HIJO 2
 │     │     ├── Servicio.java         // INTERFACE
 │     │     ├── CampanaPublicitaria.java  // Implementa Servicio
 │     │     └── DisenoGrafico.java    // Implementa Servicio
 │     └── Servicio/                 // Requisito: Lógica de Negocio/CRUD
 │           └── GestionAgencia.java   // Colecciones y Métodos CRUD
```

-----

## 📐 Diagrama UML General

Este diagrama muestra la estructura de clases, las relaciones de herencia y abstracción, y las principales asociaciones con la clase de gestión.

```mermaid
classDiagram
    direction LR
    
    class GestionAgencia {
        -Map~String, Cliente~ clientes
        -List~Persona~ nomina
        +agregarCliente(Cliente)
        +listarNominaCompleta()
        +modificarPresupuesto(String, double)
    }
    
    abstract class Persona {
        -String id
        -String nombre
        +saludar()
        +abstract mostrarRol()
    }
    
    class Cliente {
        -String empresa
        +mostrarRol()
        +toString()
    }
    
    class Empleado {
        -String puesto
        -double salario
        +mostrarRol()
        +calcularBono(double)
    }
    
    interface Servicio {
        +calcularCostoTotal() double
        +ejecutarServicio()
    }
    
    class CampanaPublicitaria {
        -String codigo
        -double presupuesto
        -Cliente clienteAsignado
        +calcularCostoTotal()
        +setPresupuesto(double)
    }

    class DisenoGrafico {
        -String codigo
        -int horasDedicadas
        +calcularCostoTotal()
    }

    Persona <|-- Cliente : Herencia
    Persona <|-- Empleado : Herencia
    Servicio <|.. CampanaPublicitaria : Implementación
    Servicio <|.. DisenoGrafico : Implementación
    
    GestionAgencia "1" --> "*" Persona : Colección (Polimorfismo)
    GestionAgencia "1" --> "*" CampanaPublicitaria : Colección
    CampanaPublicitaria "1" --> "1" Cliente : Asociación
```

-----

## 🏛️ Descripción de la Aplicación Integral de POO

### 🟦 1. Abstracción y Herencia (Jerarquía `Persona`)

* **Clase Abstracta (`Persona.java`):** Define los atributos comunes (`id`, `nombre`, `email`) y el contrato (`mostrarRol()`) que debe ser implementado por todas las personas de la agencia.
* **Clases Concretas (`Cliente.java`, `Empleado.java`):** Extienden de `Persona` para heredar las características comunes y añaden atributos específicos (`empresa` o `salario`). Esto cumple la **Jerarquía de Herencia** (1 Padre + 2 Hijos).
* **Interface (`Servicio.java`):** Define el contrato `calcularCostoTotal()`, asegurando que cualquier clase de producto o servicio (`CampañaPublicitaria`, `DiseñoGrafico`) ofrezca esta funcionalidad.

### 🟩 2. Polimorfismo y Encapsulación

* **Polimorfismo por Sobrescritura:** La lista `List<Persona> nomina` almacena `Cliente` y `Empleado`. Al llamar al método `mostrarRol()` sobre cada elemento, se ejecuta el comportamiento específico de cada subclase.
* **Polimorfismo por Sobrecarga:** La clase `Empleado` implementa el método `calcularBono()` con diferentes firmas (ej., sin parámetros o recibiendo un porcentaje).
* **Encapsulación:** Todos los atributos en el paquete `Modelo` son `private`. Los métodos `set` (como `setPresupuesto`) incluyen **validaciones robustas** para prevenir entradas incorrectas (ej., valores negativos), reforzando la integridad del dato.

### 🟨 3. Colecciones y Excepciones

* **Colección List:** `ArrayList<Persona>` (`nomina`) en `GestionAgencia.java` se utiliza para listar todos los individuos de la agencia, aplicando el Polimorfismo.
* **Colección Map:** `HashMap<String, CampanaPublicitaria>` se utiliza en `GestionAgencia.java` para almacenar campañas con una clave única (`código`), permitiendo búsquedas rápidas (eficiencia **O(1)**).
* **Excepciones Personalizadas:** Se crearon `CampanaNoEncontradaException` y `PresupuestoInvalidoException` para manejar errores específicos del negocio.
* **Manejo `try-catch`:** Implementado en `GestionAgencia.java` y `Main.java` para capturar y notificar al usuario sobre las excepciones lanzadas (ej., al intentar modificar una campaña inexistente).

-----

## 🔄 Ejecución del Proyecto

El proyecto se ejecuta a través de la clase `Main.java` que presenta un menú interactivo.

```bash
# PASO 1: Compilación (Genera los .class en la carpeta 'bin')
javac -d bin src/com/CreatividadDigital/**/*.java

# PASO 2: Ejecución (Llamando a la clase principal por su nombre completo)
java -cp bin com.CreatividadDigital.App.Main
```

-----

## 📌 Conceptos Aplicados (Rúbrica de Sustentación)

| Pilar de POO | Concepto Aplicado | Clase Demostrada |
| :--- | :--- | :--- |
| **Abstracción** | Clase Abstracta / Interface | `Persona.java` / `Servicio.java` |
| **Encapsulación** | Atributos `private` y Validación en `setters` | Todas las clases de `Modelo` |
| **Herencia** | Jerarquía (Padre/Hijo) y uso de `super()` | `Cliente.java` y `Empleado.java` |
| **Polimorfismo** | Sobrescritura (`@Override`) en método `mostrarRol()` | `Cliente.java`, `Empleado.java` y `GestionAgencia.java` |
| **Colecciones** | Uso de `List` y `Map` con tipado Genérico (`<T>`) | `GestionAgencia.java` |
| **Manejo de Errores** | `throw` y `try-catch` | `GestionAgencia.java` y `Main.java` |

-----

## 🧩 Conclusión

El Proyecto Final cumple con la aplicación integral de POO, utilizando la **Agencia Creativa Digital** como dominio para demostrar la eficiencia del código modular, el manejo adecuado de colecciones para operaciones CRUD, y la robustez del sistema mediante el manejo de excepciones personalizadas.


