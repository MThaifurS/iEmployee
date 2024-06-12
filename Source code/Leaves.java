 
 import java.util.ArrayList;
 import java.util.List;
 
 public class Leaves {
    private List<Leave> leaves;

    // Default constructor
    public Leaves() {
        this.leaves = new ArrayList<>();
    }

    // Method to add a leave to the list
    public void addLeave(Leave leave) {
        this.leaves.add(leave);
    }

    // Method to remove a leave from the list
    public void removeLeave(Leave leave) {
        this.leaves.remove(leave);
    }

    // Method to print all leaves in the list
    public void printLeaves() {
        for (Leave leave : leaves) {
            System.out.println(leave);
        }
    }

    // Method to find a leave by ID
    public Leave findLeaveById(int id) {
        for (Leave leave : leaves) {
            if (leave.getId() == id) {
                return leave;
            }
        }
        System.out.println("ID not found: " + id);
        return null; 
    }


}
