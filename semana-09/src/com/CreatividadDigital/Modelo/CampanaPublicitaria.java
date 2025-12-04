package com.CreatividadDigital.Modelo;




public class CampanaPublicitaria implements Servicio {

    private final String codigo;
    private String nombre;
    private double presupuesto;
    private Cliente clienteAsignado;

    public CampanaPublicitaria(String codigo, String nombre, double presupuesto, Cliente clienteAsignado) {
        this.codigo = codigo;
        this.nombre = nombre;
        setPresupuesto(presupuesto);
        this.clienteAsignado = clienteAsignado;
    }

    @Override
    public double calcularCostoTotal() {
        return presupuesto * 0.90;
    }

    @Override
    public void ejecutarServicio() {
        System.out.println("Ejecutando campaña '" + nombre + "' para " + clienteAsignado.getEmpresa());
    }

    @Override
    public String toString() {
        return "Campana{" +
                "Codigo='" + codigo + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Presupuesto=" + presupuesto +
                ", Cliente=" + clienteAsignado.getEmpresa() +
                '}';
    }

    public String getCodigo() { return codigo; }

    public double getPresupuesto() { return presupuesto; }

    public void setPresupuesto(double presupuesto) {
        if (presupuesto <= 0)
            throw new IllegalArgumentException("El presupuesto debe ser mayor a 0");
        this.presupuesto = presupuesto;
    }
}
