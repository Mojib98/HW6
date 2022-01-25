package Repository;

import Entity.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository {

    Connection connection;
    PreparedStatement preparedStatement;

    public AccountRepository() throws SQLException, ClassNotFoundException {
        connection = Singleton.getInstance().getConnection();
    }
    public void createAccount(Account account) throws SQLException {
        String inser="INSERT INTO account(name,accountid,branchid,branchname,cardid,amoumt) valuse(?,?,?,?,?,?);";
        preparedStatement = connection.prepareStatement(inser);
        preparedStatement.setString(1,account.getName());
        preparedStatement.setString(2,account.getId());
        preparedStatement.setString(3,account.getBranchId());
        preparedStatement.setString(4,account.getBranchName());
        preparedStatement.setString(5,account.getCardId());
        preparedStatement.setInt(6,account.getAmount());
        preparedStatement.executeQuery();
    }
     public void deposit(int amount,String id) throws SQLException {
        String a="SELECT amount from account" +
                "where accountid=?";
        preparedStatement=connection.prepareStatement(a);
        preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         int amo=resultSet.getInt(1);
         amount +=amo;
         String update="UPADTE account set amount=? where accountid=?";
         preparedStatement=connection.prepareStatement(update);
         preparedStatement.setInt(1,amount);
         preparedStatement.setString(2,id);
         preparedStatement.executeUpdate();
     }
     public void withdraw(int a,String id) throws SQLException {
         String s="SELECT amount from account" +
                 "where accountid=?";
         preparedStatement=connection.prepareStatement(s);
         preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         int amo=resultSet.getInt(1);
         amo -=a;
         String update="UPADTE account set amount=? where accountid=?";
         preparedStatement=connection.prepareStatement(update);
         preparedStatement.setInt(1,amo);
         preparedStatement.setString(2,id);
         preparedStatement.executeUpdate();
     }
     public  int howMuchHave(String id) throws SQLException {
         String a="SELECT amount from account" +
                 "where accountid=?";
         preparedStatement=connection.prepareStatement(a);
         preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         int amo=resultSet.getInt(1);
         return amo;
     }

}