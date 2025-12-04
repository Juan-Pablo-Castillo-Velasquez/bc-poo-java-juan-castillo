package com.CreatividadDigital.excepciones;


public class PresupuestoInvalidoException extends RuntimeException {

    public PresupuestoInvalidoException(String mensaje) {
        super(mensaje);
    }
}