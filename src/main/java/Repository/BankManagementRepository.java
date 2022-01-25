package Repository;

import Entity.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankManagementRepository {
    Connection connection;
    PreparedStatement preparedStatement;

    public void hiringEmployee(Employee employee) throws SQLException {

        String hire = "INSERT INTO employee(name,nationalid,employeeid,branchname,branchid,rank) VALUSE(?,?,?,?,?)";
        //this.preparedStatement = connection.prepareStatement(hire);
        PreparedStatement preparedStatement =
                connection.prepareStatement(hire);
        this.preparedStatement.setString(1, employee.getFullName());
        this.preparedStatement.setString(2, employee.getNationalId());
        this.preparedStatement.setString(3, employee.getEmployeeId());
        this.preparedStatement.setString(4, employee.getBranchName());
        this.preparedStatement.setString(5, employee.getBranchId());
        this.preparedStatement.setString(6, employee.getRank());
        this.preparedStatement.executeUpdate();
    }

}
