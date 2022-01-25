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
        String find="SELECT branchid FROM employee" +
                "where idemployee=?";
        this.preparedStatement=connection.prepareStatement(find);
        preparedStatement.setString(1,idemployee);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }
    public String findNameBranch(String idemployee) throws SQLException {
        String find="SELECT branchname FROM employee" +
                "where idemployee=?";
        this.preparedStatement=connection.prepareStatement(find);
        preparedStatement.setString(1,idemployee);
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getString(1);
    }

}
