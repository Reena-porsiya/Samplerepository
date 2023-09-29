package servletdemo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MovieBookingServlet/*")
public class MovieBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public MovieBookingServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String destination = "/WEB-INF/JSP/welcome.jsp";

        if (pathInfo.equals("/SignUp")) {
            destination = "/WEB-INF/JSP/welcome.jsp";
            System.out.println("Going to welcome.jsp");
    	    RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
    	    dispatcher.forward(request, response);
        }/* else if (pathInfo.equals("/moviedisplay")) {
        	 System.out.println("Going to listmovies.jsp");
  		   destination = "/WEB-INF/JSP/listmovies.jsp";
  		   RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
  		    dispatcher.forward(request, response);
  		 
            // Handle displaying movies, database queries, and listmovies.jsp forwarding
            
        }
        else if (pathInfo.equals("/bookingTickets")) {
       	 System.out.println("Going to bookingtickets.jsp");
 		   destination = "/WEB-INF/JSP/bookingtickets.jsp";
 		   RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
 		    dispatcher.forward(request, response);
        }*/else if (pathInfo.equals("/Confirmation")) {
            // Handle booking confirmation and confirment.jsp forwarding
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
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
      response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/sampleschemas";
            Connection con = DriverManager.getConnection(jdbcUrl, "root", "root");
            String pathInfo = request.getPathInfo();

            if (pathInfo.equals("/moviedisplay")) {
                // Handle inserting user data and forwarding to listmovies.jsp
                String userid = request.getParameter("user_id");
                String firstname = request.getParameter("first_name");
                String lastname = request.getParameter("last_name");
                String password = request.getParameter("password");
                String insertQuery = "insert into user_tbl(user_id, first_name, last_name, password) values(?, ?, ?, ?)";
                PreparedStatement pstmt = con.prepareStatement(insertQuery);

                pstmt.setString(1, userid);
                pstmt.setString(2, firstname);
                pstmt.setString(3, lastname);
                pstmt.setString(4, password);
                pstmt.executeUpdate();

                // Handle fetching movies from the database and forwarding to listmovies.jsp
                String QUERY = "SELECT * FROM movie";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);
                ArrayList<Movie> listmovies = new ArrayList<>();

                while (rs.next()) {
                    // Create Movie objects and populate the list
                    Movie movieobj = new Movie();
                    movieobj.setMovie_name(rs.getString("movie_name"));
                    movieobj.setDate_time(rs.getString("date_time"));
                    movieobj.setDesc(rs.getString("desc"));
                    movieobj.setMovie_id(rs.getString("movie_id"));
                    movieobj.setMovie_price(rs.getString("movie_price"));
                    listmovies.add(movieobj);
                }

               request.setAttribute("listmovies", listmovies);
                String destination = "/WEB-INF/JSP/listmovies.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
                dispatcher.forward(request, response);
            }
            
            else  {
                // Handle inserting user data and forwarding to listmovies.jsp
                String movie_name= request.getParameter("movie_name");
                String date_time = request.getParameter("date_time");
                String desc = request.getParameter("desc");
                String movie_id = request.getParameter("movie_id");
                String movie_price = request.getParameter("movie_price");
                
                String insertQuery = "insert into movie(movie_name, date_time, desc, movie_id,movie_price) values(?, ?, ?, ?,?)";
                PreparedStatement pstmt = con.prepareStatement(insertQuery);

                pstmt.setString(1,movie_name );
                pstmt.setString(2, date_time);
                pstmt.setString(3, desc);
                pstmt.setString(4, movie_id);
                pstmt.setString(5, movie_price);
                
                pstmt.executeUpdate();

                // Handle fetching movies from the database and forwarding to listmovies.jsp
                String bookingQuery = "SELECT * FROM booking_tbl";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(bookingQuery);
                ArrayList<Booking> bookingList = new ArrayList<>();

                while (rs.next()) {
                    // Create Booking objects and populate the list
                    Booking booking = new Booking();
                    booking.setBooking_id(rs.getString("booking_id"));
                    booking.setUser_id(rs.getString("user_id"));
                    booking.setMovie_id(rs.getString("movie_id"));
                    booking.setBooking_seats(rs.getString("booking_seats"));
                    bookingList.add(booking);
                }

                request.setAttribute("bookingList", bookingList);
                String destination = "/WEB-INF/JSP/bookingtickets.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
                dispatcher.forward(request, response);
            }
            
            
            
        } catch (ServletException | IOException e1) {
    		// TODO Auto-generated catch block
    		e1.printStackTrace();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}

    	}


            
