package Service;

import Entity.Sub_Branch;
import Repository.BranchRepository;

import java.util.Random;
import java.util.Scanner;

public class BranchService {
    private String name;
    private String code;
    private String MangeName;
   // BranchService branchService = new BranchService();
    BranchRepository branchRepository =new BranchRepository();
    Sub_Branch sub_branch;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public void establishedBankBranch(String mangeName){
        System.out.println("please insert name branch");
        this.name = scanner.next();
       this. code =String.valueOf(random.ints(4,1000,2000).findFirst().getAsInt());
        sub_branch = new Sub_Branch(name,mangeName,code);
        branchRepository.establishedBankBranch(sub_branch);

        //some code for repositorr
    }
    public String findBranchId(String name){
        //code from repository
        String id;
        return  id;
    }
}
