package implementaciones;

import abstractas.Campaign;
import interfaces.Measurable;
import interfaces.Budgetable;
import interfaces.Reportable;

/**
 * Clase concreta para campañas digitales
 */
public class DigitalCampaign extends Campaign implements Measurable, Budgetable, Reportable {
    private int clicks;
    private int impressions;
    private double costPerClick;

    public DigitalCampaign(String code, String client, double budget,
                           int clicks, int impressions, double costPerClick) {
        super(code, client, budget);
        this.clicks = clicks;
        this.impressions = impressions;
        this.costPerClick = costPerClick;
    }

    @Override
    public double calculateROI() {
        double estimatedRevenue = clicks * 50; // $50 por conversión estimada
        return (estimatedRevenue - budget) / budget * 100;
    }

    @Override
    public String getCampaignType() {
        return "Campaña Digital";
    }

    @Override
    public double calculatePerformance() {
        double ctr = (double) clicks / impressions * 100;
        return ctr;
    }

    @Override
    public String getPerformanceReport() {
        return String.format("CTR: %.2f%%, Clicks: %d, Impresiones: %d",
                calculatePerformance(), clicks, impressions);
    }

    @Override
    public boolean isPerformanceGood() {
        return calculatePerformance() > 2.0; // CTR > 2% es bueno
    }

    @Override
    public void applyDiscount(double percentage) {
        double discount = budget * (percentage / 100);
        budget -= discount;
        System.out.println("Descuento aplicado: $" + discount);
    }

    @Override
    public boolean isWithinBudget() {
        double estimatedCost = clicks * costPerClick;
        return estimatedCost <= budget;
    }

    @Override
    public double getRemainingBudget(double spent) {
        return budget - spent;
    }

    @Override
    public String generateDetailedReport() {
        return String.format(
                "Reporte Digital - Cliente: %s\n" +
                        "ROI: %.2f%%\n" +
                        "Performance: %.2f%% CTR\n" +
                        "Presupuesto restante: $%.2f\n" +
                        "Dentro del presupuesto: %s",
                clientName, calculateROI(), calculatePerformance(),
                getRemainingBudget(clicks * costPerClick), isWithinBudget()
        );
    }

    @Override
    public void exportReport(String format) {
        System.out.println("Exportando reporte digital en formato: " + format);
        System.out.println(generateDetailedReport());
    }

    @Override
    public boolean needsApproval() {
        return budget > 10000000; // Más de 10M necesita aprobación
    }

    public int getClicks() { return clicks; }
    public int getImpressions() { return impressions; }
    public double getCostPerClick() { return costPerClick; }

    public void setClicks(int clicks) { this.clicks = clicks; }
    public void setImpressions(int impressions) { this.impressions = impressions; }
}