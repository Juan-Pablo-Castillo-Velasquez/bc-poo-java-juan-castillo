package com.CreatividadDigital.domain;

public class DigitalCampaign extends Campaign {

    private String platform;
    private int targetAudience;
    private double engagementRate;

    public DigitalCampaign(
            String campaignCode,
            String clientName,
            double budget,
            String platform,
            int targetAudience,
            double engagementRate
    ) {
        super(campaignCode, clientName, budget);
        this.platform = platform;
        this.targetAudience = targetAudience;
        this.engagementRate = engagementRate;
    }

    @Override
    protected double calculateCost() {
        return budget * (0.12 + engagementRate);
    }

    @Override
    public void showInfo() {
        System.out.println("📱 Digital Campaign:");
        super.showBaseInfo();
        System.out.println("Plataforma: " + platform);
        System.out.println("Audiencia: " + targetAudience);
        System.out.println("Engagement: " + engagementRate);
        System.out.println("Costo estimado: $" + calculateCost());
        System.out.println("-----------------------------------");
    }
}
