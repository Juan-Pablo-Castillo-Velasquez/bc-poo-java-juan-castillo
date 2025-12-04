package com.CreatividadDigital.servicio;

import com.CreatividadDigital.Modelo.CampanaPublicitaria;
import com.CreatividadDigital.Modelo.Cliente;
import com.CreatividadDigital.Modelo.Persona;
import com.CreatividadDigital.excepciones.CampanaNoEncontradaException;
import com.CreatividadDigital.excepciones.PresupuestoInvalidoException;

import java.util.*;

// Requisitos: Colecciones (List y Map) y Lógica CRUD
public class GestionAgencia {

    private Map<String, Cliente> clientes;
    public List<Persona> nomina;
    public Map<String, CampanaPublicitaria> campañasActivas;

    public GestionAgencia() {
        // Inicialización de colecciones con Generics
        this.clientes = new HashMap<>();
        this.nomina = new ArrayList<>();
        this.campañasActivas = new HashMap<>();
    }


    public void agregarCliente(Cliente c) {
        if (!clientes.containsKey(c.getId())) {
            clientes.put(c.getId(), c);
            nomina.add(c); // Agregamos a la lista polimórfica
            System.out.println(" Cliente " + c.getNombre() + " agregado con éxito.");
        } else {
            System.out.println("️ Error: El cliente con ID " + c.getId() + " ya existe.");
        }
    }


    public void listarNominaCompleta() {
        System.out.println("\n--- LISTADO COMPLETO DE PERSONAS ---");
        for (Persona p : nomina) {
            System.out.println(p.toString());
            p.mostrarRol(); // Uso del método polimórfico
            System.out.println("------------------------------------");
        }
    }

    public CampanaPublicitaria buscarCampanaPorCodigo(String codigo) throws CampanaNoEncontradaException {
        // Uso de Map para buscar (más rápido)
        if (campañasActivas.containsKey(codigo)) {
            return campañasActivas.get(codigo);
        } else {
            // Requisito: Lanzar Excepción Personalizada
            throw new CampanaNoEncontradaException("La campaña con código " + codigo + " no fue encontrada.");
        }
    }


    public void modificarPresupuestoCampana(String codigo, double nuevoPresupuesto) {
        try { // Requisito: Try-Catch implementado
            CampanaPublicitaria campana = buscarCampanaPorCodigo(codigo);

            // Lanza una RuntimeException si el presupuesto es inválido
            if (nuevoPresupuesto < 0) {
                throw new PresupuestoInvalidoException("El presupuesto no puede ser negativo: " + nuevoPresupuesto);
            }

            campana.setPresupuesto(nuevoPresupuesto);
            System.out.println(" Presupuesto de campaña " + codigo + " actualizado a $" + nuevoPresupuesto);

        } catch (CampanaNoEncontradaException e) {
            // Manejo de la excepción personalizada
            System.err.println(" Error de Operación: " + e.getMessage());
        } catch (PresupuestoInvalidoException e) {
            // Manejo de la excepción de Runtime
            System.err.println(" Error de Validación: " + e.getMessage());
        }
    }

}