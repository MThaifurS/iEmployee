package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    
    public Address() {
    }

    
    public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    
    public String getStreet() {
        return street;
    }

   
    public void setStreet(String street) {
        this.street = street;
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        this.city = city;
    }

   
    public String getState() {
        return state;
    }

    
    public void setState(String state) {
        this.state = state;
    }

    
    public String getPostalCode() {
        return postalCode;
    }

   
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        String printString = "\nAddress:\n" +
            "Street: " + street + "\n" +
            "City: " + city + "\n" +
            "State: " + state + "\n" +
            "Postal Code: " + postalCode;
        return printString;
    }
}
