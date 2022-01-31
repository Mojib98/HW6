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
        try {
            String inser = "INSERT INTO account(name,accountid,branchid,branchname,cardid,amoumt) valuse(?,?,?,?,?,?);";
            preparedStatement = connection.prepareStatement(inser);
            preparedStatement.setString(1, account.getName());
            preparedStatement.setString(2, account.getId());
            preparedStatement.setString(3, account.getBranchId());
            preparedStatement.setString(4, account.getBranchName());
            preparedStatement.setString(5, account.getCardId());
            preparedStatement.setLong(6, account.getAmount());
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void deposit(long amount,String id) throws SQLException {
        try {
        String a="SELECT amount from account" +
                "where accountid=?";
        preparedStatement=connection.prepareStatement(a);
        preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         long amo=resultSet.getLong(1);
         amount +=amo;
         String update="UPADTE account set amount=? where accountid=?";
         preparedStatement=connection.prepareStatement(update);
         preparedStatement.setLong(1,amount);
         preparedStatement.setString(2,id);
         preparedStatement.executeUpdate();
     }
    catch (SQLException e){
        e.printStackTrace();
        }
     }
     public void withdraw(long a,String id) throws SQLException {
         String s="SELECT amount from account" +
                 "where accountid=?";
         preparedStatement=connection.prepareStatement(s);
         preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         Long amo=resultSet.getLong(1);
         amo -=a;
         String update="UPADTE account set amount=? where accountid=?";
         preparedStatement=connection.prepareStatement(update);
         preparedStatement.setLong(1,amo);
         preparedStatement.setString(2,id);
         preparedStatement.executeUpdate();
     }
     public  long howMuchHave(String id) throws SQLException {
        try {
         String a="SELECT amount from account" +
                 "where accountid=?";
         preparedStatement=connection.prepareStatement(a);
         preparedStatement.setString(1,id);
         ResultSet resultSet = preparedStatement.executeQuery();
         resultSet.next();
         long amo=resultSet.getLong(1);
         return amo;
     }catch ( SQLException e){
            e.printStackTrace();
        }return 0;}
     public String findIdbyName(String name){
        try {

        String find="SELECT accountid FROM account WHERE name = ?";
        this.preparedStatement= connection.prepareStatement(find);
        this.preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
       return resultSet.getString(1);
     }
        catch (SQLException e ){
            e.printStackTrace();
         }

    return null;
    }
    public void showInformationByName(String name) throws SQLException {
        String diIt="SELECT * FORO account WHERE name = ?";
        this.preparedStatement = connection.prepareStatement(diIt);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.print("name: "+resultSet.getString(1)+"   ");
            System.out.print("accountid: "+resultSet.getString(2)+"   ");
            System.out.print("branchid: "+resultSet.getString(3)+"   ");
            System.out.print("branchname: "+resultSet.getString(4)+"   ");
            System.out.print("cardid: "+resultSet.getString(5)+"   ");
            System.out.print("amoumt: "+resultSet.getLong(6)+"   ");
            System.out.println();
        }
    }
    public void showInformationById(String id) throws SQLException {
        String diIt="SELECT * FORO account WHERE accountid = ?";
        this.preparedStatement = connection.prepareStatement(diIt);
        preparedStatement.setString(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.print("name: "+resultSet.getString(1)+"   ");
            System.out.print("accountid: "+resultSet.getString(2)+"   ");
            System.out.print("branchid: "+resultSet.getString(3)+"   ");
            System.out.print("branchname: "+resultSet.getString(4)+"   ");
            System.out.print("cardid: "+resultSet.getString(5)+"   ");
            System.out.print("amoumt: "+resultSet.getLong(6)+"   ");
            System.out.println();
        }

    }
}