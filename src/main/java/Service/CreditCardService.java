package Service;

import Entity.CreditCard;

public class CreditCardService {
    private String accountId;
    private String cardId;
    private String cvv2;
    private String name;
    private String status;
    CreditCardService creditCardService = new CreditCardService();
    CreditCard creditCard;
    public void activingCard(String id){
        this.cvv2=String.valueOf(random.ints(4,1000,2000).findFirst().getAsInt());
        this.accountId=id;
        this.status="Active";
        creditCard=new CreditCard(id,cvv2,status);

    }
    private boolean isTrue(String serialid,String cvv2,String password){
    creditCard = new CreditCard(serialid,cvv2,password,"0");
    //
    }
    private void blocking(){}
    private void activing(){}
    private boolean ChackMony(){}

}
