package com.CreatividadDigital.Modelo;




public class DiseñoGrafico implements Servicio {

    private String codigo;
    private String tipoDiseno;
    private double tarifaPorHora;
    private int horasDedicadas;

    public void DisenoGrafico(String codigo, String tipoDiseno, double tarifaPorHora, int horasDedicadas) {
        this.codigo = codigo;
        this.tipoDiseno = tipoDiseno;
        this.tarifaPorHora = tarifaPorHora;
        this.horasDedicadas = horasDedicadas;
    }

    public DiseñoGrafico(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public double calcularCostoTotal() {
        return tarifaPorHora * horasDedicadas;
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Finalizando diseño (" + tipoDiseno + "), horas invertidas: " + horasDedicadas);
    }

    @Override
    public String toString() {
        return "DisenoGrafico{" +
                "Codigo='" + codigo + '\'' +
                ", Tipo='" + tipoDiseno + '\'' +
                ", Costo Total=" + calcularCostoTotal() +
                '}';
    }

    public String getCodigo() { return codigo; }
}
