package Service;

import java.sql.SQLException;
import java.util.Scanner;

public class CardToCardService {
    private String originCard,destinationCard;
    long money;
    CreditCardService creditCardService=new CreditCardService();
    Scanner scanner = new Scanner(System.in);

    public CardToCardService() throws SQLException, ClassNotFoundException {
    }

    public void fundTransfers(){
        System.out.println("please insert your cart ");
        originCard=scanner.next();
        System.out.println("please insert destination");
        destinationCard=scanner.next();
        boolean isOriginCard=checkingCard(originCard);
        boolean isDestionCard=checkingCard(destinationCard);
        System.out.println("please insert your money");
        long money=scanner.nextLong();
        if(isDestionCard && isDestionCard){
            if (isOriginCard){

            }
        }




    }


    public boolean checkingCard(String card){
      boolean isceck=  creditCardService.isHaveAccount(card);
      if (isceck){
          System.out.println("your cart currect");
          return  true;
      }
      else
          System.out.println("wrong Card");
      return false;

    }
    public boolean isOriginHaveMoney(String originCard){
        return creditCardService.isHaveMoney(originCard,money);
    }
    public void doTransfer(){
        creditCardService.withdew(destinationCard,money);
        creditCardService.deposite(destinationCard,money);
    }
  //  public boolean checkPassword(String password,String cvv2){

   // }

}
