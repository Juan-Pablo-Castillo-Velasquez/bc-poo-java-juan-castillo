#  Semana 08 – Estructuras de Datos en Java

## Inventario, Agenda y Conjuntos usando ArrayList, HashMap y HashSet

En esta semana se implementaron varias estructuras de datos utilizando las colecciones avanzadas de Java. Se desarrollaron tres ejercicios principales:

1. **Inventario de productos usando ArrayList**
2. **Agenda de contactos usando HashMap**
3. **Conjunto de productos únicos usando HashSet**, implementando correctamente `equals()` y `hashCode()`

Este trabajo aplica los conceptos de:

* Listas dinámicas (`ArrayList`)
* Mapas clave–valor (`HashMap`)
* Conjuntos sin duplicados (`HashSet`)
* Sobrescritura de métodos (`equals`, `hashCode`, `toString`)
* Búsqueda, inserción, eliminación y recorrido de estructuras de datos

---

# 📂 Estructura del Proyecto

```
semana-08/
├── Product.java
├── Inventory.java
├── Contact.java
├── ContactBook.java
├── ProductSetItem.java
├── ProductSet.java
└── README.md
```

---

# 🧩 1. Sistema de Inventario (ArrayList)

### ✔ Clase Product

Modela un producto con:

* `id`
* `name`
* `price`
* `quantity`

Incluye:

* getters/setters
* `toString()`

Código original:

```java
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Producto { id='" + id + "', nombre='" + name + 
               "', precio=" + price + ", cantidad=" + quantity + " }";
    }
}
```

### ✔ Clase Inventory (ArrayList<Product>)

Permite:

* agregar productos
* buscar por ID
* eliminar por ID
* obtener lista completa

Código original:

```java
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p) { products.add(p); }

    public boolean removeProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public Product getProduct(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    public ArrayList<Product> getAll() { return products; }

    public int size() { return products.size(); }
}
```

---

# 🧩 2. Agenda de Contactos (HashMap)

### ✔ Clase Contact

Modelo de contacto:

* id
* name
* phone
* email

Código original:

```java
public class Contact {
    private String id;
    private String name;
    private String phone;
    private String email;

    public Contact(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Contacto { id='" + id + "', nombre='" + name + 
               "', teléfono='" + phone + "', email='" + email + "' }";
    }
}
```

### ✔ Clase ContactBook (HashMap<String, Contact>)

Permite:

* agregar contacto
* buscar por ID
* eliminar
* validar existencia
* buscar por nombre
* obtener todos los contactos

Código original:

```java
import java.util.HashMap;
import java.util.ArrayList;

public class ContactBook {
    private HashMap<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact c) { contacts.put(c.getId(), c); }

    public Contact getContact(String id) { return contacts.get(id); }

    public boolean removeContact(String id) { return contacts.remove(id) != null; }

    public boolean contains(String id) { return contacts.containsKey(id); }

    public ArrayList<Contact> searchByName(String name) {
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact c : contacts.values()) {
            if (c.getName().equalsIgnoreCase(name)) result.add(c);
        }
        return result;
    }

    public ArrayList<Contact> getAll() {
        return new ArrayList<>(contacts.values());
    }
}
```

---

# 🧩 3. Conjuntos (HashSet)

Aquí se implementa correctamente:

* unicidad de elementos
* `equals()` y `hashCode()`
* operaciones de conjuntos (unión, intersección, diferencia)

### ✔ Clase ProductSetItem

Define un ítem único según su nombre:

```java
public class ProductSetItem {
    private String name;

    public ProductSetItem(String name) { this.name = name; }

    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductSetItem)) return false;
        ProductSetItem p = (ProductSetItem) o;
        return name.equalsIgnoreCase(p.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "ProductoSet { nombre='" + name + "' }";
    }
}
```

### ✔ Clase ProductSet (HashSet<ProductSetItem>)

Incluye:

* agregar
* eliminar
* unir
* intersectar
* diferenciar

Código original:

```java
import java.util.HashSet;
import java.util.Set;

public class ProductSet {
    private Set<ProductSetItem> items = new HashSet<>();

    public void add(ProductSetItem item) { items.add(item); }

    public boolean remove(String name) {
        return items.remove(new ProductSetItem(name));
    }

    public Set<ProductSetItem> getAll() { return items; }

    public Set<ProductSetItem> union(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.addAll(b);
        return result;
    }

    public Set<ProductSetItem> intersection(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.retainAll(b);
        return result;
    }

    public Set<ProductSetItem> difference(Set<ProductSetItem> b) {
        Set<ProductSetItem> result = new HashSet<>(items);
        result.removeAll(b);
        return result;
    }
}
```

---

# 🎯 Conceptos de la Semana 08 Aplicados

## ✔ ArrayList

* Lista dinámica de objetos (`Inventory` usa ArrayList<Product>)
* Permite inserción, búsqueda y eliminación secuencial

## ✔ HashMap

* Estructura clave–valor en la agenda (`ContactBook`)
* Búsquedas extremadamente rápidas
* No permite claves duplicadas

## ✔ HashSet

* Conjunto sin elementos repetidos
* Usa `equals()` y `hashCode()` para garantizar unicidad
* Implementa operaciones matemáticas de conjuntos

## ✔ equals() y hashCode()

Implementados correctamente en:

```
ProductSetItem
```

Esto es obligatorio para que `HashSet` funcione sin duplicados.

---

# 📊 Comparativa por Ejercicio

| Ejercicio  | Estructura | Uso                            | Archivos                             |
| ---------- | ---------- | ------------------------------ | ------------------------------------ |
| Inventario | ArrayList  | Lista dinámica de productos    | Product.java, Inventory.java         |
| Agenda     | HashMap    | Acceso rápido por ID           | Contact.java, ContactBook.java       |
| Conjunto   | HashSet    | Elementos únicos + operaciones | ProductSetItem.java, ProductSet.java |

---

# 📝 Checklist Semana 08 (COMPLETO)

* [x] ArrayList implementado
* [x] HashMap implementado
* [x] HashSet implementado
* [x] equals() sobrescrito
* [x] hashCode() sobrescrito
* [x] toString() sobrescrito
* [x] Búsquedas por ID y por nombre
* [x] Eliminación en las 3 estructuras
* [x] Operaciones de conjuntos (unión, intersección, diferencia)
* [x] Documentación completa

---

# 🚀 Versión Final

**Semana 08 – Estructuras de Datos Avanzadas en Java**
**Estado:** COMPLETADO
**Versión:** 1.0

---

