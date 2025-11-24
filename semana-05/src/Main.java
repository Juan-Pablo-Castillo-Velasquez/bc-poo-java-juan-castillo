public class Main {
    public static void main(String[] args) {

        CampaignManager manager = new CampaignManager();

        DigitalCampaign d1 = new DigitalCampaign(
                "DG01", "Coca-Cola", 5000, "Instagram", 20000, 0.08
        );

        TraditionalCampaign t1 = new TraditionalCampaign(
                "TR01", "Nike", 8000, "Televisión", 30, 0.12
        );

        manager.addCampaign(d1);
        manager.addCampaign(t1);

        System.out.println("\n=== CAMPAÑAS REGISTRADAS ===");
        manager.mostrarTodas();

        System.out.println("\n=== BUSCAR POR CÓDIGO ===");
        Campaign encontrada = manager.buscarCampaña("DG01");
        if (encontrada != null) encontrada.showInfo();

        System.out.println("\n=== BUSCAR POR PRESUPUESTO ===");
        System.out.println(manager.buscarCampaña(3000, 9000).size() + " encontradas");
    }
}
