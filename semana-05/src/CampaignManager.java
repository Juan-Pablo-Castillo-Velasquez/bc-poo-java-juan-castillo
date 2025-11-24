import java.util.ArrayList;

public class CampaignManager {

    private ArrayList<Campaign> campaigns = new ArrayList<>();

    public void addCampaign(Campaign c) {
        campaigns.add(c);
    }


    public Campaign buscarCampaña(String codigo) {
        for (Campaign c : campaigns) {
            if (c.campaignCode.equals(codigo)) return c;
        }
        return null;
    }

    public ArrayList<Campaign> buscarCampaña(String cliente, double minimo) {
        ArrayList<Campaign> lista = new ArrayList<>();
        for (Campaign c : campaigns) {
            if (c.clientName.equals(cliente) && c.budget >= minimo) {
                lista.add(c);
            }
        }
        return lista;
    }

    public ArrayList<Campaign> buscarCampaña(double min, double max) {
        ArrayList<Campaign> lista = new ArrayList<>();
        for (Campaign c : campaigns) {
            if (c.budget >= min && c.budget <= max) {
                lista.add(c);
            }
        }
        return lista;
    }

    public void mostrarTodas() {
        for (Campaign c : campaigns) {
            c.showInfo(); // método sobrescrito
        }
    }
}
