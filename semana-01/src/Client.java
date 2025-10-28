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
        System.out.println("ID: " + clientId);
        System.out.println("Nombre: " + name);
        System.out.println("Industria: " + industry);
        System.out.println("Tipo: " + (premium ? "PREMIUM" : "ESTÁNDAR"));
        System.out.println("Campañas activas: " + campaignsCount);
    }

    public void addCampaign() {
        campaignsCount++;
    }

    public boolean isPremium() {
        return premium;
    }
}
