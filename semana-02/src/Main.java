import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<AdCampaign> campaigns = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {


        Client[] cliente = {new Client("CL001", "TechCorp", "Tecnología", true),
                new Client("CL002", "Fashion Boutique", "Moda", false),
                new Client("CL003", "Gourmet Express", "Restaurantes", false)
        };

        AdCampaign[] campaignsData = {new AdCampaign("CAMP-001", "TechCorp", 15000000, 30),
                new AdCampaign("CAMP-002", "Fashion Boutique", 8000000, 20),
                new AdCampaign("CAMP-003", "Gourmet Express", 5000000, 25)
        };
        Employee[] EmployesData = {
                new Employee("EMP-001", "juan pablo", "Diseñadora Gráfica", 3200000, true),
                new Employee("EMP-002", "fernando Ruiz", "Community Manager", 2800000, false),
                new Employee("EMP-003", "jhon Pérez", "Publicista", 3500000, true)

        };


        for (Client cl : cliente) {
            clients.add(cl);//add new clientts to List 
        }

        for (AdCampaign addCampaign : campaignsData) {
            campaigns.add(addCampaign);//add new campaingns to List
        }

        for (Employee addEmployes : EmployesData) {
            employees.add(addEmployes);//add new employees to List
        }
        Scanner reader = new Scanner(System.in);

        try {
            System.out.println("===== Insert your option into  the menu =====");
            System.out.println("1. View clients");
            System.out.println("2. View campaigns");
            System.out.println("3. View employees");
            System.out.print("Please enter your choice: ");

            int options = reader.nextInt();
            ValidateOption(options);

        } catch (Exception e) {
            System.out.println(" you must enter a numeric value");
        } finally {
            reader.close();
        }
    }

    public static boolean ValidateOption(Integer options) {
        try {

            switch (options) {
                case 1:
                    System.out.println("your choice is " + options);
                    for (Client ShowClient : clients) {
                        ShowClient.addCampaign();
                        ShowClient.showInfo();

                    }
                    break;

                case 2:
                    System.out.println("your choice is " + options);
                    for (Employee ShoWEmployees : employees) {
                        ShoWEmployees.showInfo(); //this section can show you  information about employees
                    }
                    break;

                case 3:
                    System.out.println("your choice is " + options);
                    for (AdCampaign ShowCampaigns : campaigns) {
                        ShowCampaigns.showInfo(); // here  you can put showinfo about campaings and daily cost
                        System.out.println("daily cots: " + ShowCampaigns.calculateDailyCost() + "$");
                    }
                    break;

                default:
                    System.out.println("invalidated options ");
                    break;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Error: you must enter a numeric value.");
            return false;
        }

    }
}
