package Entity;

public class Employee extends Person {
    private String employeeId;
    private String rank;
    public Employee(String fullName, String nationalId,String employeeId,String branchName,String branchId,String rank) {
        super(fullName, nationalId,branchName,branchId);
        this.employeeId=employeeId;
        this.rank=rank;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getRank() {
        return rank;
    }
}
