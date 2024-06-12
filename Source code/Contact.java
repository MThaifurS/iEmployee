
//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


public class Contact {
    private String email;
    private String phoneNum;

    // Default constructor
    public Contact() {
    }

    // Parameterized constructor
    public Contact(String email, String phoneNum) {
        this.email = email;
        this.phoneNum = phoneNum;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for phoneNum
    public String getPhoneNum() {
        return phoneNum;
    }

    // Setter for phoneNum
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        String printString= "\nContact:\n" +
            "Email: " + email + "\n" +
            "Phone Number: " + phoneNum;
        return printString;
}
}
