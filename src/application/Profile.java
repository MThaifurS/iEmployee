package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Profile {
    
    private String department;
    private String dateJoined;
    private Contact contactInfo;
    private Address address;
    
    
    public Profile() {
    }

    
    public Profile(String department) {
        this.department = department;
    }
    
    
    public Profile(Address address, Contact contactInfo, String department, String dateJoined) {
    	this.address = address;
    	this.contactInfo = contactInfo;
    	this.department = department;
    	this.dateJoined = dateJoined;
    }

    
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    
    public String getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(String dateJoined) {
        this.dateJoined = dateJoined;
    }

    
    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }

    
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    
    @Override
public String toString() {
    return "\nEmployee Profile:\n" +
            "Department: " + department + "\n" +
            "Date Joined: " + dateJoined + "\n" +
             contactInfo + "\n" +
             address;
}
}
