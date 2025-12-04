package com.CreatividadDigital.Modelo;


public class DiseñoGrafico implements Servicio {
    private String codigo;
    private String tipoDiseno; // (Logo, Banner, Web)
    private double tarifaPorHora;
    private int horasDedicadas;

    public DiseñoGrafico(String codigo, String tipoDiseno, double tarifaPorHora, int horasDedicadas) {
        this.codigo = codigo;
        this.tipoDiseno = tipoDiseno;
        this.tarifaPorHora = tarifaPorHora;
        this.horasDedicadas = horasDedicadas;
    }

    // Implementación del método de la Interface
    @Override
    public double calcularCostoTotal() {
        return this.tarifaPorHora * this.horasDedicadas;
    }

    // Implementación del método de la Interface
    @Override
    public void ejecutarServicio() {
        System.out.println("Finalizando diseño de " + tipoDiseno + ".");
        System.out.println("Horas invertidas: " + horasDedicadas);
    }

    @Override
    public String toString() {
        return "Diseño{" +
                "Código='" + codigo + '\'' +
                ", Tipo='" + tipoDiseno + '\'' +
                ", Costo Total=" + calcularCostoTotal() +
                '}';
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    // ... otros getters y setters
}