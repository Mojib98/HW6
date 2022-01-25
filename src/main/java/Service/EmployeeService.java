package Service;

import Entity.Account;
import Entity.Customer;
import Repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class EmployeeService {
    Account account;
    Customer customer;
    private String branchName;
    private String branchId;
    EmployeeRepository employeeRepository;
    Scanner scanner;
    Random random ;

    public EmployeeService(String nameemployee) throws SQLException, ClassNotFoundException {
        employeeRepository = new EmployeeRepository();
        scanner = new Scanner(System.in);
        random = new Random();
        findBranchId(nameemployee);
        findBranchName(nameemployee);
    }


    public void createAccount(){
        System.out.println("please insert nmae");
        String name=scanner.next();
        System.out.println("please insert national id");
        String nationalid=scanner.next();
        String code =String.valueOf(random.ints(4,5000,6000).findFirst().getAsInt());
        String idcart=String.valueOf(random.ints(4,7000,9000).findFirst().getAsInt());
        String cartCode="6037"+this.branchId+code+idcart;
        customer=new Customer(name,nationalid,this.branchName,this.branchId);
        account = new Account(code,name,cartCode,this.branchName,this.branchId);

    }
    private void findBranchName(String idemployee) throws SQLException {
        this.branchId= employeeRepository.findIdbranch(idemployee);

    }
    private void findBranchId(String employee) throws SQLException {
        this.branchName=employeeRepository.findNameBranch(employee);
    }
    public void deposite(){

    }
    public void withdraw(){

    }
    public void showInformation(String id){

    }}
