import java.util.Scanner;

// Enum for leave types
enum LeaveType {
    ANNUAL, SICK
}

// Class representing an employee
class Employee {
    private String employeeId;
    private String employeeName;
    private int annualLeaveBalance;
    private int sickLeaveBalance;

    public Employee(String employeeId, String employeeName, int annualLeaveBalance, int sickLeaveBalance) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.annualLeaveBalance = annualLeaveBalance;
        this.sickLeaveBalance = sickLeaveBalance;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getAnnualLeaveBalance() {
        return annualLeaveBalance;
    }

    public void setAnnualLeaveBalance(int annualLeaveBalance) {
        this.annualLeaveBalance = annualLeaveBalance;
    }

    public int getSickLeaveBalance() {
        return sickLeaveBalance;
    }

    public void setSickLeaveBalance(int sickLeaveBalance) {
        this.sickLeaveBalance = sickLeaveBalance;
    }
}

// Class representing a leave request
class LeaveRequest {
    private String requestId;
    private Employee employee;
    private String startDate;
    private String endDate;
    private LeaveType leaveType;

    public LeaveRequest(String requestId, Employee employee, String startDate, String endDate, LeaveType leaveType) {
        this.requestId = requestId;
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
    }

    public String getRequestId() {
        return requestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }
}

public class EmployeeLeaveManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee("E001", "John Doe", 20, 10); // Sample employee data

        System.out.println("Welcome to the Employee Leave Management System");
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Request Leave");
            System.out.println("2. Check Leave Balances");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    requestLeave(employee, scanner);
                    break;
                case 2:
                    checkLeaveBalances(employee);
                    break;
                case 3:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void requestLeave(Employee employee, Scanner scanner) {
        System.out.println("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.next();
        System.out.println("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.next();
        System.out.println("Select leave type:");
        System.out.println("1. Annual Leave");
        System.out.println("2. Sick Leave");
        int leaveTypeChoice = scanner.nextInt();
        LeaveType leaveType = (leaveTypeChoice == 1) ? LeaveType.ANNUAL : LeaveType.SICK;

        int leaveDays = calculateLeaveDays(startDate, endDate);
        if (leaveType == LeaveType.ANNUAL) {
            if (employee.getAnnualLeaveBalance() >= leaveDays) {
                employee.setAnnualLeaveBalance(employee.getAnnualLeaveBalance() - leaveDays);
                LeaveRequest leaveRequest = new LeaveRequest(generateRequestId(), employee, startDate, endDate, leaveType);
                saveLeaveRequest(leaveRequest);
                System.out.println("Leave requested successfully");
            } else {
                System.out.println("Insufficient annual leave balance");
            }
        } else {
            if (employee.getSickLeaveBalance() >= leaveDays) {
                employee.setSickLeaveBalance(employee.getSickLeaveBalance() - leaveDays);
                LeaveRequest leaveRequest = new LeaveRequest(generateRequestId(), employee, startDate, endDate, leaveType);
                saveLeaveRequest(leaveRequest);
                System.out.println("Leave requested successfully");
            } else {
                System.out.println("Insufficient sick leave balance");
            }
        }
    }

    public static void checkLeaveBalances(Employee employee) {
        System.out.println("Annual Leave Balance: " + employee.getAnnualLeaveBalance());
        System.out.println("Sick Leave Balance: " + employee.getSickLeaveBalance());
    }

    public static int calculateLeaveDays(String startDate, String endDate) {
        // Logic to calculate the number of leave days
        // Sample calculation: counting the days between start and end dates
        return 5;
    }

    public static String generateRequestId() {
        // Logic to generate a unique request ID
        return "LR001";
    }

    public static void saveLeaveRequest(LeaveRequest leaveRequest) {
        // Logic to save the leave request to an in-memory data structure
        // Not applicable in the in-memory example
        System.out.println("Saving leave request to an in-memory data structure");
    }
}
