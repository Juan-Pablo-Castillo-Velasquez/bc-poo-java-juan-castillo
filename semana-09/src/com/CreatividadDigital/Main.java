package com.CreatividadDigital;



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
            mostrarMenu(); // Requisito: Menú interactivo funcional
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Opción inválida
            }

            switch (opcion) {
                case 1: agencia.listarNominaCompleta(); break; // READ
                case 2: // Implementar crear cliente
                    // ...
                    break;
                case 3: // Implementar agregar campaña
                    // ...
                    break;
                case 4:
                    modificarCampana(); // UPDATE y manejo de excepciones
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== CREATIVA DIGITAL - GESTIÓN =====");
        System.out.println("1. Listar toda la Nómina y Clientes (Polimorfismo)");
        System.out.println("2. Agregar Nuevo Cliente (CREATE)");
        System.out.println("3. Agregar Nueva Campaña");
        System.out.println("4. Modificar Presupuesto de Campaña (Try-Catch)");
        // Agregar más funcionalidades para cumplir el requisito de 4+
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void modificarCampana() {
        System.out.print("Ingrese código de campaña a modificar: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nuevo presupuesto: ");

        try {
            double nuevoPresupuesto = Double.parseDouble(scanner.nextLine());
            agencia.modificarPresupuestoCampana(codigo, nuevoPresupuesto);
        } catch (NumberFormatException e) {
            System.err.println(" Error: El presupuesto debe ser un número válido.");
        }
    }

    private static void inicializarDatos() {
        // Requisito: 4+ Funcionalidades
        Cliente c1 = new Cliente("C001", "Juan Perez", "juan@tech.com", "TechCorp", "Frecuente");
        Cliente c2 = new Cliente("C002", "Ana Lopez", "ana@fashion.com", "Fashion Boutique", "Ocasional");
        Empleado e1 = new Empleado("E001", "Carlos Rodriguez", "carlos@agencia.com", "Diseñador Senior", 3500000);
        Empleado e2 = new Empleado("E002", "Maria Gomez", "maria@agencia.com", "Community Manager", 2800000);

        agencia.agregarCliente(c1);
        agencia.agregarCliente(c2);
        // Agregar empleados a la lista polimórfica (simulación de agregar)
        agencia.nomina.add(e1);
        agencia.nomina.add(e2);

        // Agregar campañas (simulación de agregar)
        agencia.campañasActivas.put("CAMP-001", new CampanaPublicitaria("CAMP-001", "Lanzamiento Web", 15000000, c1));
        agencia.campañasActivas.put("CAMP-002", new CampanaPublicitaria("CAMP-002", "Oferta Verano", 8000000, c2));

        System.out.println("Datos iniciales cargados.");
    }
}