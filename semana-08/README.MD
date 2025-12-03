# 🧩 Semana 08 – Colecciones, Genéricos e Iteradores

## 📘 Sistema de Gestión de Inventarios, Agenda y Productos (ArrayList, HashMap, Set)

Este conjunto de ejercicios implementa un sistema modular basado en colecciones de Java, aplicando conceptos fundamentales como:

* Uso de **ArrayList**, **HashMap** y **Set**
* **Genéricos** para crear listas y mapas tipados
* **Iteradores** para recorrer colecciones
* Manejo de **CRUD** en estructuras dinámicas
* Organización por paquetes (`model`, `service`, `app`)
* **Proyecto final**: Agenda de Contactos completa con HashMap

---

## 🎯 Objetivos de la Semana 08

* Usar colecciones (List, Map, Set) correctamente
* Aplicar genéricos para maximizar seguridad de tipos
* Implementar CRUD usando ArrayList, HashMap y Set
* Aplicar polimorfismo en colecciones
* Utilizar iteradores para recorrer elementos
* Crear una Agenda de Contactos funcional
* Entregar clases organizadas en capas (model, service, app)

---

## 📂 Archivos Entregados (Semana 08)

```
src/
 ├── model/
 │     ├── Product.java
 │     ├── Contact.java
 │     ├── ProductSetItem.java
 │
 ├── service/
 │     ├── Inventory.java         // ArrayList
 │     ├── ContactBook.java       // HashMap
 │     ├── ProductSet.java        // Set
 │
 ├── app/
       └── Main.java              // Menú principal
```

---

## 📐 Diagrama UML General

```
classDiagram
    class Product {
        -String id
        -String name
        -int quantity
    }

    class Inventory {
        -ArrayList~Product~ products
        +addProduct(Product)
        +removeProduct(String)
        +searchProduct(String)
        +showInventory()
    }

    class Contact {
        -String phone
        -String name
        -String email
    }

    class ContactBook {
        -HashMap~String, Contact~ contacts
        +addContact(Contact)
        +removeContact(String)
        +getContact(String)
        +showContacts()
    }

    class ProductSetItem {
        -String code
        -String description
    }

    class ProductSet {
        -Set~ProductSetItem~ items
        +addItem(ProductSetItem)
        +removeItem(String)
        +showItems()
    }

    Main --> Inventory
    Main --> ContactBook
    Main --> ProductSet
```

---

## 🏛️ Descripción de Cada Módulo

### 🟦 1. Inventory (ArrayList)

Representa un inventario simple con:

* Productos almacenados en un `ArrayList<Product>`
* **CRUD completo**:
    * agregar
    * eliminar
    * buscar
    * listar
* Iteración con:

```java
for (Product p : products)
```

---

### 🟩 2. ContactBook (HashMap)

Agenda de contactos:

* **Llave del mapa** → número telefónico
* **Valor** → objeto Contact
* Garantiza búsquedas rápidas **O(1)**

**CRUD**:
* `addContact()`
* `removeContact()`
* `getContact()`
* `showContacts()`

---

### 🟨 3. ProductSet (Set)

Gestión de productos únicos:

* No permite duplicados
* Implementable con **HashSet** o **TreeSet**

Uso de iteradores:

```java
Iterator<ProductSetItem> it = items.iterator();
```

---

## 🔄 Polimorfismo en Colecciones

```java
ArrayList<Object> allCollections = new ArrayList<>();
allCollections.add(inventory);
allCollections.add(contactBook);
allCollections.add(productSet);
```

---

## 🚀 Ejecución

```bash
cd src
javac app/Main.java
java app.Main
```

---

## 📌 Conceptos Aplicados

* **Colecciones**: List, Set, Map
* **Genéricos**
* **Iteradores**
* **CRUD**
* **Paquetes Java**
* Código limpio y reutilizable

---

## 🧩 Conclusión

La **Semana 08** integra los conceptos más importantes de colecciones en Java, permitiendo modelar múltiples sistemas (inventario, agenda, productos únicos) con un diseño limpio y mantenible. La separación por paquetes asegura escalabilidad y claridad en el código.