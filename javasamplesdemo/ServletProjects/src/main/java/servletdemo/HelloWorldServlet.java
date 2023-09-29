package servletdemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.mysql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/HelloWorldServlet/*")
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: venkat testing").append(request.getContextPath());
		System.out.println("testing inside");
		String pathInfo = request.getPathInfo();
		System.out.println("PathInfo is"+ pathInfo);
		response.getWriter().append("testing wild card Served at: ").append(request.getContextPath());
		int i=1;
		if(i==0) {
			return;
		}
		String destination = "/WEB-INF/JSP/welcome.jsp";
		if(pathInfo.equals("/SignUp")) {
			System.out.println("Going to welcome.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
			
		}else if(pathInfo.equals("/moviedisplay")) {
			System.out.println("Going to listmovies.jsp");
			destination = "/WEB-INF/JSP/listmovies.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
			
		}
		else if(pathInfo.equals("/moviebooking")) {
			System.out.println("Going to bookingtickets.jsp");
			destination = "/WEB-INF/JSP/bookingtickets.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
			
		}
		else if(pathInfo.equals("/Confirmation")) {
			System.out.println("Going to confirment.jsp");
			destination = "/WEB-INF/JSP/confirment.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
			
		}
		else {
			System.out.println("Going to exit.jsp");
			destination = "/WEB-INF/JSP/exit.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
			dispatcher.forward(request, response);
		}
		
				
		String b = request.getParameter("dept");
		System.out.println(b);
		//You can also connect to DB, save the value of dept in a table.
		String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschemas";
        String username = "root";
        String password = "root";
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Insert data using a prepared statement
            String insertQuery = "INSERT INTO USER VALUES(?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, b);
            
            int rowsInserted = insertStatement.executeUpdate();
            System.out.println(rowsInserted + " row(s) inserted.");

            // Select data using a prepared statement
            String QUERY = "select dept from sample_tbl";
            Statement stmt = connection.createStatement();
            
            ResultSet rs = stmt.executeQuery(QUERY);
            ArrayList<String> departmentArrayList = new ArrayList<>();
            while (rs.next()) {
            	String v = rs.getString("dept");
                //if (!"ece".equalsIgnoreCase(v)) {

   	            departmentArrayList.add(v);
                }
            //}
          
            request.setAttribute("deptList", departmentArrayList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		String name = "john";
		request.setAttribute("name", name);
		dispatcher.forward(request, response);

 }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//String User_id = request.getParameter("userid");
			doGet(request, response);
			} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

}