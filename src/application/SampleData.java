package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleData {

    // Employee 1
    private static final Name name1 = new Name("John", "Doe", "Okay");
    private static final int employee1id = 12323;
    private static final Address address1 = new Address("123 Main St", "Anytown", "Ontario", "12345");
    private static final Contact contactInfo1 = new Contact("john.doe@example.com", "123-456-7890");
    private static final Profile profile1 = new Profile(address1, contactInfo1, "IT", "2023-01-01");
    private static final Attendance attendance1 = new Attendance(21);
    private static final Leave leave1 = new Leave(LocalDate.now().minusDays(5), LocalDate.now(), true);
    private static final Leaves leaves1 = new Leaves();
    static {
        leaves1.addLeave(leave1);
    }

    // Employee 2
    private static final Name name2 = new Name("Jane", "Smith", "Wuzz");
    private static final int employee2id = 22323;
    private static final Address address2 = new Address("456 Elm St", "Othertown", "Sarawak", "54321");
    private static final Contact contactInfo2 = new Contact("jane.smith@example.com", "987-654-3210");
    private static final Profile profile2 = new Profile(address2, contactInfo2, "HR", "2023-02-01");
    private static final Attendance attendance2 = new Attendance(67);
    private static final Leave leave2 = new Leave(LocalDate.now().minusDays(3), LocalDate.now().plusDays(2), false);
    private static final Leaves leaves2 = new Leaves();
    static {
        leaves2.addLeave(leave2);
    }

    // Employee 3
    private static final Name name3 = new Name("Alice", "Johnson", "Bee");
    private static final int employee3id = 32323;
    private static final Address address3 = new Address("789 Oak St", "Anothertown", "Jupiter", "67890");
    private static final Contact contactInfo3 = new Contact("alice.johnson@example.com", "456-789-0123");
    private static final Profile profile3 = new Profile(address3, contactInfo3, "Finance", "2023-03-01");
    private static final Attendance attendance3 = new Attendance(40);
    private static final Leave leave3 = new Leave(LocalDate.now().minusDays(2), LocalDate.now().plusDays(3), false);
    private static final Leaves leaves3 = new Leaves();
    static {
        leaves3.addLeave(leave3);
    }

    // Employee 4
    private static final Name name4 = new Name("Bob", "Brown", "Jay");
    private static final int employee4id = 42323;
    private static final Address address4 = new Address("321 Pine St", "Somewhere", "Alberta", "13579");
    private static final Contact contactInfo4 = new Contact("bob.brown@example.com", "789-012-3456");
    private static final Profile profile4 = new Profile(address4, contactInfo4, "Operations", "2023-04-01");
    private static final Attendance attendance4 = new Attendance(50);
    private static final Leave leave4 = new Leave(LocalDate.now().plusDays(1), LocalDate.now().plusDays(6), false);
    private static final Leaves leaves4 = new Leaves();
    static {
        leaves4.addLeave(leave4);
    }

    // Employee 5
    private static final Name name5 = new Name("Charlie", "Davis", "Kay");
    private static final int employee5id = 52323;
    private static final Address address5 = new Address("654 Cedar St", "Nowhere", "Ye", "24680");
    private static final Contact contactInfo5 = new Contact("charlie.davis@example.com", "321-654-9870");
    private static final Profile profile5 = new Profile(address5, contactInfo5, "IT", "2023-05-01");
    private static final Attendance attendance5 = new Attendance(30);
    private static final Leave leave5 = new Leave(LocalDate.now().minusDays(1), LocalDate.now().plusDays(4), true);
    private static final Leaves leaves5 = new Leaves();
    static {
        leaves5.addLeave(leave5);
    }

    // Employee 6
    private static final Name name6 = new Name("Eve", "White", "Lee");
    private static final int employee6id = 62323;
    private static final Address address6 = new Address("987 Maple St", "Elsewhere", "KL", "97531");
    private static final Contact contactInfo6 = new Contact("eve.white@example.com", "654-987-3210");
    private static final Profile profile6 = new Profile(address6, contactInfo6, "HR", "2023-06-01");
    private static final Attendance attendance6 = new Attendance(40);
    private static final Leave leave6 = new Leave(LocalDate.now().plusDays(2), LocalDate.now().plusDays(7), true);
    private static final Leaves leaves6 = new Leaves();
    static {
        leaves6.addLeave(leave6);
    }

    // Employee 7
    private static final Name name7 = new Name("Frank", "Black", "Moe");
    private static final int employee7id = 72323;
    private static final Address address7 = new Address("741 Birch St", "Anywhere", "Utopia", "86420");
    private static final Contact contactInfo7 = new Contact("frank.black@example.com", "987-321-6540");
    private static final Profile profile7 = new Profile(address7, contactInfo7, "Finance", "2023-07-01");
    private static final Attendance attendance7 = new Attendance(30);
    private static final Leave leave7 = new Leave(LocalDate.now().minusDays(3), LocalDate.now().plusDays(2), true);
    private static final Leaves leaves7 = new Leaves();
    static {
        leaves7.addLeave(leave7);
    }
    
    
    

    public static ObservableList<Employee> createSampleEmployees() {
        ObservableList<Employee> employeeData = FXCollections.observableArrayList();

        Employee employee1 = new Employee(name1, employee1id, profile1);
        Employee employee2 = new Employee(name2, employee2id, profile2);
        Employee employee3 = new Employee(name3, employee3id, profile3);
        Employee employee4 = new Employee(name4, employee4id, profile4);
        Employee employee5 = new Employee(name5, employee5id, profile5);
        Employee employee6 = new Employee(name6, employee6id, profile6);
        Employee employee7 = new Employee(name7, employee7id, profile7);

        employeeData.addAll(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        return employeeData;
    }

    public static ObservableList<Employee> createSampleAttendance() {
        ObservableList<Employee> attendanceData = FXCollections.observableArrayList();

        Employee employee1 = new Employee(name1, employee1id, profile1, attendance1);
        Employee employee2 = new Employee(name2, employee2id, profile2, attendance2);
        Employee employee3 = new Employee(name3, employee3id, profile3, attendance3);
        Employee employee4 = new Employee(name4, employee4id, profile4, attendance4);
        Employee employee5 = new Employee(name5, employee5id, profile5, attendance5);
        Employee employee6 = new Employee(name6, employee6id, profile6, attendance6);
        Employee employee7 = new Employee(name7, employee7id, profile7, attendance7);

        attendanceData.addAll(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        return attendanceData;
    }

    public static ObservableList<Employee> createSampleLeaves() {
        ObservableList<Employee> leaveData = FXCollections.observableArrayList();

        Employee employee1 = new Employee(name1, employee1id, leaves1, 20);
        Employee employee2 = new Employee(name2, employee2id, leaves2, 15);
        Employee employee3 = new Employee(name3, employee3id, leaves3, 25); 
        Employee employee4 = new Employee(name4, employee4id, leaves4, 10);
        Employee employee5 = new Employee(name5, employee5id, leaves5, 30); 
        Employee employee6 = new Employee(name6, employee6id, leaves6, 22); 
        Employee employee7 = new Employee(name7, employee7id, leaves7, 18); 

        leaveData.addAll(employee1, employee2, employee3, employee4, employee5, employee6, employee7);

        return leaveData;
    }
}
