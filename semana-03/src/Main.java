public class Main {

    public static void main(String[] args) {

        AdCampaign camp = new AdCampaign("CAMP-001", "TechCorp", 15000000);
        Client client = new Client("TechCorp", "Tecnología", "contacto@techcorp.co");
        Designer designer = new Designer("Laura Gómez", "Branding", 5);
        SocialMediaPost post = new SocialMediaPost("POST-1001", "Instagram", "Lanzamiento de nuevo producto");

        camp.showInfo();
        client.showInfo();
        designer.showInfo();
        post.showInfo();
    }
}
