package servletdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet/*")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String pathInfo = request.getPathInfo();
		 if (pathInfo.equals("/SignUp")) {
	     String destination = "/WEB-INF/JSP/welcome.jsp";
	     System.out.println("Going to welcome.jsp");
	    /* RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
	     dispatcher.forward(request, response);*/
		 }
		
		String userid = request.getParameter("user_id");
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String password = request.getParameter("password");
		
	    SignUpBusiness obj = new SignUpBusiness();
	    obj.doSignUp(userid,firstname,lastname,password);
	    
	   // RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
	   // dispatcher.forward(request, response);
        
        response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
