package simplejavaproject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Statement;


public class JdbcPreparedStatementExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/sampleschemas";
        String username = "root";
        String password = "root";
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO transaction (transaction_id, transaction_date, transaction_time, amount, merchant_name, description, status, card_number) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, 13);
                preparedStatement.setDate(2,java.sql.Date.valueOf("2002-04-26"));
                preparedStatement.setString(3, "9:30");
                preparedStatement.setString(4,"43.000");
                preparedStatement.setString(5, "REENA");
                preparedStatement.setString(6, "Transaction successful");
                preparedStatement.setString(7, "approval");
                preparedStatement.setString(8, "1234 2435 6376");
               
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " rows affected.");
            }
            try (Statement statement = connection.createStatement()) {
                String selectSql = "SELECT * FROM transaction";
                ResultSet rs = statement.executeQuery(selectSql);
                System.out.println("transaction_id  transaction_date  amount");
                while (rs.next()) {
                    int txnid = rs.getInt("transaction_id");
                    Date txndate = rs.getDate("transaction_date");
                    double amount = rs.getDouble("amount");
                    System.out.println(txnid + "   " + txndate + "    " + amount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}