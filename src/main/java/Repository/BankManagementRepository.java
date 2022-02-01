package Repository;

import Entity.BankManger;
import Entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankManagementRepository {
    Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;

    public BankManagementRepository() throws SQLException, ClassNotFoundException {
    }

    public void hiringEmployee(Employee employee)  {
        try {

        String hire = "INSERT INTO employee(name,nationalid,employeeid,branchid,namebranch,rank) VALUES(?,?,?,?,?,?);";
        //this.preparedStatement = connection.prepareStatement(hire);
       preparedStatement =
                connection.prepareStatement(hire);
        this.preparedStatement.setString(1, employee.getFullName());
        this.preparedStatement.setString(2, employee.getNationalId());
        this.preparedStatement.setString(3, employee.getEmployeeId());
        this.preparedStatement.setString(4, employee.getBranchId());
        this.preparedStatement.setString(5, employee.getBranchName());
        this.preparedStatement.setString(6, employee.getRank());
        this.preparedStatement.executeUpdate();
    }catch (SQLException e) {
            e.printStackTrace();
        }        }
    public boolean Ishere(String nationalId,String employeeId) throws SQLException {
        try {

        String check="SELECT COUNT(*) FROM mangelist where nationalid=? and employeeid=? ";
        preparedStatement= connection.prepareStatement(check);
        preparedStatement.setString(1,nationalId);
        preparedStatement.setString(2,employeeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
            System.out.println(resultSet.getInt(1));
        if (resultSet.getInt(1)>=1){
            return true;
        }
        else
            return false;
    }catch (SQLException e){
            System.out.println("your not find");
            return false;
        }}
    public String findNameBranch(String employeeid){
        String sqlCode="SELECT namebranch from mangelist where employeeid=? ";
        try {
            preparedStatement= connection.prepareStatement(sqlCode);

        preparedStatement.setString(1,employeeid);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }  catch (SQLException e) {
        e.printStackTrace();
        return null;
    }}
    public String findIdBranch(String employeeid) throws SQLException {
        try {  String sqlCode="SELECT branchids from mangelist where employeeid=? ";
        preparedStatement= connection.prepareStatement(sqlCode);
        preparedStatement.setString(1,employeeid);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

            return resultSet.getString(1);


    } catch (SQLException e) {
        e.printStackTrace();
        return null;
    }}
public void info(String employeeid) throws SQLException {
        try {
    String sqlCode="SELECT * from mangelist where employeeid=? ";
    preparedStatement= connection.prepareStatement(sqlCode);
    preparedStatement.setString(1,employeeid);
    ResultSet resultSet = preparedStatement.executeQuery();
    resultSet.next();
        System.out.println(resultSet.getInt(1));
        System.out.println(resultSet.getString(2));
        System.out.println(resultSet.getString(3));
        System.out.println(resultSet.getString(4));
        System.out.println(resultSet.getString(5));
        System.out.println(resultSet.getString(6));


    } catch (SQLException e) {
        e.printStackTrace();

    }
    catch (NullPointerException e){
        e.printStackTrace();
    }
}
}
