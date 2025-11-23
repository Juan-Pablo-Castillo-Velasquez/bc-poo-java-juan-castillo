public class AdCampaign {

    private String campaignCode;
    private String clientName;
    private double budget;

    public AdCampaign(String campaignCode, String clientName, double budget) {
        this.campaignCode = campaignCode;
        this.clientName = clientName;
        this.budget = budget;
    }

    public String getCampaignCode() { return campaignCode; }
    public String getClientName() { return clientName; }
    public double getBudget() { return budget; }

    public void setCampaignCode(String campaignCode) { this.campaignCode = campaignCode; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setBudget(double budget) { this.budget = budget; }

    public void showInfo() {
        System.out.println("Campaña No.: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
        System.out.println("-----------------------------------");
    }
}
