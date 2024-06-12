import java.time.LocalDate;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Main {
    public static void main(String[] args) {
    
        Address address = new Address("123 Main St", "City", "State", "12345");
        Contact contact = new Contact("email@example.com", "1234567890");
        Profile profile = new Profile("Engineering", "2023-01-01", contact, address);
        Name name = new Name("John", "M.", "Doe");
        
        Employees employees = new Employees();

        Employee employee1 = new Employee(name, 24000641, 30, profile);
        employees.addEmployee(employee1);
        LocalDate startDate = LocalDate.of(2024, 6, 12);
        LocalDate endDate = LocalDate.of(2024, 6, 20);
        Leave leave = new Leave(24000641, startDate, endDate, true);
        employee1.addLeave(leave);

        System.out.println( employees);
    }
}