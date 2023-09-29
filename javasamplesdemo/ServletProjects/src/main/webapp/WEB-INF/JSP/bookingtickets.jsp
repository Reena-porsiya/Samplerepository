<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Booking</title>
</head>
<body>
    <h1>Booking</h1>
    <form action="/ServletProjects/MovieBookingServlet/Confirmation" method="post">
        <input type="hidden" name="movie_id" value="${movieId}">
        <h2>${movie.movie_name}</h2>
        <p>Date: ${movie.date_time}</p>
        <p>Description: ${movie.desc}</p>
        <p>Price: ${movie.movie_price}</p>
        
        <label for="booking_seats">Number of Seats:</label>
        <input type="text" name="booking_seats" required><br>
        
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
