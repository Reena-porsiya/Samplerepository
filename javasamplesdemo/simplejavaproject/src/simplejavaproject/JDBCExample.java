package simplejavaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:mysql://localhost:3306/sampleschemas";
   static final String USER = "root";
   static final String PASS = "root";
   static final String QUERY = "SELECT id, first, last, age FROM workers";
   static final String UPDATE_QUERY = "UPDATE workers set age=30 WHERE id=102";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ) {
         // Let us check if it returns a true Result Set or not.
         Boolean ret = stmt.execute(UPDATE_QUERY);
         System.out.println("Return value is : " + ret.toString() );

         // Let us update age of the record with ID = 103;
         int rows = stmt.executeUpdate(UPDATE_QUERY);
         System.out.println("Rows impacted : " + rows );

         // Let us select all the records and display them.
         ResultSet rs = stmt.executeQuery(QUERY);		      

         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
         rs.close();
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}