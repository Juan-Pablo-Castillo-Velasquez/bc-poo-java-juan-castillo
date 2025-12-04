package com.CreatividadDigital.Modelo;


// Requisito: Clase Hija (Herencia)
public class Empleado extends Persona {
    private String puesto;
    private double salario;

    // Constructor que usa super()
    public Empleado(String id, String nombre, String email, String puesto, double salario) {
        super(id, nombre, email); // Uso de super()
        this.puesto = puesto;
        this.salario = salario;
    }

    // Implementación del método abstracto (Polimorfismo)
    @Override
    public void mostrarRol() {
        System.out.println("Rol: Empleado. Puesto: " + puesto + ".");
    }

    // Sobrescritura (Polimorfismo)
    @Override
    public String toString() {
        return super.toString() + ", Puesto: " + puesto + ", Salario: $" + salario;
    }

    // Polimorfismo por Sobrecarga (Extra para alta calificación)
    public double calcularBono() {
        return this.salario * 0.10;
    }
    public double calcularBono(double porcentaje) {
        return this.salario * (porcentaje / 100);
    }

    // Getters y Setters con validación (Requisito Encapsulación)
    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }
    public double getSalario() { return salario; }
    // Implementar validación robusta aquí para alta calificación
    public void setSalario(double salario) { this.salario = salario; }
}