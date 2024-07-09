package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Employee {
    private Name name;
    private int id;
    private int leaveEntitled;
    private Leaves leaves; 
    private Profile profile;
    private Attendance attendance;

    
    public Employee() {
        this.leaves = new Leaves();
        this.attendance = new Attendance(0); 
    }

    
    public Employee(Name name, int id, Profile profile) {
        this.name = name;
        this.id = id;
        this.profile = profile;
        this.leaves = new Leaves(); // Initialize leaves list
    }
    
    
    public Employee(Name name, int id, Leaves leaves, int leaveEntitled) {
        this.name = name;
        this.id = id;
        this.leaveEntitled = leaveEntitled;
        this.leaves = leaves; 
    }
    
    
    public Employee(Name name, int id, Profile profile, Attendance attendance) {
        this.name = name;
        this.id = id;
        this.profile = profile;
        this.attendance = attendance;
        this.leaves = new Leaves(); 
    }

    
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getLeaveEntitled() {
        return leaveEntitled;
    }

    public void setLeaveEntitled(int leaveEntitled) {
        this.leaveEntitled = leaveEntitled;
    }

    
    public Profile getProfile() {
        return profile;
    }
    
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    
    public Leaves getLeaves() {
        return leaves;
    }
    
    public void setLeaves(Leaves leaves) {
        this.leaves = leaves;
    }

    
    public void addLeave(Leave leave) {
        this.leaves.addLeave(leave);
    }

    public void removeLeave(Leave leave) {
        this.leaves.removeLeave(leave);
    }

    public void printLeaves() {
        this.leaves.printLeaves();
    }

    
    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    @Override
    public String toString() {
        return "\nEmployee:\n" +
                name + "\n" +
                "ID: " + id + "\n" +
                "Leave Entitled: " + leaveEntitled + "\n" + "\n" +
                leaves + "\n" +
                profile + "\n" +
                attendance;
    }
}
