package Service;

import Entity.Employee;
import Repository.BankManagementRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class BankManagementService {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    BankManagementRepository bankManagementRepository;
    Employee employee;

    public BankManagementService() throws SQLException {
        bankManagementRepository = new BankManagementRepository();
    }
    public void hiringEmployee(String branchName, String branchId) throws SQLException {
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert national id");
        String nationalId = scanner.next();
        String code = String.valueOf(random.ints(4, 2000, 3000).findFirst().getAsInt());
        employee = new Employee(name, nationalId,code,branchName,branchId, "simple");
        bankManagementRepository.hiringEmployee(employee);
    }


    //public void employeeClearance


}
