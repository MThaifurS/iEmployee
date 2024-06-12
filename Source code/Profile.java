

public class Profile {
    
    private String department;
    private String dateJoined;
    private Contact contactInfo;
    private Address address;
    
    // Default constructor
    public Profile() {
    }

    // Constructor with department parameter
    public Profile(String department) {
        this.department = department;
    }

    // Full parameterized constructor
    public Profile(String department, String dateJoined, Contact contactInfo, Address address) {
        this.department = department;
        this.dateJoined = dateJoined;
        this.contactInfo = contactInfo;
        this.address = address;
    }
    
    // Getter and setter for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Getter and setter for dateJoined
    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    // Getter and setter for contactInfo
    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Getter and setter for address
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    // Overriding toString method to print the profile information
    @Override
    public String toString() {
        return "Profile{" +
                "department='" + department + '\'' +
                ", dateJoined='" + dateJoined + '\'' +
                ", contactInfo=" + contactInfo +
                ", address=" + address +
                '}';
    }
}
