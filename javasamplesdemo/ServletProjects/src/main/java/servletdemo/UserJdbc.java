package servletdemo;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				
			e.printStackTrace();
			
			}
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschemas";
			Connection con = DriverManager.getConnection(jdbcUrl,"root","root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM user");
			while(rs.next()) {
	    		User user = new User();
	    		user.setUser_id(rs.getString("userid"));
	    		user.setFirst_name(rs.getString("firstname"));
	    		user.setLast_name(rs.getString("lastname"));
	    		user.setPassword(rs.getString("password"));
	    		}
		}catch(SQLException e1) {
		    	e1.printStackTrace();
	    	}
	}
	
}
	        
	       
