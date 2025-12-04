package com.CreatividadDigital.servicio;

import com.CreatividadDigital.Modelo.CampanaPublicitaria;
import com.CreatividadDigital.Modelo.Cliente;
import com.CreatividadDigital.Modelo.Persona;
import com.CreatividadDigital.excepciones.CampanaNoEncontradaException;
import com.CreatividadDigital.excepciones.PresupuestoInvalidoException;

import java.util.*;





public class GestionAgencia {

    public final Map<String, Cliente> clientes;
    public final List<Persona> nomina;
    public final Map<String, CampanaPublicitaria> campanasActivas;

    public GestionAgencia() {
        clientes = new HashMap<>();
        nomina = new ArrayList<>();
        campanasActivas = new HashMap<>();
    }

    public void agregarCliente(Cliente c) {
        if (!clientes.containsKey(c.getId())) {
            clientes.put(c.getId(), c);
            nomina.add(c);
            System.out.println("Cliente agregado: " + c.getNombre());
        } else {
            System.out.println("El cliente con ID " + c.getId() + " ya existe.");
        }
    }

    public void agregarCampana(CampanaPublicitaria camp) {
        campanasActivas.put(camp.getCodigo(), camp);
        System.out.println("Campaña agregada exitosamente.");
    }

    public void listarNominaCompleta() {
        System.out.println("\n--- LISTA COMPLETA ---");
        for (Persona p : nomina) {
            System.out.println(p);
            p.mostrarRol();
            System.out.println("-----------------------");
        }
    }

    public CampanaPublicitaria buscarCampanaPorCodigo(String codigo)
            throws CampanaNoEncontradaException {

        CampanaPublicitaria camp = campanasActivas.get(codigo);
        if (camp == null)
            throw new CampanaNoEncontradaException("No existe la campaña: " + codigo);

        return camp;
    }

    public void modificarPresupuestoCampana(String codigo, double nuevoPresupuesto) {
        try {
            CampanaPublicitaria campana = buscarCampanaPorCodigo(codigo);

            if (nuevoPresupuesto <= 0)
                throw new PresupuestoInvalidoException("Presupuesto inválido: " + nuevoPresupuesto);

            campana.setPresupuesto(nuevoPresupuesto);
            System.out.println("Presupuesto actualizado.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
