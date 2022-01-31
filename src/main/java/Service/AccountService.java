package Service;

import Entity.Account;
import Entity.Customer;
import Repository.AccountRepository;

import java.sql.SQLException;

public class AccountService {
    AccountRepository accountRepository;

    public void withdraw(long amont,String name,String id){
        long amountAccount=accountRepository.howMuchHave(id);
        if (amountAccount < amont){
            accountRepository.withdraw(amont,id);
        }
        else {
            System.out.println("not have money");
        }

    }
    public void deposite(Account account){
        try {

        accountRepository.deposit(account.getAmount(),account.getId());
    }catch (SQLException e){
            e.printStackTrace();
        }}
    public void createAccount(Account account, Customer customer){
        try {
        accountRepository.createAccount(account);

    }catch (SQLException e) {
            e.printStackTrace();
        }
     catch (Exception s){
            s.getStackTrace()
     }}
    public  void showInformatjionAccount(String name){
        accountRepository.
    }
}
