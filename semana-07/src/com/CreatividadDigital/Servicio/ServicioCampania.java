package com.CreatividadDigital.Servicio;

import com.CreatividadDigital.Excepciones.FechaInvalidaException;
import com.CreatividadDigital.Excepciones.PresupuestoInvalidoException;
import com.CreatividadDigital.Modelo.CampaniaPublicitaria;

import java.util.ArrayList;

public class ServicioCampania {

    private ArrayList<CampaniaPublicitaria> listaCampanias = new ArrayList<>();

    public void crearCampania(CampaniaPublicitaria campania)
            throws PresupuestoInvalidoException, FechaInvalidaException {

        validarPresupuesto(campania.getPresupuesto());
        validarFecha(String.valueOf(campania.getFechaInicio()));

        listaCampanias.add(campania);
    }

    private void validarPresupuesto(int presupuesto) throws PresupuestoInvalidoException {
        if (presupuesto < 1000) {
            throw new PresupuestoInvalidoException();
        }
    }

    private void validarFecha(String fecha) throws FechaInvalidaException {
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new FechaInvalidaException();
        }
    }

    public ArrayList<CampaniaPublicitaria> listarCampanias() {
        return listaCampanias;
    }
}