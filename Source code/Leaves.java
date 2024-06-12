import java.util.ArrayList;
import java.util.List;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Leaves {
    private List<Leave> leavesList;

    // Default constructor
    public Leaves() {
        this.leavesList = new ArrayList<>();
    }

     // Method to add a leave to the list
     public void addLeave(Leave leavesList) {
        this.leavesList.add(leavesList);
        System.out.println("Leave added: " + leavesList.getId());
        System.out.println("Current Leaves List:");
        printLeaves();
    }

    // Method to remove a leave from the list
    public void removeLeave(Leave leave) {
        if (this.leavesList.remove(leave)) {
            System.out.println("Leave removed: " + leave.getId());
            System.out.println("Removal complete.");
        } else {
            System.out.println("Leave with ID " + leave.getId() + " not found. Removal failed.");
        }
    }

    // Method to print all leaves in the list
    public void printLeaves() {
        for (Leave leave : leavesList) {
            System.out.println(leave);
        }
        System.out.println("Printing complete.");
    }

    // Method to find a leave by ID
    public Leave findLeaveById(int id) {
        for (Leave leave : leavesList) {
            if (leave.getId() == id) {
                return leave;
            }
        }
        System.out.println("ID not found: " + id);
        return null; 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Leaves List:\n");
        for (Leave leave : leavesList) {
            sb.append(leave.toString()).append("\n");
        }
        return sb.toString();
    }
}
