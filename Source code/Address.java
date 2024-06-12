
//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


public class Address {
    private String street;
    private String city;
    private String state;
    private String postalCode;

    // Default constructor
    public Address() {
    }

    // Parameterized constructor
    public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    // Getter for street
    public String getStreet() {
        return street;
    }

    // Setter for street
    public void setStreet(String street) {
        this.street = street;
    }

    // Getter for city
    public String getCity() {
        return city;
    }

    // Setter for city
    public void setCity(String city) {
        this.city = city;
    }

    // Getter for state
    public String getState() {
        return state;
    }

    // Setter for state
    public void setState(String state) {
        this.state = state;
    }

    // Getter for postalCode
    public String getPostalCode() {
        return postalCode;
    }

    // Setter for postalCode
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
