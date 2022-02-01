package Repository;

import Entity.BankManger;
import Entity.Sub_Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BranchMainRepository {
    Connection connection;
    PreparedStatement preparedStatement;


    public BranchMainRepository() throws SQLException, ClassNotFoundException {
        try {

             connection = Singleton.getInstance().getConnection();

        } catch (SQLException e) {
            System.out.println("bad code");
        } catch (ClassNotFoundException s) {
            System.out.println("bad code class");
        }
    }

    public void establishedBankBranch(Sub_Branch sub_branch) {
        try {
            String establish = "INSERT INTO branch (name,branchid,manegename) VALUES (?,?,?)";
            this.preparedStatement =
                    connection.prepareStatement(establish);
            this.preparedStatement.setString(1, sub_branch.getNameBranch());
            this.preparedStatement.setString(2, sub_branch.getCodeBranch());
            this.preparedStatement.setString(3, sub_branch.getMangenName());
            this.preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
           e.printStackTrace();
            System.out.println("bad code");
        }

    }

    public void hiringManager(BankManger bankManger) {
        String hiring = "INSERT INTO mangelist(name,nationalid,employeeid,namebranch,branchids,rank) VALUES(?,?,?,?,?,?);";
        try {
            this.preparedStatement = connection.prepareStatement(hiring);
            this.preparedStatement.setString(1, bankManger.getFullName());
            this.preparedStatement.setString(2, bankManger.getNationalId());
            this.preparedStatement.setString(3, bankManger.getEmployeeId());
            this.preparedStatement.setString(4, bankManger.getBranchName());
            this.preparedStatement.setString(5, bankManger.getBranchId());
            this.preparedStatement.setString(6, "manege");
            this.preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("bad code in hiring");
        }
    }
    public void showInformation(){
        String sql="SELECT * FROM branch;";
        try{
            preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.print("id: "+resultSet.getInt(1)+"  ");
            System.out.print("name: "+resultSet.getString(2)+"  ");
            System.out.print("manege name: "+resultSet.getString(3)+"  ");
            System.out.print("branch Id: "+resultSet.getString(4)+"  ");
            System.out.println();
        }
    }catch (SQLException e){
            System.out.println("wrong iformation1");
        }
    }
    public void showInformation(String name){
        String sql="SELECT * FROM branch WHERE name =?;";
        try{ preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.print("id: "+resultSet.getInt(1)+"  ");
                System.out.print("name: "+resultSet.getString(2)+"  ");
                System.out.print("manege name: "+resultSet.getString(3)+"  ");
                System.out.print("branch Id: "+resultSet.getString(4)+"  ");
                System.out.println();
            }
        }catch (SQLException e){
            System.out.println("wrong iformation");
        }}
}