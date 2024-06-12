import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create Address
        Address address = new Address("123 Main St", "City", "State", "12345");
        System.out.println("Address: " + address);

        // Create Contact
        Contact contact = new Contact("email@example.com", "1234567890");
        System.out.println("Contact: " + contact);

        // Testing the Employee
        Profile profile = new Profile("Engineering", "2023-01-01", contact, address);
        System.out.println("Profile: " + profile);

        // Testing the Name Class
        Name name = new Name("John", "M.", "Doe");
        System.out.println("Name: " + name);

        // Testing the Employee Class
        Employee employee = new Employee(name, 1, 30, profile);
        System.out.println("Employee: " + employee);

        // Testing the Leave Class
       LocalDate startDate = LocalDate.of(2024, 6, 12);
        LocalDate endDate = LocalDate.of(2024, 6, 20);
        Leave leave = new Leave(1, startDate, endDate, true);
        System.out.println("Leave: " + leave);
    }
}