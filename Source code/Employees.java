
import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList;

    // Default constructor
    public Employees() {
        this.employeeList = new ArrayList<>();
    }

    // Method to add an employee to the list
    public void add(Employee employee) {
        this.employeeList.add(employee);
        System.out.println("Employee added: " + employee.getId());
        System.out.println("Addition complete.");
    }

    // Method to remove an employee from the list
    public void remove(Employee employee) {
        this.employeeList.remove(employee);
        System.out.println("Employee removed: " + employee.getId());
        System.out.println("Removal complete.");
    }

    // Method to print all employees in the list
    public void print() {
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println("Printing complete.");
    }

    // Method to find an employee by ID
    public Employee findEmployeeByID(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null; // Return null if employee not found
    }
}


