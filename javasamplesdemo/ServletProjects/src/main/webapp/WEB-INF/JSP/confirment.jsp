<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
</head>
<body>
    <h1>Booking Confirmation</h1>
    <p>User ID: <%= request.getAttribute("user_id") %></p>
    <p>Movie ID: <%= request.getAttribute("movie_id") %></p>
    <p>Seats Booked: <%= request.getAttribute("booking_seats") %></p>
    
    <p>Your booking has been confirmed. Enjoy the movie!</p>
</body>
</html>
