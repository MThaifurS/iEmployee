
//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)


public class Employee {
    private Name name;
    private int id;
    private int leaveEntitled;
    private Leaves leaves; 
    private Profile profile;

    // Default constructor
    public Employee() {
        this.leaves = new Leaves();
    }

    // Parameterized constructor
    public Employee(Name name, int id, int leaveEntitled, Profile profile) {
        this.name = name;
        this.id = id;
        this.leaveEntitled = leaveEntitled;
        this.profile = profile;
        this.leaves = new Leaves(); // Initialize leaves list
    }

    // Getter and setter for names
    public Name getNames() {
        return name;
    }

    public void setNames(Name name) {
        this.name = name;
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
        return "\nEmployee:\n" +
                name + "\n" +
                "ID: " + id + "\n" +
                "Leave Entitled: " + leaveEntitled + "\n" + "\n" +
                 leaves +
                 profile;
    }
}
