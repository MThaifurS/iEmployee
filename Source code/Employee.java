
/* This class represents individual employees with attributes like name, ID, 
leave entitlement, leave list, and profile information. */

public class Employee {
    private Name names;
    private int id;
    private int leaveEntitled;
    private Leaves leaves; 
    private Profile profile;

    // Default constructor
    public Employee() {
        this.leaves = new Leaves();
    }

    // Parameterized constructor
    public Employee(Name names, int id, int leaveEntitled, Profile profile) {
        this.names = names;
        this.id = id;
        this.leaveEntitled = leaveEntitled;
        this.profile = profile;
        this.leaves = new Leaves(); // Initialize leaves list
    }

    // Getter and setter for names
    public Name getNames() {
        return names;
    }

    public void setNames(Name names) {
        this.names = names;
    }

    // Getter and setter for ids
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for leaveEntitled
    public int getLeaveEntitled() {
        return leaveEntitled;
    }

    public void setLeaveEntitled(int leaveEntitled) {
        this.leaveEntitled = leaveEntitled;
    }

    // Getter and setter for profile
    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    // Methods to manage leaves
    public void addLeave(Leave leave) {
        this.leaves.addLeave(leave);
    }

    public void removeLeave(Leave leave) {
        this.leaves.removeLeave(leave);
    }

    public void printLeaves() {
        this.leaves.printLeaves();
    }

    public Leave findLeaveById(int id) {
        return this.leaves.findLeaveById(id);
    }

    @Override
public String toString() {
    return "Employee{" +
            "names=" + names +
            ", id=" + id +
            ", leaveEntitled=" + leaveEntitled +
            ", leaves=" + leaves +
            ", profile=" + profile +
            '}';
}
}
