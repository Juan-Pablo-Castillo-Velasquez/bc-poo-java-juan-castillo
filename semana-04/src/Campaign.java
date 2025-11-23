public class Campaign {

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

    protected double calculateCost() {
        return budget;
    }

    protected void showBaseInfo() {
        System.out.println("Codigo: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
        System.out.println("Estado: " + status);
    }

    public void showInfo() {
        showBaseInfo();
    }

    public String getCampaignCode() {
        return campaignCode;
    }

    public void setCampaignCode(String campaignCode) {
        this.campaignCode = campaignCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}