package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;	
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class LoadData {

	private Connection conn;

	public LoadData(Connection conn) {
	        this.conn = conn;
	    }

	public ObservableList<Employee> getAllEmployees() throws SQLException {
	        ObservableList<Employee> employeeData = FXCollections.observableArrayList();

	        String query = "SELECT * FROM employee_details";

	        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String middleName = resultSet.getString("middle_name");
	                int employeeId = resultSet.getInt("id");
	                String dateJoined = resultSet.getString("date_joined");
	                String department = resultSet.getString("department");
	                String street = resultSet.getString("street");
	                String city = resultSet.getString("city");
	                String state = resultSet.getString("state");
	                String postalCode = resultSet.getString("postal_code");
	                String email = resultSet.getString("email");
	                String phoneNum = resultSet.getString("phone_number");

	                Address address = new Address(street, city, state, postalCode);
	                Contact contact = new Contact(email, phoneNum);
	                Name name = new Name(firstName, middleName, lastName);
	                Profile profile = new Profile(address, contact, department, dateJoined);

	                Employee employee = new Employee(name, employeeId, profile);
	                employeeData.add(employee);
	            }
	        }

	        return employeeData;
	    }
	    
	public ObservableList<Employee> getAllAttendance() throws SQLException {
	        ObservableList<Employee> employeeData = FXCollections.observableArrayList();

	        String query = "SELECT first_name, last_name, middle_name, department, id, hours_worked " +
	                       "FROM employee_details  ";

	        try (PreparedStatement preparedStatement = conn.prepareStatement(query);
	             ResultSet resultSet = preparedStatement.executeQuery()) {

	            while (resultSet.next()) {
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String middleName = resultSet.getString("middle_name");
	                int employeeId = resultSet.getInt("id");
	                String department = resultSet.getString("department");
	                double hoursWorked = resultSet.getDouble("hours_worked");

	                
	                Name name = new Name(firstName, middleName, lastName);
	                Profile profile = new Profile(null, null, department, null); // Address and contact not retrieved in this query
	                Attendance attendance = new Attendance(hoursWorked); 
	                Employee employee = new Employee(name, employeeId, profile, attendance);

	                employeeData.add(employee);
	            }
	        }

	        return employeeData;
	    }
	    
	    
	public ObservableList<Employee> getAllLeaves() throws SQLException {
	        ObservableList<Employee> leaveData = FXCollections.observableArrayList();

	        String query = "SELECT * FROM leaves_list";

	        try (PreparedStatement statement = conn.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                String firstName = resultSet.getString("first_name");
	                String lastName = resultSet.getString("last_name");
	                String middleName = resultSet.getString("middle_name");
	                int employeeId = resultSet.getInt("id");
	                LocalDate startDate = resultSet.getDate("start_date").toLocalDate();
	                LocalDate endDate = resultSet.getDate("end_date").toLocalDate();
	                boolean approvalStatus = resultSet.getBoolean("approval_status");
	                int leaveEntitled = resultSet.getInt("leaves_entitled");

	                Name name = new Name(firstName, middleName, lastName);
	                Leave leave = new Leave(startDate, endDate, approvalStatus);
	                Leaves leaves = new Leaves(); // Assuming this is a collection of leaves, not directly related to this example

	                Employee employee = new Employee(name, employeeId, leaves, leaveEntitled);
	                employee.getLeaves().getLeavesList().add(leave); // Assuming you add the extracted leave to the employee's leaves
	                leaveData.add(employee);
	            }
	        }

	        return leaveData;
	    }
	
	
	public void updateEmployee(Employee updatedEmployee) throws SQLException {
	        String query = "UPDATE employee_details SET "
	                + "first_name = ?, "
	                + "last_name = ?, "
	                + "middle_name = ?, "
	                + "date_joined = ?, "
	                + "department = ?, "
	                + "street = ?, "
	                + "city = ?, "
	                + "state = ?, "
	                + "postal_code = ?, "
	                + "email = ?, "
	                + "phone_number = ? "
	                + "WHERE id = ?";

	        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	            preparedStatement.setString(1, updatedEmployee.getName().getFirstName());
	            preparedStatement.setString(2, updatedEmployee.getName().getLastName());
	            preparedStatement.setString(3, updatedEmployee.getName().getMiddleName());
	            preparedStatement.setString(4, updatedEmployee.getProfile().getDateJoined());
	            preparedStatement.setString(5, updatedEmployee.getProfile().getDepartment());
	            preparedStatement.setString(6, updatedEmployee.getProfile().getAddress().getStreet());
	            preparedStatement.setString(7, updatedEmployee.getProfile().getAddress().getCity());
	            preparedStatement.setString(8, updatedEmployee.getProfile().getAddress().getState());
	            preparedStatement.setString(9, updatedEmployee.getProfile().getAddress().getPostalCode());
	            preparedStatement.setString(10, updatedEmployee.getProfile().getContactInfo().getEmail());
	            preparedStatement.setString(11, updatedEmployee.getProfile().getContactInfo().getPhoneNum());
	            preparedStatement.setInt(12, updatedEmployee.getId());

	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected == 1) {
	                System.out.println("Employee with ID " + updatedEmployee.getId() + " updated successfully.");
	            } else {
	                System.out.println("Failed to update employee with ID " + updatedEmployee.getId());
	            }
	        }
	}
	    
	public void insertEmployee(Employee employee) throws SQLException {
	        String query = "INSERT INTO employee_details (first_name, last_name, middle_name, id, date_joined, department, " +
	                       "street, city, state, postal_code, email, phone_number, hours_worked) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        // Generate random hours worked between 30 and 45
	        int hoursWorked = ThreadLocalRandom.current().nextInt(25, 45);

	        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	            preparedStatement.setString(1, employee.getName().getFirstName());
	            preparedStatement.setString(2, employee.getName().getLastName());
	            preparedStatement.setString(3, employee.getName().getMiddleName());
	            preparedStatement.setInt(4, employee.getId());
	            preparedStatement.setString(5, employee.getProfile().getDateJoined());
	            preparedStatement.setString(6, employee.getProfile().getDepartment());
	            preparedStatement.setString(7, employee.getProfile().getAddress().getStreet());
	            preparedStatement.setString(8, employee.getProfile().getAddress().getCity());
	            preparedStatement.setString(9, employee.getProfile().getAddress().getState());
	            preparedStatement.setString(10, employee.getProfile().getAddress().getPostalCode());
	            preparedStatement.setString(11, employee.getProfile().getContactInfo().getEmail());
	            preparedStatement.setString(12, employee.getProfile().getContactInfo().getPhoneNum());
	            preparedStatement.setInt(13, hoursWorked);

	            preparedStatement.executeUpdate();
	        }
	    }


	public void deleteEmployee(int employeeId) throws SQLException {
	        String query = "DELETE FROM employee_details WHERE id = ?";

	        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
	            preparedStatement.setInt(1, employeeId);

	            int rowsAffected = preparedStatement.executeUpdate();
	            if (rowsAffected == 1) {
	                System.out.println("Employee with ID " + employeeId + " deleted successfully from database.");
	            } else {
	                System.out.println("Failed to delete employee with ID " + employeeId + " from database.");
	            }
	        }
	    }


}
