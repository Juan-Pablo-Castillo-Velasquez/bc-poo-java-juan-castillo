public class Employee {
    private String employeeId;
    private String name;
    private String role;
    private double salary;
    private boolean available;

    public Employee(String employeeId, String name, String role, double salary, boolean available) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.salary = salary;
        this.available = available;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public String getRole() { return role; }
    public double getSalary() { return salary; }
    public boolean isAvailable() { return available; }

    public void showInfo() {
        System.out.println("=== EMPLEADO ===");
        System.out.println("ID: " + getEmployeeId());
        System.out.println("Nombre: " + getName());
        System.out.println("Cargo: " + getRole());
        System.out.println("Salario: $" + getSalary());
        System.out.println("Disponible: " + (isAvailable() ? "Sí" : "No"));
    }
}
