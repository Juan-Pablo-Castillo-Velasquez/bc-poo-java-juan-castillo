package com.CreatividadDigital.domain;

public class TraditionalCampaign extends Campaign {

    private String medium;
    private int durationDays;
    private double reachPercentage;

    public TraditionalCampaign(
            String campaignCode,
            String clientName,
            double budget,
            String medium,
            int durationDays,
            double reachPercentage
    ) {
        super(campaignCode, clientName, budget);
        this.medium = medium;
        this.durationDays = durationDays;
        this.reachPercentage = reachPercentage;
    }

    @Override
    protected double calculateCost() {
        return budget * (0.15 + reachPercentage);
    }

    @Override
    public void showInfo() {
        System.out.println("📺 Traditional Campaign:");
        super.showBaseInfo();
        System.out.println("Medio: " + medium);
        System.out.println("Duración: " + durationDays + " días");
        System.out.println("Alcance: " + (reachPercentage * 100) + "%");
        System.out.println("Costo estimado: $" + calculateCost());
        System.out.println("-----------------------------------");
    }
}
