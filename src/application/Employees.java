package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.util.ArrayList;
import java.util.List;

public class Employees {
    private List<Employee> employeeList;

    
    public Employees() {
        this.employeeList = new ArrayList<>();
    }

    
    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
        System.out.println("Employee added: " + employee.getId());
        System.out.println("Addition complete.");
    }

    
    public void removeEmployee(Employee employee) {
        this.employeeList.remove(employee);
        System.out.println("Employee removed: " + employee.getId());
        System.out.println("Removal complete.");
    }

    
    public void printEmployee() {
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println("Printing complete.");
    }
    
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    
    public Employee findEmployeeByID(int id) {
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employees List:\n");
        for (Employee employee : employeeList) {
            sb.append(employee.toString()).append("\n");
        }
        return sb.toString();
    }
}


