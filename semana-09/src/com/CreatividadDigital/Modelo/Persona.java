package com.CreatividadDigital.Modelo;




public abstract class Persona {

    private final String id;
    private String nombre;
    private String email;

    public Persona(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public abstract void mostrarRol();

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + ".");
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Email: " + email;
    }
}
