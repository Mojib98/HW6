package Repository;
import Entity.BankManger;
import Entity.Sub_Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BranchMainRepository {
    Connection  connection;
    PreparedStatement preparedStatement;


    public BranchMainRepository() throws SQLException, ClassNotFoundException {
        Connection connection = Singleton.getInstance().getConnection();
        String table="CREATE TABLE IF NOT EXISTS branch(" +
                "id serian," +
                "name varchar(20)" +
                "branchId char(4)" +
                "namemanege varchar(20)" +
                "numemploy integer);";
        PreparedStatement preparedStatement =
                connection.prepareStatement(table);
        preparedStatement.execute();
    }
    public void establishedBankBranch(Sub_Branch sub_branch) throws SQLException {
        String establish="INSERT INTO branch(name,branchId,namemanege,numemploy) VALUSE(?,?,?,?)";
        this.preparedStatement =
                connection.prepareStatement(establish);
        this.preparedStatement.setString(1,sub_branch.getNameBranch());
        this.preparedStatement.setString(2,sub_branch.getCodeBranch());
        this.preparedStatement.setString(3,sub_branch.getMangenName());
        this.preparedStatement.setInt(4,sub_branch.getNumberEmployee());
        this.preparedStatement.executeUpdate();
    }
    public void hiringManager(BankManger bankManger) throws SQLException {
        String hiring = "INSERT INTP mangelist(name,nationalId,idemployee,branchname,branchId,rank) VALUSE(?,?,?,?,?,?)";
        this.preparedStatement = connection.prepareStatement(hiring);
        this.preparedStatement.setString(1,bankManger.getFullName());
        this.preparedStatement.setString(2,bankManger.getNationalId());
        this.preparedStatement.setString(3,bankManger.getEmployeeId());
        this.preparedStatement.setString(4,bankManger.getBranchName());
        this.preparedStatement.setString(5,bankManger.getBranchId());
        this.preparedStatement.setString(6,bankManger.getRank());
        this.preparedStatement.executeUpdate();
    }

}
