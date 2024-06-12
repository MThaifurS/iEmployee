import java.time.LocalDate;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Leave {
    private int id; // Add id attribute
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approvalStatus;

    // Default constructor
    public Leave() {
    }

    // Parameterized constructor
    public Leave(int id, LocalDate startDate, LocalDate endDate, boolean approvalStatus) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.approvalStatus = approvalStatus;
    }

    // Getter and setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for startDate
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // Getter and setter for endDate
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    // Getter and setter for approvalStatus
    public boolean isApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(boolean approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String convertBooleanValue(boolean approvalStatus){
        if (approvalStatus == true){
            String status = "accepted";
            return status;
        } 
        String status = "decline";
        return status;
    }


    @Override
    public String toString() {
        return "\nLeave:\n" +
                "ID: " + id + "\n" +
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Approval Status: " + convertBooleanValue(approvalStatus);

    }
}
