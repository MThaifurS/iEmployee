package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

import java.time.LocalDate;

public class Leave {
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean approvalStatus;

    
    public Leave() {
    }

    
    public Leave( LocalDate startDate, LocalDate endDate, boolean approvalStatus) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.approvalStatus = approvalStatus;
    }


    
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    
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
                "Start Date: " + startDate + "\n" +
                "End Date: " + endDate + "\n" +
                "Approval Status: " + convertBooleanValue(approvalStatus);

    }
}
