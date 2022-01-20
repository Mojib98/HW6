package Entity;

public class Employee extends Person {
    private String employeeId;
    public Employee(String fullName, String nationalId,String employeeId,String branchName) {
        super(fullName, nationalId,branchName);
        this.employeeId=employeeId;
    }
}
