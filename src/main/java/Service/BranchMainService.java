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
    private String MangeName;
    BankManger bankManger;
   // BranchService branchService = new BranchService();
    BranchMainRepository branchRepository =new BranchMainRepository();
    Sub_Branch sub_branch;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public BranchMainService() throws SQLException, ClassNotFoundException {
    }

    public void establishedBankBranch(String mangeName) throws SQLException {
        System.out.println("please insert name branch");
        this.name = scanner.next();
       this. code =String.valueOf(random.ints(4,1000,2000).findFirst().getAsInt());
        System.out.println("please insert mange name");
        sub_branch = new Sub_Branch(name,mangeName,code);
        hireing(this.name,this.code);
        branchRepository.hiringManager(this.bankManger);
        branchRepository.establishedBankBranch(sub_branch);

        //some code for repositorr
    }
   /* public String findBranchId(String name){
        //code from repository
        String s =""
        String id;
        return  id;
    }*/
    public void hireing(String nameBranch,String idBranch){
        System.out.println("please insert full name");
        String name=scanner.next();
        System.out.println("please insert nationalid");
        String nationalId =scanner.next();
        String employeeId =String.valueOf(random.ints(4,1000,2000).findFirst().getAsInt());
        this.bankManger=new BankManger(name,nationalId,employeeId,nameBranch,idBranch,"Management");
    }
}
