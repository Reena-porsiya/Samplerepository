<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>List With Iteration :</h3>
	<ul>
<!-- use c:if tag to filter ece -->
	
		<c:forEach var="deptname" items="${deptList}">
		<c:if test="${!deptname.equalsIgnoreCase('ece')}">
			<li>${deptname}</li>
			</c:if>
		</c:forEach>

	</ul>

</body>
</html>