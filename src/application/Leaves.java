package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.util.ArrayList;
import java.util.List;

public class Leaves {
    private List<Leave> leavesList;

    
    public Leaves() {
        this.leavesList = new ArrayList<>();
    }
    
    
    public void setLeavesList(List<Leave> leavesList) {
        this.leavesList = leavesList;
    }
    
    
    List<Leave> getLeavesList() {
    	return leavesList;
    }

    
     public void addLeave(Leave leavesList) {
        this.leavesList.add(leavesList);
        
    }

    
    public void removeLeave(Leave leave) {
        this.leavesList.remove(leave);
            
    }

    
    public void printLeaves() {
        for (Leave leave : leavesList) {
            System.out.println(leave);
        }
        System.out.println("Printing complete.");
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
