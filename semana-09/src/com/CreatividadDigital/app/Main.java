package com.CreatividadDigital.app;



import com.CreatividadDigital.Modelo.CampanaPublicitaria;
import com.CreatividadDigital.Modelo.Cliente;
import com.CreatividadDigital.Modelo.Empleado;
import com.CreatividadDigital.servicio.GestionAgencia;

import java.util.Scanner;


public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final GestionAgencia agencia = new GestionAgencia();

    public static void main(String[] args) {

        inicializarDatos();

        int opcion;
        do {
            mostrarMenu();

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1 -> agencia.listarNominaCompleta();
                case 2 -> agregarCliente();
                case 3 -> agregarCampana();
                case 4 -> modificarCampana();
                case 5 -> buscarCampana();
                case 6 -> eliminarCampana();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n==== MENÚ PRINCIPAL ====");
        System.out.println("1. Listar Nómina y Clientes (Polimorfismo)");
        System.out.println("2. Agregar Nuevo Cliente (CREATE)");
        System.out.println("3. Agregar Nueva Campaña (CREATE)");
        System.out.println("4. Modificar Presupuesto de Campaña (UPDATE)");
        System.out.println("5. Buscar Campaña (READ)");
        System.out.println("6. Eliminar Campaña (DELETE)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void agregarCliente() {
        System.out.println("\n=== NUEVO CLIENTE ===");
        System.out.print("ID: ");
        String id = scanner.nextLine();

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Tipo de cliente (Frecuente/Ocasional): ");
        String tipo = scanner.nextLine();

        Cliente c = new Cliente(id, nombre, email, empresa, tipo);
        agencia.agregarCliente(c);
    }

    private static void agregarCampana() {
        System.out.println("\n=== NUEVA CAMPAÑA ===");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nombre campaña: ");
        String nombre = scanner.nextLine();

        System.out.print("Presupuesto: ");
        double presupuesto = Double.parseDouble(scanner.nextLine());

        System.out.print("ID del cliente asignado: ");
        String idCliente = scanner.nextLine();

        Cliente cliente = agencia.clientes.get(idCliente);

        if (cliente == null) {
            System.out.println("No existe ese cliente.");
            return;
        }

        CampanaPublicitaria camp = new CampanaPublicitaria(codigo, nombre, presupuesto, cliente);
        agencia.agregarCampana(camp);
    }

    private static void modificarCampana() {
        System.out.print("Código de campaña: ");
        String codigo = scanner.nextLine();

        System.out.print("Nuevo presupuesto: ");
        double nuevoPresupuesto;

        try {
            nuevoPresupuesto = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Debe ingresar un número válido.");
            return;
        }

        agencia.modificarPresupuestoCampana(codigo, nuevoPresupuesto);
    }

    private static void buscarCampana() {
        System.out.print("Código de campaña: ");
        String codigo = scanner.nextLine();
        try {
            System.out.println(agencia.buscarCampanaPorCodigo(codigo));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarCampana() {
        System.out.print("Código de campaña a eliminar: ");
        String codigo = scanner.nextLine();

        if (agencia.campanasActivas.remove(codigo) != null)
            System.out.println("Campaña eliminada.");
        else
            System.out.println("No existe esa campaña.");
    }

    private static void inicializarDatos() {
        Cliente c1 = new Cliente("C001", "Juan Perez", "juan@tech.com", "TechCorp", "Frecuente");
        Cliente c2 = new Cliente("C002", "Ana Lopez", "ana@fashion.com", "Fashion Boutique", "Ocasional");

        Empleado e1 = new Empleado("E001", "Carlos Rodriguez", "carlos@agencia.com", "Diseñador Senior", 3500000);
        Empleado e2 = new Empleado("E002", "Maria Gomez", "maria@agencia.com", "Community Manager", 2800000);

        agencia.agregarCliente(c1);
        agencia.agregarCliente(c2);

        agencia.nomina.add(e1);
        agencia.nomina.add(e2);

        agencia.campanasActivas.put("CAMP-001",
                new CampanaPublicitaria("CAMP-001", "Lanzamiento Web", 15000000, c1));

        agencia.campanasActivas.put("CAMP-002",
                new CampanaPublicitaria("CAMP-002", "Oferta Verano", 8000000, c2));
    }
}
