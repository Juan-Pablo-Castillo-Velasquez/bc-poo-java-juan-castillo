public class TraditionalCampaign extends Campaign {

    private String medium;
    private int durationDays;
    private double reachPercentage;

    // Constructor con super() llamando al constructor de la clase padre Campaign
    public TraditionalCampaign(String campaignCode, String clientName, double budget,
                               String medium, int durationDays) {
        super(campaignCode, clientName, budget);
        this.medium = medium;
        this.durationDays = durationDays;
        this.reachPercentage = 0.0;
    }

    // Metodo sobrescrito de la clase padre - Polimorfismo
    @Override
    protected double calculateCost() {
        return (super.getBudget() / durationDays) * durationDays;
    }

    // Metodo sobrescrito de la clase padre - Polimorfismo
    @Override
    public void showInfo() {
        super.showBaseInfo();
        System.out.println("Tipo: Campana Tradicional");
        System.out.println("Medio: " + medium);
        System.out.println("Duracion: " + durationDays + " dias");
        System.out.println("Alcance: " + reachPercentage + "%");
        System.out.println("Costo Diario: $" + (calculateCost() / durationDays));
        System.out.println("Costo Total: $" + calculateCost());
        System.out.println("-----------------------------------");
    }

    public void updateReach(double reach) {
        this.reachPercentage = reach;
        System.out.println("Alcance actualizado a: " + reach + "%");
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }

    public double getReachPercentage() {
        return reachPercentage;
    }

    public void setReachPercentage(double reachPercentage) {
        this.reachPercentage = reachPercentage;
    }
}
