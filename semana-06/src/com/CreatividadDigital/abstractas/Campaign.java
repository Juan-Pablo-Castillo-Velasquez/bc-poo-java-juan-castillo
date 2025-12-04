package com.CreatividadDigital.abstractas;

/**
 * Clase abstracta que representa una campaña publicitaria genérica
 * en la agencia Creativa Digital
 */
public abstract class Campaign {
    protected String campaignCode;
    protected String clientName;
    protected double budget;
    protected String status;

    public Campaign(String campaignCode, String clientName, double budget) {
        this.campaignCode = campaignCode;
        this.clientName = clientName;
        this.budget = budget;
        this.status = "Activa";
    }

    public abstract double calculateROI();
    public abstract String getCampaignType();

    public void showInfo() {
        System.out.println("=== Información de Campaña ===");
        System.out.println("Código: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
        System.out.println("Estado: " + status);
        System.out.println("Tipo: " + getCampaignType());
    }

    public void updateBudget(double newBudget) {
        this.budget = newBudget;
        System.out.println("Presupuesto actualizado: $" + newBudget);
    }

    public String getCampaignCode() { return campaignCode; }
    public String getClientName() { return clientName; }
    public double getBudget() { return budget; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}