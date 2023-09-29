package servletdemo;

public class SignUpBusiness {
	public void doSignUp(String userid, String firstname, String lastname, String password) {
		String userId = userid;
		String firstName = firstname;
		String lastName = lastname;
		String passWord = password;
		
		SignUpDAO dao = new SignUpDAO();
		dao.saveSignUp(userId, firstName, lastName, password);
		
		
	}

	public static void main(String[] args) {
		
		
		}
		// TODO Auto-generated method stub




	
		
	}

