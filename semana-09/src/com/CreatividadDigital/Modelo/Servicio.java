package com.CreatividadDigital.Modelo;


public interface Servicio {

    /**
     * Calcula el costo total del servicio o proyecto.
     * @return Costo total en double.
     */
    double calcularCostoTotal();

    /**
     * Muestra una simulación de la ejecución del servicio.
     */
    void ejecutarServicio();
}