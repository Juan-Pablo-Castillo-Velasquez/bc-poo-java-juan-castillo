public class AdCampaign {
    private String campaignCode;
    private String clientName;
    private double budget;
    private boolean active;
    private int durationDays;

    public AdCampaign(String campaignCode, String clientName, double budget, int durationDays) {
        this.campaignCode = campaignCode;
        this.clientName = clientName;
        this.budget = budget;
        this.durationDays = durationDays;
        this.active = true;
    }
    public boolean getActive() {
        return active;
    }

    public double getBudget() {
        return budget;
    }

    public String getCampaignCode() {
        return campaignCode;
    }


    public int getDurationDays() {
        return durationDays;
    }

    public String getClientName() {
        return clientName;
    }

    public void showInfo() {
        System.out.println("=== CAMPAÑA PUBLICITARIA ===");
        System.out.println("Código: " + getCampaignCode());
        System.out.println("Cliente: " + getClientName());
        System.out.println("Presupuesto: $" + getBudget());
        System.out.println("Duración: " + getDurationDays() + " días");
        System.out.println("Estado: " + (getActive() ? "ACTIVA" : "INACTIVA"));
    }

    public double calculateDailyCost() {
        return getBudget() / getDurationDays();
    }


    public void setActive(boolean active) {
        this.active = active;
    }
}
