public class Client {

    private String clientName;
    private String industry;
    private String contactEmail;

    public Client(String clientName, String industry, String contactEmail) {
        this.clientName = clientName;
        this.industry = industry;
        this.contactEmail = contactEmail;
    }

    public String getClientName() { return clientName; }
    public String getIndustry() { return industry; }
    public String getContactEmail() { return contactEmail; }

    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setIndustry(String industry) { this.industry = industry; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }

    public void showInfo() {
        System.out.println("Cliente: " + clientName);
        System.out.println("Industria: " + industry);
        System.out.println("Correo: " + contactEmail);
        System.out.println("-----------------------------------");
    }
}
