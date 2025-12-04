package com.CreatividadDigital.App;

import com.CreatividadDigital.domain.Campaign;
import com.CreatividadDigital.domain.DigitalCampaign;
import com.CreatividadDigital.domain.TraditionalCampaign;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("====== CAMPANAS PUBLICITARIAS ======\n");

        ArrayList<Campaign> campaigns = new ArrayList<Campaign>();

        campaigns.add(new DigitalCampaign(
                "DCAMP-001",
                "TechCorp",
                5000000,
                "Instagram",
                50000
        ));

        campaigns.add(new TraditionalCampaign(
                "TCAMP-001",
                "GlobalBrand",
                3000000,
                "Television",
                30
        ));

        campaigns.add(new DigitalCampaign(
                "DCAMP-002",
                "FashionCo",
                2500000,
                "Facebook",
                75000
        ));

        campaigns.add(new TraditionalCampaign(
                "TCAMP-002",
                "AutomotiveCorp",
                4000000,
                "Radio",
                45
        ));

        campaigns.add(new DigitalCampaign(
                "DCAMP-003",
                "EcommercePro",
                1800000,
                "TikTok",
                100000
        ));

        System.out.println("--- Listado de Campanas ---\n");
        for (Campaign campaign : campaigns) {
            campaign.showInfo();
        }

        // Calcular presupuesto total usando polimorfismo
        double totalBudget = calculateTotalBudget(campaigns);
        System.out.println("Presupuesto Total de Campanas: $" + totalBudget);

        // Cantidad de campanas
        System.out.println("Total de Campanas: " + campaigns.size());

        // Ejemplos de metodos especificos de subclases
        System.out.println("\n====== ACTUALIZACIONES ======\n");

        DigitalCampaign digitalCampaign = (DigitalCampaign) campaigns.get(0);
        digitalCampaign.simulateEngagement(8.5);

        TraditionalCampaign traditionalCampaign = (TraditionalCampaign) campaigns.get(1);
        traditionalCampaign.updateReach(65.0);

        System.out.println("\n====== DEMOSTRACION DE HERENCIA ======\n");

        System.out.println("Acceso a atributos protegidos de Campaign desde subclases:");
        System.out.println("Campana 0 - Codigo: " + campaigns.get(0).getCampaignCode());
        System.out.println("Campana 0 - Cliente: " + campaigns.get(0).getClientName());
        System.out.println("Campana 0 - Presupuesto: " + campaigns.get(0).getBudget());
        System.out.println("Campana 0 - Estado: " + campaigns.get(0).getStatus());

        System.out.println("\n====== LISTAR CAMPANAS POR TIPO ======\n");

        listarCampanasPorTipo(campaigns);

        System.out.println("\n====== REMOVER CAMPANA ======\n");

        if (campaigns.size() > 0) {
            Campaign removida = campaigns.remove(2);
            System.out.println("Campana removida: " + removida.getCampaignCode());
            System.out.println("Total de campanas ahora: " + campaigns.size());
        }

        System.out.println("\n====== AGREGAR NUEVA CAMPANA ======\n");

        campaigns.add(new DigitalCampaign(
                "DCAMP-004",
                "StartupTech",
                1500000,
                "LinkedIn",
                25000
        ));

        System.out.println("Nueva campana agregada");
        System.out.println("Total de campanas ahora: " + campaigns.size());
    }

    public static double calculateTotalBudget(ArrayList<Campaign> campaigns) {
        double total = 0;
        for (Campaign campaign : campaigns) {
            total += campaign.calculateCost();
        }
        return total;
    }

    public static void listarCampanasPorTipo(ArrayList<Campaign> campaigns) {
        int digitalCount = 0;
        int traditionalCount = 0;

        for (Campaign campaign : campaigns) {
            if (campaign instanceof DigitalCampaign) {
                digitalCount++;
            } else if (campaign instanceof TraditionalCampaign) {
                traditionalCount++;
            }
        }

        System.out.println("Campanas Digitales: " + digitalCount);
        System.out.println("Campanas Tradicionales: " + traditionalCount);
    }
}