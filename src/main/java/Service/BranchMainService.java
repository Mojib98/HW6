package Service;

import Entity.BankManger;
import Entity.Sub_Branch;
import Repository.BranchMainRepository;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class BranchMainService {
    private String name;
    private String code;
    private String mangeName;
    private BankManger bankManger;
   // BranchService branchService = new BranchService();
   private BranchMainRepository branchRepository;
    private Sub_Branch sub_branch;
    private Scanner scanner;
    private Random random;

    public BranchMainService() throws SQLException, ClassNotFoundException {
        this.branchRepository =new BranchMainRepository();
        this.scanner = new Scanner(System.in);
        this.random = new Random();

    }

    public void establishedBankBranch()  {

        System.out.println("please insert name branch");
        this.name = scanner.next();
        this.code = String.valueOf(random.ints(4, 1000, 2000).findFirst().getAsInt());
        hireing(this.name, this.code);
        sub_branch = new Sub_Branch(name, this.mangeName, code);
        branchRepository.establishedBankBranch(sub_branch);
        branchRepository.hiringManager(this.bankManger);

        System.out.println("your establish currect");


    }
    public void hireing(String nameBranch,String idBranch){
        System.out.println("please insert full name");
        this.mangeName=scanner.next();
        System.out.println("please insert nationalid");
        String nationalId =scanner.next();
        String employeeId =String.valueOf(random.ints(3,100,200).findFirst().getAsInt());
        this.bankManger=new BankManger(this.mangeName,nationalId,employeeId,nameBranch,idBranch,"Management");
    }
    public void showAllBranch(){
        branchRepository.showInformation();
    }
}
