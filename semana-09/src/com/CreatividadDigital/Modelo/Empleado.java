package com.CreatividadDigital.Modelo;



public class Empleado extends Persona {

    private String puesto;
    private double salario;

    public Empleado(String id, String nombre, String email, String puesto, double salario) {
        super(id, nombre, email);
        this.puesto = puesto;
        setSalario(salario);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Empleado. Puesto: " + puesto);
    }

    @Override
    public String toString() {
        return super.toString() + ", Puesto: " + puesto + ", Salario: $" + salario;
    }

    public double calcularBono() { return salario * 0.10; }
    public double calcularBono(double porcentaje) { return salario * (porcentaje / 100); }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public double getSalario() { return salario; }

    public void setSalario(double salario) {
        if (salario <= 0)
            throw new IllegalArgumentException("El salario debe ser mayor a 0");
        this.salario = salario;
    }
}
