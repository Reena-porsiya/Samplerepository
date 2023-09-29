

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
</head>
<body>
<h1>Movies</h1>
<c:forEach var="movie" items="${listmovies}">
    <a href="/ServletProjects/MovieBookingServlet/moviebookings?movieId=_<c:out value='${movie.movie_id}'/>"><c:out value = '${movie.movie_id }'/></a>
    <c:out value = '${movie.movie_name }'/>
    <c:out value = '${movie.date_time}'/>
    <c:out value = '${movie.desc }'/>
    <c:out value = '${movie.movie_price }'/>
    
    <br>
    </c:forEach>
</body>
</html>



