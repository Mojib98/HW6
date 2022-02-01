package Service;

import Entity.Employee;
import Repository.BankManagementRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class BankManagementService {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    BankManagementRepository bankManagementRepository ;
    Employee employee;
    private String branchName, branchId;
    public BankManagementService() throws SQLException, ClassNotFoundException {
        bankManagementRepository = new BankManagementRepository();
    }
    public void hiringEmployee(String id)  {
        try{
        barnchNameANDbranchId(id);
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert national id");
        String nationalId = scanner.next();
        String code = String.valueOf(random.ints(4, 2000, 3000).findFirst().getAsInt());
        employee = new Employee(name,nationalId,code,branchId,branchName ,"simple");
        bankManagementRepository.hiringEmployee(employee);
    }catch (SQLException e){
            System.out.println("error in mange service");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }}
    public boolean Ishere(String nationalId,String employeeId) throws SQLException {
        return  bankManagementRepository.Ishere(nationalId,employeeId);
    }
    public void barnchNameANDbranchId(String employeeManegeId) throws SQLException {
        branchName=bankManagementRepository.findIdBranch(employeeManegeId);
      branchId=  bankManagementRepository.findNameBranch(employeeManegeId);

    }
    public void showInformation(String idemployee) throws SQLException {
        bankManagementRepository.info(idemployee);
    }

    //public void employeeClearance


}
