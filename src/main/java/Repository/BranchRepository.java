package Repository;
import Entity.Sub_Branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BranchRepository {
    Connection  connection;
    PreparedStatement preparedStatement;


    public BranchRepository() throws SQLException, ClassNotFoundException {
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

}
