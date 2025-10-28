public class Main {
    Client Cliente;

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTIÓN - CREATIVA DIGITAL ===\n");

        Client c1 = new Client("CL001", "TechCorp", "Tecnología", true);
        Client c2 = new Client("CL002", "Fashion Boutique", "Moda", false);
        Client c3 = new Client("CL003", "Gourmet Express", "Restaurantes", false);
        Client c4 = new Client("CL004", "FitLife Gym", "Salud y Fitness", true);
        Client c5 = new Client("CL005", "Universidad Digital", "Educación", true);

        System.out.println("--- CLIENTES REGISTRADOS ---");
        c1.showInfo();
        c2.showInfo();
        c3.showInfo();
        c4.showInfo();
        c5.showInfo();

        System.out.println("\n--- CAMPAÑAS PUBLICITARIAS ---");
        AdCampaign camp1 = new AdCampaign("CAMP-001", c1.getName(), 15000000, 30);
        AdCampaign camp2 = new AdCampaign("CAMP-002", c2.getName(), 8000000, 20);
        AdCampaign camp3 = new AdCampaign("CAMP-003", c3.getName(), 5000000, 25);
        AdCampaign camp4 = new AdCampaign("CAMP-004", c4.getName(), 10000000, 40);
        AdCampaign camp5 = new AdCampaign("CAMP-005", c5.getName(), 20000000, 60);

        camp1.showInfo();
        System.out.println("Costo diario: $" + camp1.calculateDailyCost());

        camp2.showInfo();
        System.out.println("Costo diario: $" + camp2.calculateDailyCost());

        camp3.showInfo();
        System.out.println("Costo diario: $" + camp3.calculateDailyCost());

        camp4.showInfo();
        System.out.println("Costo diario: $" + camp4.calculateDailyCost());

        camp5.showInfo();
        System.out.println("Costo diario: $" + camp5.calculateDailyCost());

        camp3.setActive(false);
        System.out.println("\n--- CAMPAÑA DESACTIVADA ---");
        camp3.showInfo();
    }
}
