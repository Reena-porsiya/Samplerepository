package simplejavaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCBatchExample {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschemas";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            connection.setAutoCommit(false); // Disable auto-commit

            String insertQuery = "INSERT INTO employee (id, name, salary) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            // Add the first statement to the batch
            preparedStatement.setInt(1, 7);
            preparedStatement.setString(2, "John");
            preparedStatement.setDouble(3, 50000);
            preparedStatement.addBatch();

            // Add the second statement to the batch
            preparedStatement.setInt(1, 8);
            preparedStatement.setString(2, "Jane");
            preparedStatement.setDouble(3, 60000);
            preparedStatement.addBatch();
         // Clear the batch (optional, you might want to remove statements)
            //preparedStatement.clearBatch();


            // Clear the batch (optional, you might want to remove statements)
            // preparedStatement.clearBatch();

            // No statements remain in the batch after clearBatch()

            // Execute the batch
            int[] updateCounts = preparedStatement.executeBatch();

            connection.commit(); // Commit changes
            // Clear the batch (optional, you might want to remove statements)
            //preparedStatement.clearBatch();


            for (int count : updateCounts) {
                System.out.println("Rows affected: " + count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
