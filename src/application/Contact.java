package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


public class Contact {
    private String email;
    private String phoneNum;

    
    public Contact() {
    }

    public Contact(String email, String phoneNum) {
        this.email = email;
        this.phoneNum = phoneNum;
    }

    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getPhoneNum() {
        return phoneNum;
    }

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
