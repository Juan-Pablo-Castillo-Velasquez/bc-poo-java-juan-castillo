package com.CreatividadDigital.Excepciones;


public class PresupuestoInvalidoException extends Exception {

    public PresupuestoInvalidoException() {
        super("El presupuesto debe ser mayor a 1000.");
    }

    public PresupuestoInvalidoException(String message) {
        super(message);
    }
}
