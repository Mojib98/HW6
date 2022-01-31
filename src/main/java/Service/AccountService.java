package Service;

import Entity.Account;
import Entity.Customer;
import Repository.AccountRepository;

import java.sql.SQLException;

public class AccountService {
    AccountRepository accountRepository;

    public void withdraw(long amount,String name,String id){
        long amountAccount=accountRepository.howMuchHave(id);
        if (amountAccount < amount){
            accountRepository.withdraw(amount,id);
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
    public long haveMoney(String id){
        try {
            return accountRepository.howMuchHave(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
