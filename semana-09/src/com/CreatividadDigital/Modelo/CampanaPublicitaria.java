package com.CreatividadDigital.Modelo;


public class CampanaPublicitaria implements Servicio {
    private String codigo;
    private String nombre;
    private double presupuesto;
    private Cliente clienteAsignado; // Asociación

    public CampanaPublicitaria(String codigo, String nombre, double presupuesto, Cliente clienteAsignado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.clienteAsignado = clienteAsignado;
    }

    // Implementación del método de la Interface
    @Override
    public double calcularCostoTotal() {
        // Lógica de cálculo (ej. presupuesto - 10% de margen)
        return this.presupuesto * 0.90;
    }

    // Implementación del método de la Interface
    @Override
    public void ejecutarServicio() {
        System.out.println("Iniciando campaña '" + nombre + "' para " + clienteAsignado.getEmpresa());
        System.out.println("Duración estimada: 30 días.");
    }

    @Override
    public String toString() {
        return "Campaña{" +
                "Código='" + codigo + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Presupuesto=" + presupuesto +
                ", Cliente=" + clienteAsignado.getEmpresa() +
                '}';
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public double getPresupuesto() { // <--- GETTER
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) { // <--- SETTER
        this.presupuesto = presupuesto;
    }

}