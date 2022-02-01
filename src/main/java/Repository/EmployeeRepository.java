package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRepository {
    Connection connection;
    PreparedStatement preparedStatement;

    public EmployeeRepository() throws SQLException, ClassNotFoundException {
        this.connection = Singleton.getInstance().getConnection();
    }
    public String findIdbranch(String idemployee) throws SQLException {
        String find="SELECT branchid FROM employee " +
                "WHERE employeeid=?";

        this.preparedStatement=connection.prepareStatement(find);
        preparedStatement.setString(1,idemployee);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }
    public String findNameBranch(String idemployee) throws SQLException {
        String find="SELECT namebranch FROM employee " +
                "WHERE employeeid=?";
        this.preparedStatement=connection.prepareStatement(find);
        preparedStatement.setString(1,idemployee);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }
    public boolean isCheck(String id,String national){
        try {

            String check="SELECT COUNT(*) FROM employee where nationalid=? and employeeid=? ";
            preparedStatement= connection.prepareStatement(check);
            preparedStatement.setString(1,national);
            preparedStatement.setString(2,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getInt(1)>=1){
                return true;
            }
            else
                return false;
        }catch (SQLException e){
            System.out.println("your not find");
            return false;
        }
    }

}
