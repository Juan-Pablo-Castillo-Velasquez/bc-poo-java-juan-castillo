
import CreatividadDigital.Excepciones.FechaInvalidaException;
import CreatividadDigital.Excepciones.PresupuestoInvalidoException;
import CreatividadDigital.Modelo.CampaniaPublicitaria;
import CreatividadDigital.Servicio.ServicioCampania;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ServicioCampania servicio = new ServicioCampania();

        // Caso 1: Registro exitoso
        try {
            CampaniaPublicitaria c1 = new CampaniaPublicitaria(
                    "CMP01", "Netflix", 5000, LocalDate.parse("2025-01-10"));
            servicio.crearCampania(c1);
            System.out.println("✓ Campaña registrada correctamente.");
        } catch (PresupuestoInvalidoException | FechaInvalidaException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error inesperado: " + e.getMessage());
        }

        // Caso 2: Error por presupuesto bajo (200 < 1000)
        try {
            CampaniaPublicitaria c2 = new CampaniaPublicitaria(
                    "CMP02", "Coca-Cola", 200, LocalDate.parse("2025-02-15"));
            servicio.crearCampania(c2);
        } catch (PresupuestoInvalidoException e) {
            System.out.println("✗ Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // Caso 3: Registro exitoso
        try {
            CampaniaPublicitaria c3 = new CampaniaPublicitaria(
                    "CMP03", "Pepsi", 3000, LocalDate.parse("2025-02-15"));
            servicio.crearCampania(c3);
            System.out.println("✓ Campaña registrada correctamente.");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // Caso 4: Registro exitoso
        try {
            CampaniaPublicitaria c4 = new CampaniaPublicitaria(
                    "CMP04", "Adidas", 8000, LocalDate.parse("2025-03-20"));
            servicio.crearCampania(c4);
            System.out.println("✓ Campaña registrada exitosamente.");
        } catch (Exception e) {
            System.out.println("✗ Error: " + e.getMessage());
        }

        // Caso 5: Mostrar campañas
        System.out.println("\n Listado de campañas registradas:");
        for (CampaniaPublicitaria c : servicio.listarCampanias()) {
            System.out.println(c);
        }
    }
}