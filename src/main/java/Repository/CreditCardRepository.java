package Repository;

import Entity.CreditCard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardRepository {
    Connection connection = Singleton.getInstance().getConnection();
    PreparedStatement preparedStatement;

    public CreditCardRepository() throws SQLException, ClassNotFoundException {
    }

    public void activatingCard(CreditCard creditCard) {
        try {
            String activing = "UPDATE card SET status=?,cvv2=?,password=? WHERE accountid=?";
            preparedStatement = connection.prepareStatement(activing);
            preparedStatement.setString(1, creditCard.getStatus());
            preparedStatement.setString(2, creditCard.getCvv2());
            preparedStatement.setString(3, "1");
            preparedStatement.setString(4, creditCard.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkingCard(String cardId) throws SQLException {
        try {
            String checking = "SELECT COUNT(*) FROM creditcard WHERE cardId = ?";
            preparedStatement = connection.prepareStatement(checking);
            preparedStatement.setString(1, cardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int a = resultSet.getInt(1);
            if (a == 1) {
                return true;
            } else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean checkingPassword(CreditCard creditCard) throws SQLException {
        try{
        String check = "SELECT count(*) FROM creditcard WHERE cardid=? and cvv2=? and password=?";
        preparedStatement = connection.prepareStatement(check);
        preparedStatement.setString(1, creditCard.getSerialCarl());
        preparedStatement.setString(2, creditCard.getCvv2());
        preparedStatement.setString(3, creditCard.getPassword());
        ResultSet i = preparedStatement.executeQuery();
        if (i == null) {
            return false;
        } else
            return true;
    }catch (SQLException e){
            e.printStackTrace();
            return false;
        }}

    public void changePassword(String serialCard, String password) throws SQLException {
        String check = "UPDATE creditcard set password=? where cardid=?";
        preparedStatement = connection.prepareStatement(check);
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, serialCard);
        preparedStatement.executeUpdate();
    }

    public boolean isHaveAccount(String cardId) {
        try {
            String check = "SELECT COUNT(*) FROM account WHERE cardId=?";
            this.preparedStatement = connection.prepareStatement(check);
            preparedStatement.setString(1, cardId);
            ResultSet resultSet = preparedStatement.executeQuery(check);
            resultSet.next();
            int c = resultSet.getInt(1);
            if (c >= 1) {
                return true;
            } else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
