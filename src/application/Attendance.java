package application;

//coded by Thaifur(24000641), Adam Ali(24000180), Dwayne(24000257), Syabil(24001125)

public class Attendance {

    
    private double hoursWorked;
    private boolean performance;

    
    public Attendance(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        this.performance = evaluatePerformance(hoursWorked);
    }

    
    public double getHoursWorked() {
        return hoursWorked;
    }

    
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
        this.performance = evaluatePerformance(hoursWorked);
    }

    
    public boolean isPerformance() {
        return performance;
    }

    
    private boolean evaluatePerformance(double hoursWorked) {
        return hoursWorked >= 30;
    }

    
    public String getPerformanceStatus() {
        return performance ? "Good" : "Bad";
    }

    
    public void printAttendanceDetails() {
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.println("Performance: " + getPerformanceStatus());
    }

    
    public boolean isOvertime() {
        return hoursWorked > 40;  
    }

    
    @Override
    public String toString() {
        return "Attendance{" +
                "hoursWorked=" + hoursWorked +
                ", performance=" + getPerformanceStatus() +
                '}';
    }
}
