package Service;

import Entity.Employee;

import java.util.Random;
import java.util.Scanner;

public class BankManagementService {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Employee employee;

    public void hiringEmployee(String branchName, String branchId) {
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert national id");
        String nationalId = scanner.next();
        String code = String.valueOf(random.ints(4, 1000, 2000).findFirst().getAsInt());

        employee = new Employee(name, nationalId, code, branchName, branchId, "simple");
    }


    //public void employeeClearance


}
