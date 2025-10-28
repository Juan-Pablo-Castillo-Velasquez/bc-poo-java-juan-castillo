import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<AdCampaign> campaigns = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();

        clients.add(new Client("CL001", "TechCorp", "Tecnología", true));
        clients.add(new Client("CL002", "Fashion Boutique", "Moda", false));
        clients.add(new Client("CL003", "Gourmet Express", "Restaurantes", false));

        campaigns.add(new AdCampaign("CAMP-001", "TechCorp", 15000000, 30));
        campaigns.add(new AdCampaign("CAMP-002", "Fashion Boutique", 8000000, 20));
        campaigns.add(new AdCampaign("CAMP-003", "Gourmet Express", 5000000, 25));

        employees.add(new Employee("EMP-001", "Laura Gómez", "Diseñadora Gráfica", 3200000, true));
        employees.add(new Employee("EMP-002", "Carlos Ruiz", "Community Manager", 2800000, false));
        employees.add(new Employee("EMP-003", "María Pérez", "Publicista", 3500000, true));

        System.out.println("=== CLIENTES ===");
        for (Client c : clients) c.showInfo();

        System.out.println("\n=== CAMPAÑAS ===");
        for (AdCampaign a : campaigns) {
            a.showInfo();
            System.out.println("Costo diario: $" + a.calculateDailyCost());
            System.out.println();
        }

        System.out.println("=== EMPLEADOS ===");
        for (Employee e : employees) e.showInfo();
    }
}
