
public class Campaign {

    protected String campaignCode;
    protected String clientName;
    protected double budget;
    protected String status;

    public Campaign(String campaignCode, String clientName, double budget) {
        this.campaignCode = campaignCode;
        this.clientName = clientName;
        this.budget = budget;
        this.status = "ACTIVA";
    }

    protected double calculateCost() {
        return budget * 0.10; // costo base 10%
    }

    protected void showBaseInfo() {
        System.out.println("Código: " + campaignCode);
        System.out.println("Cliente: " + clientName);
        System.out.println("Presupuesto: $" + budget);
        System.out.println("Estado: " + status);
    }

    public void showInfo() {
        showBaseInfo();
        System.out.println("Costo estimado: " + calculateCost());
    }
}
