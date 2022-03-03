package Repository;

import Entity.Account;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    Connection connection;
    PreparedStatement preparedStatement;
    private SessionFactory sessionFactory = SessionFactorySingleton.getInstance();

    public AccountRepository() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }
    public void createAccount(Account account)  {
        /*
        try {
            String inser = "INSERT INTO account(name,accountid,branchid,branchname,cardid,amount) values(?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(inser);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getId());
            preparedStatement.setString(3, account.getBranchId());
            preparedStatement.setString(4, account.getBranchName());
            preparedStatement.setString(5, account.getCardId());
            preparedStatement.setLong(6, account.getAmount());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                session.save(account);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }





    }
     public void deposit(long amount,String id) throws SQLException {


         Account accountn=new Account(id,amount);

         try (var session = sessionFactory.openSession()) {
             var transaction = session.beginTransaction();
             try {
                Account accpunt= session.find(Account.class,id);
                Long amount1=accpunt.getAmount();
                 amount +=amount1;
                 accpunt.setAmount(amount);
                 session.save(accpunt);

                 transaction.commit();
             } catch (Exception e) {
                 transaction.rollback();
                 throw e;
             }
         }

     }
     public void withdraw(long a,String id) throws SQLException {

     }
     public  long howMuchHave(String id) throws SQLException {

    return 0;
    }
    public void showInformationByName(String name) throws SQLException {

    }
    public void showInformationById(String id) throws SQLException {


    }
    public String findId(String card){
       return "";
}

}