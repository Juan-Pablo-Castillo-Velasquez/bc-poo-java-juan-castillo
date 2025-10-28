public class Client {
    private String clientId;
    private String name;
    private String industry;
    private boolean premium;
    private int campaignsCount;

    public Client(String clientId, String name, String industry, boolean premium) {
        this.clientId = clientId;
        this.name = name;
        this.industry = industry;
        this.premium = premium;
        this.campaignsCount = 0;
    }
    public boolean getPremium() {
        return premium;
    }

    public String getName() {
        return name;
    }

    public String getClientId() {
        return clientId;
    }

    public int getCampaignsCount() {
        return campaignsCount;
    }

    public String getIndustry() {
        return industry;
    }

    public void showInfo() {
        System.out.println("=== CLIENTE ===");
        System.out.println("ID: " + getClientId());
        System.out.println("Nombre: " + getName());
        System.out.println("Industria: " + getIndustry());
        System.out.println("Tipo: " + (getPremium() ? "PREMIUM" : "ESTÁNDAR"));
        System.out.println("Campañas activas: " + getCampaignsCount());
    }

    public void addCampaign() {
        campaignsCount++;
    }

    public boolean isPremium() {
        return premium;
    }
}
