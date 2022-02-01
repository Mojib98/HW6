import Repository.BankManagementRepository;
import Repository.EmployeeRepository;
import Service.BankManagementService;
import Service.BranchMainService;
import Service.EmployeeService;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private String id,password;
    Scanner scanner = new Scanner(System.in);
   BankManagementService bankManagementService;
   BranchMainService branchMainService;
   EmployeeService employeeService;

    public Menu() throws SQLException, ClassNotFoundException {
        bankManagementService = new BankManagementService();
        branchMainService = new BranchMainService();
        employeeService = new EmployeeService();
    }

    public void menu(){
        while (true){
        System.out.println("welcom\n" +
                "please select your\n" +
                "if manege select --> 'm'\n" +
                "if employee select --> 'e'\n" +
                "for cart to cart select 'c");
        char se = scanner.next().charAt(0);
        switch (se){
            case 'a':
                admin();
            case 'm':
                manege();

        }

    }}
    public void manege()  {
        //boolean isUpTime = true;
        try {
            System.out.println("insert your nationalId");
            this.id = scanner.next();
            System.out.println("insert your password");
            this.password = scanner.next();
            boolean isUpTime = isTrueMange(id, password);
            while (isUpTime) {
                System.out.println("for hiring employee insert 1");
                System.out.println("for see your information select 2");
                System.out.println("for see transaction insert 3");
                System.out.println("for exit select 4");
                int select = scanner.nextInt();
                switch (select) {
                    case 1:
                        bankManagementService.hiringEmployee(id);
                        break;
                    case 2:
                        bankManagementService.showInformation(id);
                    case 3:

                    case 4:
                        isUpTime = false;
                    default:
                        continue;

                }
            }
        } catch (SQLException e) {
            System.out.println("bad");
        } catch (InputMismatchException e) {
            System.out.println("do it again");
        }
    }
    private boolean isTrueMange(String employee,String nationalId) throws SQLException {
        return bankManagementService.Ishere(nationalId,employee);
    }
    public void  admin(){
        String name,pass;
        boolean time = true;
        while (time){
            try {

                System.out.println("insert code");
                 name = scanner.next();
                System.out.println("insert pass");
                 pass = scanner.next();
            }catch (InputMismatchException e){
                System.out.println("wrong input");
                continue;
            }
        boolean isTure = false;
        if (pass.equals("admin") && name.equals("admin"))
            isTure=true;
        else
            continue;
        while (isTure){
            int select = 0;
            System.out.println("for establish Bank Branch insert 1");
            System.out.println("for see information about all branch insert 2");

            try {
                select = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("wrong input");
                continue;
            }
            switch (select){
                case 1:
                    try {
                        branchMainService.establishedBankBranch();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    branchMainService.showAllBranch();
                    break;
                case 3:
                    isTure = false;
                    time =false;
                    System.out.println("goodbye");
            }



        }



    }}
    public void employee() throws SQLException, ClassNotFoundException {
        String id,nationalid;
        int select = 0;
        System.out.println("insert id");
        id=scanner.next();
        System.out.println("insert nationalid");
        nationalid = scanner.next();
        boolean isHere = isHere(id,nationalid);
        while (isHere){
            String custumerId;
            Long amount;
            System.out.println("for create account insert 1\n" +
                    "for deposit insert 2\n" +
                    "for withdraw insert 3\n" +
                    "for activing insert 4\n" +
                    "show information customer" +
                    "exit 6");
            select = scanner.nextInt();
            switch (select){
                case 1:
                    employeeService.createAccount();
                case 2:
                    System.out.println("insert id");
                     custumerId = scanner.next();
                    System.out.println("insert your amount");
                     amount = scanner.nextLong();
                    employeeService.deposit(amount," ",custumerId);
                    break;
                case  3:
                    System.out.println("insert id");
                    custumerId = scanner.next();
                    System.out.println("insert your amount");
                    amount = scanner.nextLong();
                    employeeService.withdraw(amount," ",custumerId);
                    break;
                case 4:

                case 5:
                case 6:
                    isHere = false;

            }
        }

    }
    private boolean isHere(String id,String national) throws SQLException {

       return employeeService.isHere(id,national);
}
    public void customer(){

    }



}
