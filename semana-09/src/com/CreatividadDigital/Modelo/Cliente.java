package com.CreatividadDigital.Modelo;




public class Cliente extends Persona {

    private String empresa;
    private String tipoCliente;

    public Cliente(String id, String nombre, String email, String empresa, String tipoCliente) {
        super(id, nombre, email);
        this.empresa = empresa;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Rol: Cliente. Empresa: " + empresa);
    }

    @Override
    public String toString() {
        return super.toString() + ", Empresa: " + empresa + ", Tipo: " + tipoCliente;
    }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getTipoCliente() { return tipoCliente; }
    public void setTipoCliente(String tipoCliente) { this.tipoCliente = tipoCliente; }
}
