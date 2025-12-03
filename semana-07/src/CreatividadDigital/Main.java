package CreatividadDigital;

import CreatividadDigital.Excepciones.FechaInvalidaException;
import CreatividadDigital.Excepciones.PresupuestoInvalidoException;
import CreatividadDigital.Modelo.CampaniaPublicitaria;
import CreatividadDigital.Servicio.ServicioCampania;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        ServicioCampania servicio = new ServicioCampania();

        // Caso 1: Registro exitoso
        try {
            CampaniaPublicitaria c1 = new CampaniaPublicitaria(
                    "CMP01", "Netflix", 5000, LocalDate.parse("2025-01-10"));
            servicio.crearCampania(c1);
            System.out.println("Campaña registrada correctamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Caso 2: Error por presupuesto
        try {
            CampaniaPublicitaria c2 = new CampaniaPublicitaria(
                    "CMP02", "Coca-Cola", 200, LocalDate.parse("2025-02-15"));
            servicio.crearCampania(c2);
        } catch (PresupuestoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (FechaInvalidaException e) {
            System.out.println(e.getMessage());
        }

        // Caso 3: Error por fecha (formato incorrecto)
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            CampaniaPublicitaria c3 = new CampaniaPublicitaria(
                    "CMP03", "Pepsi", 3000, LocalDate.parse("15/02/2025", formatter));
            servicio.crearCampania(c3);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Caso 4: Registro exitoso
        try {
            CampaniaPublicitaria c4 = new CampaniaPublicitaria(
                    "CMP04", "Adidas", 8000, LocalDate.parse("2025-03-20"));
            servicio.crearCampania(c4);
            System.out.println("Campaña registrada exitosamente.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Caso 5: Mostrar campañas
        System.out.println("\nListado de campañas registradas:");
        for (CampaniaPublicitaria c : servicio.listarCampanias()) {
            System.out.println(c);
        }
    }
}