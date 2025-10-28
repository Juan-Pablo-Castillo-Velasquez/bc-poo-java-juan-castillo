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

    public void showInfo() {
        System.out.println("=== CAMPAÑA PUBLICITARIA ===");
        System.out.println("Código: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
        System.out.println("Duración: " + durationDays + " días");
        System.out.println("Estado: " + (active ? "ACTIVA" : "INACTIVA"));
    }

    public double calculateDailyCost() {
        return budget / durationDays;
    }

    public String getClientName() {
        return clientName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
