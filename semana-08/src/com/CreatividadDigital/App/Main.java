package com.CreatividadDigital.App;

import com.CreatividadDigital.Modelo.Contact;
import com.CreatividadDigital.Modelo.Product;
import com.CreatividadDigital.Modelo.ProductSetItem;
import com.CreatividadDigital.service.ContactBook;
import com.CreatividadDigital.service.Inventory;
import com.CreatividadDigital.service.ProductSet;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.InputMismatchException;
import java.util.ArrayList;


public class Main {

    private static Inventory inventory = new Inventory();
    private static ContactBook contactBook = new ContactBook();
    private static ProductSet productSet = new ProductSet();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        seedSampleData(); // Datos iniciales para probar rápido
        boolean running = true;

        while (running) {
            showMainMenu();
            int option = readInt("Elige una opción: ");

            switch (option) {
                case 1 -> handleInventoryMenu();
                case 2 -> handleContactMenu();
                case 3 -> handleProductSetMenu();
                case 4 -> iteratorsWorkshop();
                case 5 -> {
                    System.out.println("Saliendo... ¡Éxitos con tu entrega de la Semana 8!");
                    running = false;
                }
                default -> System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }

        sc.close();
    }

    // --- Menús ---
    private static void showMainMenu() {
        System.out.println("\n======= PROYECTO: Creativa Digital - Semana 08 =======");
        System.out.println("1. Inventario (ArrayList)");
        System.out.println("2. Agenda de contactos (HashMap)");
        System.out.println("3. Gestión de productos (Set)");
        System.out.println("4. Taller: Iteradores y Bucles");
        System.out.println("5. Salir");
    }

    // ---------- INVENTORY ----------
    private static void handleInventoryMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Inventario ---");
            System.out.println("1. Listar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Eliminar producto por ID");
            System.out.println("4. Buscar producto por ID");
            System.out.println("5. Volver");
            int opt = readInt("Opción: ");
            switch (opt) {
                case 1 -> listProducts();
                case 2 -> addProductInteractive();
                case 3 -> removeProductInteractive();
                case 4 -> findProductInteractive();
                case 5 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listProducts() {
        ArrayList<Product> all = inventory.getAll();
        if (all.isEmpty()) {
            System.out.println("Inventario vacío.");
            return;
        }
        System.out.println("Productos en inventario:");
        for (Product p : all) System.out.println(p);
    }

    private static void addProductInteractive() {
        sc.nextLine(); // limpiar buffer
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String name = sc.nextLine().trim();
        double price = readDouble("Precio: ");
        int qty = readInt("Cantidad: ");
        inventory.addProduct(new Product(id, name, price, qty));
        System.out.println("Producto agregado.");
    }

    private static void removeProductInteractive() {
        sc.nextLine();
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine().trim();
        boolean ok = inventory.removeProduct(id);
        System.out.println(ok ? "Producto eliminado." : "No se encontró el producto.");
    }

    private static void findProductInteractive() {
        sc.nextLine();
        System.out.print("ID a buscar: ");
        String id = sc.nextLine().trim();
        Product p = inventory.getProduct(id);
        System.out.println(p == null ? "Producto no encontrado." : p);
    }

    // ---------- CONTACT BOOK ----------
    private static void handleContactMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Agenda de Contactos ---");
            System.out.println("1. Listar contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Eliminar contacto por ID");
            System.out.println("4. Buscar por ID");
            System.out.println("5. Buscar por nombre");
            System.out.println("6. Volver");
            int opt = readInt("Opción: ");
            switch (opt) {
                case 1 -> listContacts();
                case 2 -> addContactInteractive();
                case 3 -> removeContactInteractive();
                case 4 -> findContactById();
                case 5 -> findContactsByName();
                case 6 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listContacts() {
        ArrayList<Contact> all = contactBook.getAll();
        if (all.isEmpty()) {
            System.out.println("No hay contactos.");
            return;
        }
        System.out.println("Contactos:");
        for (Contact c : all) System.out.println(c);
    }

    private static void addContactInteractive() {
        sc.nextLine();
        System.out.print("ID: ");
        String id = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String name = sc.nextLine().trim();
        System.out.print("Teléfono: ");
        String phone = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        Contact c = new Contact(id, name, phone, email);
        contactBook.addContact(c);
        System.out.println("Contacto agregado.");
    }

    private static void removeContactInteractive() {
        sc.nextLine();
        System.out.print("ID a eliminar: ");
        String id = sc.nextLine().trim();
        boolean ok = contactBook.removeContact(id);
        System.out.println(ok ? "Contacto eliminado." : "No se encontró el contacto.");
    }

    private static void findContactById() {
        sc.nextLine();
        System.out.print("ID a buscar: ");
        String id = sc.nextLine().trim();
        Contact c = contactBook.getContact(id);
        System.out.println(c == null ? "No encontrado." : c);
    }

    private static void findContactsByName() {
        sc.nextLine();
        System.out.print("Nombre a buscar: ");
        String name = sc.nextLine().trim();
        ArrayList<Contact> results = contactBook.searchByName(name);
        if (results.isEmpty()) {
            System.out.println("No se encontraron coincidencias.");
            return;
        }
        System.out.println("Resultados:");
        for (Contact c : results) System.out.println(c);
    }

    // ---------- PRODUCT SET ----------
    private static void handleProductSetMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- ProductSet (Set) ---");
            System.out.println("1. Listar items");
            System.out.println("2. Agregar item");
            System.out.println("3. Eliminar item");
            System.out.println("4. Operaciones: union/intersección/diferencia (ejemplo)");
            System.out.println("5. Volver");
            int opt = readInt("Opción: ");
            switch (opt) {
                case 1 -> listSetItems();
                case 2 -> addSetItemInteractive();
                case 3 -> removeSetItemInteractive();
                case 4 -> setOperationsDemo();
                case 5 -> back = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private static void listSetItems() {
        Set<ProductSetItem> all = productSet.getAll();
        if (all.isEmpty()) {
            System.out.println("Conjunto vacío.");
            return;
        }
        System.out.println("Items en Set:");
        for (ProductSetItem it : all) System.out.println(it);
    }

    private static void addSetItemInteractive() {
        sc.nextLine();
        System.out.print("Nombre producto: ");
        String name = sc.nextLine().trim();
        productSet.add(new ProductSetItem(name));
        System.out.println("Item agregado (si no era duplicado).");
    }

    private static void removeSetItemInteractive() {
        sc.nextLine();
        System.out.print("Nombre a eliminar: ");
        String name = sc.nextLine().trim();
        boolean ok = productSet.remove(name);
        System.out.println(ok ? "Eliminado." : "No se encontró el item.");
    }

    private static void setOperationsDemo() {
        // Creamos un segundo set para el ejemplo
        Set<ProductSetItem> other = new HashSet<>();
        other.add(new ProductSetItem("Micrófono"));
        other.add(new ProductSetItem("Cámara"));
        other.add(new ProductSetItem("Trípode"));

        Set<ProductSetItem> union = productSet.union(other);
        Set<ProductSetItem> inter = productSet.intersection(other);
        Set<ProductSetItem> diff = productSet.difference(other);

        System.out.println("Set A (actual): " + productSet.getAll());
        System.out.println("Set B (ejemplo): " + other);
        System.out.println("Unión: " + union);
        System.out.println("Intersección: " + inter);
        System.out.println("Diferencia (A - B): " + diff);
    }

    // ---------- ITERATORS WORKSHOP ----------
    private static void iteratorsWorkshop() {
        System.out.println("\n--- Taller: Iteradores y Bucles ---");

        // Preparar una lista de prueba
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento1");
        lista.add("Elemento2");
        lista.add("Elemento3");
        lista.add("Elemento4");
        System.out.println("Lista original: " + lista);

        // For tradicional
        System.out.println("\nFor tradicional:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(i + ": " + lista.get(i));
        }

        // For-each
        System.out.println("\nFor-each:");
        for (String s : lista) System.out.println(s);

        // Iterator para eliminar de forma segura
        System.out.println("\nIterator: eliminar elementos que contienen '3'");
        Iterator<String> it = lista.iterator();
        while (it.hasNext()) {
            String v = it.next();
            if (v.contains("3")) {
                it.remove(); // eliminación segura usando Iterator
                System.out.println("Eliminado: " + v);
            }
        }
        System.out.println("Lista después de eliminar: " + lista);

        // Comparación breve (impresa)
        System.out.println("\nComparación rápida:");
        System.out.println("- For tradicional: control por índice, útil cuando necesitas índices.");
        System.out.println("- For-each: más legible, no permite modificar la colección mientras iteras.");
        System.out.println("- Iterator: permite eliminar elementos durante la iteración de forma segura.");
    }

    // ---------- UTILIDADES ----------
    private static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Ingresa un número entero.");
                sc.next(); // limpiar token inválido
            }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException ex) {
                System.out.println("Entrada inválida. Ingresa un número decimal válido.");
                sc.next();
            }
        }
    }

    // Datos iniciales para probar
    private static void seedSampleData() {
        inventory.addProduct(new Product("P-001", "Cámara DSLR", 2500000.0, 3));
        inventory.addProduct(new Product("P-002", "Laptop Diseño", 4500000.0, 2));
        inventory.addProduct(new Product("P-003", "Micrófono Condenser", 350000.0, 5));

        contactBook.addContact(new Contact("C-001", "Andrés Pérez", "3001234567", "andres@techcorp.com"));
        contactBook.addContact(new Contact("C-002", "María Gómez", "3107654321", "maria@fashion.com"));

        productSet.add(new ProductSetItem("Cámara"));
        productSet.add(new ProductSetItem("Micrófono"));
        productSet.add(new ProductSetItem("Iluminación"));
    }
}
