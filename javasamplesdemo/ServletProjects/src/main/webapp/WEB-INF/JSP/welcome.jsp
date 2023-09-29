<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SIGNUP PAGE!!</title>
</head>
<body>
	<h1>WELCOME USER!!</h1>
	<form action = "/ServletProjects//MovieBookingServlet/moviedisplay" method = "post">
	    <label for="user_id">User ID:</label>
		<input type="text"  name="user_id"><br/>

		<label for="first_name">First Name:</label>
		<input type="text"  name="first_name"><br/>

		<label for="last_name">Last Name:</label>
		<input type="text"  name="last_name"><br/>

		<label for="password">Password:</label>
		<input type="password"  name="password"><br/>
	<input type ='submit' value = "SignUp">
	</form>

</body>
</html>