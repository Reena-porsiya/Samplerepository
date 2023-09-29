package servletdemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;

public class SignUpDAO {
	 
	public void saveSignUp(String userid,String firstname,String lastname,String password ) {
		String userId = userid;
		String firstName = firstname;
		String lastName = lastname;
		String passWord = password;
		
		try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
            
            String insertQuery = "insert into user_tbl(user_id, first_name, last_name, password) values(?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(insertQuery);
            
            pstmt.setString(1, userId);
            pstmt.setString(2, firstName);
            pstmt.setString(3, lastName);
            pstmt.setString(4, passWord);
            pstmt.executeUpdate();
		 } catch(SQLException e) {
				e.printStackTrace();
			}

	 }
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
			//SignUpDAO dao1 = new SignUpDAO();
			//dao1.saveSignUp();

		}

	}
           
	