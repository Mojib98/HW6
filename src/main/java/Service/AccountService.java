package Service;

import Entity.Account;
import Entity.Customer;
import Repository.AccountRepository;

import java.sql.SQLException;

public class AccountService {
    AccountRepository accountRepository = new AccountRepository();

    public AccountService() throws SQLException, ClassNotFoundException {
    }

    public void withdraw(long amount, String name, String id) {
        try {

            long amountAccount = accountRepository.howMuchHave(id);
            if (amountAccount < amount) {
                accountRepository.withdraw(amount, id);
            } else {
                System.out.println("not have money");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deposit(Account account) {
        try {

            accountRepository.deposit(account.getAmount(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createAccount(Account account, Customer customer) {
        try {
            accountRepository.createAccount(account);

        } catch (Exception s) {
            s.getStackTrace();
        }
    }

    public void showInformationAccount(String name) {
  ;
        }


    public long haveMoney(String id) {
        try {
            return accountRepository.howMuchHave(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    public String findIdByCard(String card){
        return  null;//accountRepository.findId(card);
    }
}
