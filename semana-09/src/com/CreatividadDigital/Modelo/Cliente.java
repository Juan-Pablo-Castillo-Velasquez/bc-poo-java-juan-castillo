package com.CreatividadDigital.Modelo;


public class Cliente extends Persona {
    private String empresa;
    private String tipoCliente; // (Frecuente, Ocasional)

    // Constructor que usa super()
    public Cliente(String id, String nombre, String email, String empresa, String tipoCliente) {
        super(id, nombre, email); // Uso de super()
        this.empresa = empresa;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente. Representa a la empresa " + empresa + ".");
    }

    // Sobrescritura (Polimorfismo)
    @Override
    public String toString() {
        return super.toString() + ", Empresa: " + empresa + ", Tipo: " + tipoCliente;
    }

    // Getters y Setters
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }
}