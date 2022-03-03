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


         try (var session = sessionFactory.openSession()) {
             var transaction = session.beginTransaction();
             try {
                Account accpunt= session.find(Account.class,id);
                Long amount1 = accpunt.getAmount();
                 amount +=amount1;
                 accpunt.setAmount(amount);
                 session.update(accpunt);

                 transaction.commit();
             } catch (Exception e) {
                 transaction.rollback();
                 throw e;
             }
         }

     }
     public void withdraw(long amount,String id) throws SQLException {

         try (var session = sessionFactory.openSession()) {
             var transaction = session.beginTransaction();
             try {
                 Account accpunt= session.find(Account.class,id);
                 Long amount1=accpunt.getAmount();
                 if (amount<=amount1) {
                     amount -= amount1;
                     accpunt.setAmount(amount);
                     session.update(accpunt);
                     transaction.commit();
                 }
                 else return;

             } catch (Exception e) {
                 transaction.rollback();
                 throw e;
             }
         }

     }
     public  long howMuchHave(String id) throws SQLException {

         try (var session = sessionFactory.openSession()) {
             var transaction = session.beginTransaction();
             try {
                 Account accpunt= session.find(Account.class,id);
                 Long amount1=accpunt.getAmount();
                    return amount1;
             } catch (Exception e) {
                 transaction.rollback();
                 throw e;
             }
         }

    }

    public void showInformationByName(String name) throws SQLException {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                Account accpunt= session.find(Account.class,name);
                System.out.println(accpunt);
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }

    }
    public void showInformationById(String id) throws SQLException {
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                Account accpunt= session.find(Account.class,id);
                System.out.println(accpunt);
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }


    }
     /*
    public String findId(String cardid){
        try (var session = sessionFactory.openSession()) {
            var transaction = session.beginTransaction();
            try {
                Account accpunt= session.find(Account.class,cardid);
                return accpunt.getId();
            } catch (Exception e) {
                transaction.rollback();
                throw e;
            }
        }
}*/

}