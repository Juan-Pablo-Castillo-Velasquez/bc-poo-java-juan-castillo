package com.CreatividadDigital.App;

import com.CreatividadDigital.abstractas.Campaign;
import com.CreatividadDigital.implementaciones.DigitalCampaign;
import com.CreatividadDigital.implementaciones.TraditionalCampaign;
import com.CreatividadDigital.interfaces.Measurable;
import com.CreatividadDigital.interfaces.Budgetable;
import com.CreatividadDigital.interfaces.Reportable;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== AGENCIA CREATIVA DIGITAL - SISTEMA DE CAMPAÑAS ===\n");

        System.out.println("--- Sección 1: Polimorfismo con Campaign ---");

        Campaign[] campaigns = new Campaign[4];
        campaigns[0] = new DigitalCampaign("DIG-001", "TechCorp", 15000000,
                50000, 1000000, 150.0);
        campaigns[1] = new TraditionalCampaign("TRAD-001", "FashionBoutique", 8000000,
                500000, "TV", 30);
        campaigns[2] = new DigitalCampaign("DIG-002", "RestauranteGourmet", 5000000,
                20000, 400000, 120.0);
        campaigns[3] = new TraditionalCampaign("TRAD-002", "UniversidadDigital", 12000000,
                800000, "Prensa", 60);

        for (Campaign campaign : campaigns) {
            campaign.showInfo();
            System.out.printf("ROI: %.2f%%\n", campaign.calculateROI());
            System.out.println("----------------------------");
        }

        // 2. Demostrar uso de interfaces
        System.out.println("\n--- Sección 2: Uso de Interfaces ---");

        Measurable digitalMeasurable = (Measurable) campaigns[0];
        System.out.println("Performance Digital: " + digitalMeasurable.getPerformanceReport());
        System.out.println("¿Performance buena?: " + digitalMeasurable.isPerformanceGood());

        Measurable traditionalMeasurable = (Measurable) campaigns[1];
        System.out.println("Performance Tradicional: " + traditionalMeasurable.getPerformanceReport());
        System.out.println("¿Performance buena?: " + traditionalMeasurable.isPerformanceGood());

        System.out.println("\n--- Sección 3: Múltiple Implementación ---");

        DigitalCampaign digital = (DigitalCampaign) campaigns[0];
        TraditionalCampaign traditional = (TraditionalCampaign) campaigns[1];

        System.out.println("\n--- Gestión de Presupuesto ---");
        Budgetable budgetableDigital = digital;
        System.out.println("¿Dentro del presupuesto?: " + budgetableDigital.isWithinBudget());
        budgetableDigital.applyDiscount(10.0);

        Budgetable budgetableTraditional = traditional;
        System.out.println("¿Dentro del presupuesto?: " + budgetableTraditional.isWithinBudget());

        System.out.println("\n--- Generación de Reportes ---");
        Reportable reportableDigital = digital;
        reportableDigital.exportReport("PDF");
        System.out.println("¿Necesita aprobación?: " + reportableDigital.needsApproval());

        Reportable reportableTraditional = traditional;
        reportableTraditional.exportReport("Excel");
        System.out.println("¿Necesita aprobación?: " + reportableTraditional.needsApproval());

        System.out.println("\n--- Sección 4: Polimorfismo Avanzado ---");

        processCampaign(digital);
        processCampaign(traditional);

        System.out.println("\n=== FIN DEL REPORTE ===");
    }

    public static void processCampaign(Campaign campaign) {
        System.out.println("\nProcesando: " + campaign.getCampaignType());
        System.out.println("Cliente: " + campaign.getClientName());

        if (campaign instanceof Measurable) {
            Measurable measurable = (Measurable) campaign;
            System.out.println("Métrica: " + measurable.calculatePerformance());
        }

        if (campaign instanceof Reportable) {
            Reportable reportable = (Reportable) campaign;
            System.out.println("¿Aprobación requerida?: " + reportable.needsApproval());
        }
    }
}