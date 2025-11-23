public class Designer {

    private String name;
    private String specialization;
    private int yearsExperience;

    public Designer(String name, String specialization, int yearsExperience) {
        this.name = name;
        this.specialization = specialization;
        this.yearsExperience = yearsExperience;
    }

    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getYearsExperience() { return yearsExperience; }

    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setYearsExperience(int yearsExperience) { this.yearsExperience = yearsExperience; }

    public void showInfo() {
        System.out.println("Diseñador: " + name);
        System.out.println("Especialidad: " + specialization);
        System.out.println("Experiencia: " + yearsExperience + " años");
        System.out.println("-----------------------------------");
    }
}
