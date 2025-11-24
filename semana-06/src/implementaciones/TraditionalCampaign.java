package implementaciones;

import abstractas.Campaign;
import interfaces.Measurable;
import interfaces.Budgetable;
import interfaces.Reportable;

/**
 * Clase concreta para campañas tradicionales
 */
public class TraditionalCampaign extends Campaign implements Measurable, Budgetable, Reportable {
    private int impressions;
    private String mediaType; // TV, Radio, Prensa, Vallas
    private int durationDays;

    public TraditionalCampaign(String code, String client, double budget,
                               int impressions, String mediaType, int durationDays) {
        super(code, client, budget);
        this.impressions = impressions;
        this.mediaType = mediaType;
        this.durationDays = durationDays;
    }

    // Implementación método abstracto de Campaign
    @Override
    public double calculateROI() {
        double estimatedRevenue = impressions * 0.02; // $0.02 por impresión estimada
        return (estimatedRevenue - budget) / budget * 100;
    }

    @Override
    public String getCampaignType() {
        return "Campaña Tradicional - " + mediaType;
    }

    // Implementación de Measurable
    @Override
    public double calculatePerformance() {
        double costPerThousand = (budget / impressions) * 1000;
        return costPerThousand;
    }

    @Override
    public String getPerformanceReport() {
        return String.format("CPM: $%.2f, Impresiones: %d, Duración: %d días",
                calculatePerformance(), impressions, durationDays);
    }

    @Override
    public boolean isPerformanceGood() {
        return calculatePerformance() < 50.0; // CPM < $50 es bueno
    }

    // Implementación de Budgetable
    @Override
    public void applyDiscount(double percentage) {
        double discount = budget * (percentage / 100);
        budget -= discount;
        System.out.println("Descuento aplicado a campaña tradicional: $" + discount);
    }

    @Override
    public boolean isWithinBudget() {
        double estimatedCost = impressions * (budget / impressions);
        return estimatedCost <= budget * 1.1; // 10% de tolerancia
    }

    @Override
    public double getRemainingBudget(double spent) {
        return budget - spent;
    }

    // Implementación de Reportable
    @Override
    public String generateDetailedReport() {
        return String.format(
                "Reporte Tradicional - Cliente: %s\n" +
                        "ROI: %.2f%%\n" +
                        "Medio: %s\n" +
                        "CPM: $%.2f\n" +
                        "Duración: %d días\n" +
                        "Performance: %s",
                clientName, calculateROI(), mediaType, calculatePerformance(),
                durationDays, isPerformanceGood() ? "Buena" : "Regular"
        );
    }

    @Override
    public void exportReport(String format) {
        System.out.println("Exportando reporte tradicional en formato: " + format);
        System.out.println(generateDetailedReport());
    }

    @Override
    public boolean needsApproval() {
        return budget > 5000000; // Más de 5M necesita aprobación
    }

    // Métodos específicos de TraditionalCampaign
    public int getImpressions() { return impressions; }
    public String getMediaType() { return mediaType; }
    public int getDurationDays() { return durationDays; }

    public void setImpressions(int impressions) { this.impressions = impressions; }
    public void setMediaType(String mediaType) { this.mediaType = mediaType; }
}