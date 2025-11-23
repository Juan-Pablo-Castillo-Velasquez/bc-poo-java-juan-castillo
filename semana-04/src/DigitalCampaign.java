public class DigitalCampaign extends Campaign {

    private String platform;
    private int targetAudience;
    private double engagementRate;

    public DigitalCampaign(String campaignCode, String clientName, double budget,
                           String platform, int targetAudience) {
        super(campaignCode, clientName, budget);
        this.platform = platform;
        this.targetAudience = targetAudience;
        this.engagementRate = 0.0;
    }

    @Override
    protected double calculateCost() {
        return super.getBudget() + (targetAudience * 0.50);
    }

    @Override
    public void showInfo() {
        super.showBaseInfo();
        System.out.println("Tipo: Campana Digital");
        System.out.println("Plataforma: " + platform);
        System.out.println("Audiencia Objetivo: " + targetAudience + " personas");
        System.out.println("Tasa de Engagement: " + engagementRate + "%");
        System.out.println("Costo Total: $" + calculateCost());
        System.out.println("-----------------------------------");
    }

    public void simulateEngagement(double rate) {
        this.engagementRate = rate;
        System.out.println("Engagement actualizado a: " + rate + "%");
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(int targetAudience) {
        this.targetAudience = targetAudience;
    }

    public double getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }
}

