package Service;

import Entity.Account;
import Entity.CreditCard;
import Repository.CreditCardRepository;

import java.sql.SQLException;
import java.util.Random;

public class CreditCardService {
    private String accountId;
    private String cardId;
    private String cvv2;
    private String name;
    private String status;
    AccountService accountService = new AccountService();
  //  CreditCardService creditCardService = new CreditCardService();
    CreditCardRepository cardRepository=new CreditCardRepository();
    CreditCard creditCard;
    Random random = new Random();

    public CreditCardService() throws SQLException, ClassNotFoundException {
    }

    public void activatingCard(String id){
        this.cvv2=String.valueOf(random.ints(4,1000,2000).findFirst().getAsInt());
        this.accountId=id;
        this.status="Active";
        creditCard=new CreditCard(id,cvv2,status);
        cardRepository.activatingCard(creditCard);

    }
    private boolean isTrue(String serialid,String cvv2,String password){
    creditCard = new CreditCard(serialid,cvv2,password,"0");
        try {
            return cardRepository.checkingPassword(creditCard);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
    private void blocking(){}
    public boolean isHaveAccount(String idCard){
        return cardRepository.isHaveAccount(idCard);
    }
    public boolean isHaveMoney(String cardId,Long amount){
       long money= accountService.haveMoney(cardId);
       if (money > amount+600){
           return true;
       }
       else
           return false;
    }
    public void deposite(String cardId,long amount){
      String id=  accountService.findIdByCard(cardId);
        Account accountdep= new Account(id,amount);
        accountService.deposit(accountdep);
    }
    public void withdew(String cardId,long amount){
        String id=  accountService.findIdByCard(cardId);
        accountService.withdraw(amount," ",id);
    }
    public boolean cheackingPassword(String cadrdId,String password,String cvv2) throws SQLException {
        creditCard = new CreditCard(cadrdId,cvv2,password,"active");
        return cardRepository.checkingPassword(creditCard);
    }
}
