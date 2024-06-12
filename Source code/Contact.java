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

    // Overriding toString method
    @Override
    public String toString() {
        return "Contact{" +
                "email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
