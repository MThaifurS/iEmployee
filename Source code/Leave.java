import java.time.LocalDate;

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

    // Overriding toString method
    @Override
    public String toString() {
        return "Leave{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", approvalStatus=" + approvalStatus +
                '}';
    }
}
