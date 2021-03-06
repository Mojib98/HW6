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
    Random random;
    AccountService accountService;

    public EmployeeService() throws SQLException, ClassNotFoundException {
        try {
            employeeRepository = new EmployeeRepository();
            scanner = new Scanner(System.in);
            random = new Random();

        } catch (SQLException e) {
            System.out.println("wrong");
        } catch (ClassNotFoundException s) {
            s.printStackTrace();
        }
    }

    public void createAccount() throws SQLException, ClassNotFoundException {
        System.out.println("please insert name");
        String name = scanner.next();
        System.out.println("please insert national id");
        String nationalid = scanner.next();
        String code = String.valueOf(random.ints(4, 5000, 6000).findFirst().getAsInt());
        String idcart = String.valueOf(random.ints(4, 7000, 9000).findFirst().getAsInt());
        String cartCode = "6037" + this.branchId + code + idcart;
        customer = new Customer(name, nationalid, this.branchName, this.branchId);
        account = new Account(code, name, cartCode, this.branchName, this.branchId,"ACTIVE",0);
        accountService = new AccountService();
        accountService.createAccount(account, customer);

    }

    private void findBranchName(String idemployee) throws SQLException {
        this.branchId = employeeRepository.findIdbranch(idemployee);

    }

    private void findBranchId(String employee) throws SQLException {
        this.branchName = employeeRepository.findNameBranch(employee);
    }

    public void deposit(long amoung, String name, String id) {
        try {
        accountService = new AccountService();
        account = new Account();
        account.setAmount(amoung);
        account.setName(name);
        account.setId(id);
        accountService.deposit(account);
    }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void withdraw(long amount, String name, String id) {
        long nowAmount = accountService.haveMoney(id);
        if (nowAmount > amount) {
            account = new Account();
            account.setAmount(amount);
            account.setName(name);
            account.setId(id);
            accountService.withdraw(amount, name, id);
        } else
            System.out.println("you dont have enough money");
    }

    public void showInformationByName(String name) {
        accountService.showInformationAccount(name);
    }

    public boolean isHere(String id, String national) throws SQLException {
        try {
            boolean is = employeeRepository.isCheck(id, national);
            if (is) {
                findBranchId(id);
                findBranchName(id);
                return is;
            } else
                return false;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


