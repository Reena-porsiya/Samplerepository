-- Create Country Table
CREATE TABLE flightsbooking.Country (
    iata_country_code CHAR(2) PRIMARY KEY,
    name VARCHAR(45)
);

-- Insert sample data into Country Table
INSERT INTO flightsbooking.Country (iata_country_code, name)
VALUES
('US', 'United States'),
('CA', 'Canada');

-- Create AircraftManufacturer Table
CREATE TABLE flightsbooking.AircraftManufacturer (
    aircraft_manufacture_id INT PRIMARY KEY,
    name VARCHAR(45)
);

-- Insert sample data into AircraftManufacturer Table
INSERT INTO flightsbooking.AircraftManufacturer (aircraft_manufacture_id, name)
VALUES
(1, 'Boeing'),
(2, 'Airbus');

-- Create Airport Table
CREATE TABLE flightsbooking.Airport (
    iata_airport_code CHAR(3) PRIMARY KEY,
    name VARCHAR(45),
    city VARCHAR(45),
    iata_country_code CHAR(2),
    FOREIGN KEY (iata_country_code) REFERENCES Country(iata_country_code)
);

-- Insert sample data into Airport Table
INSERT INTO flightsbooking.Airport (iata_airport_code, name, city, iata_country_code)
VALUES
('JFK', 'John F. Kennedy International Airport', 'New York', 'US'),
('LAX', 'Los Angeles International Airport', 'Los Angeles', 'US'),
('YYZ', 'Toronto Pearson International Airport', 'Toronto', 'CA');

-- Create Direction Table
CREATE TABLE flightsbooking.Direction (
    origin_iata_airport_code CHAR(3),
    dest_iata_airport_code CHAR(3),
    PRIMARY KEY (origin_iata_airport_code, dest_iata_airport_code),
    FOREIGN KEY (origin_iata_airport_code) REFERENCES Airport(iata_airport_code),
    FOREIGN KEY (dest_iata_airport_code) REFERENCES Airport(iata_airport_code)
);

-- Insert sample data into Direction Table
INSERT INTO flightsbooking.Direction (origin_iata_airport_code, dest_iata_airport_code)
VALUES
('JFK', 'LAX'),
('LAX', 'JFK');

-- Create FlightStatus Table
CREATE TABLE flightsbooking.FlightStatus (
    flight_status_id INT PRIMARY KEY,
    name VARCHAR(45)
);

-- Insert sample data into FlightStatus Table
INSERT INTO flightsbooking.FlightStatus (flight_status_id, name)
VALUES
(1, 'On Time'),
(2, 'Delayed');

-- Create TravelClass Table
CREATE TABLE flightsbooking.TravelClass (
    travel_class_id INT PRIMARY KEY,
    name VARCHAR(45),
    description TEXT
);

-- Insert sample data into TravelClass Table
INSERT INTO flightsbooking.TravelClass (travel_class_id, name, description)
VALUES
(1, 'Economy', 'Standard seating and services'),
(2, 'Business', 'Premium seating and services');

-- Create Aircraft Table
CREATE TABLE flightsbooking.Aircraft (
    aircraft_id INT PRIMARY KEY,
    aircraft_manufacture_id INT,
    model VARCHAR(45),
    FOREIGN KEY (aircraft_manufacture_id) REFERENCES AircraftManufacturer(aircraft_manufacture_id)
);

-- Insert sample data into Aircraft Table
INSERT INTO flightsbooking.Aircraft (aircraft_id, aircraft_manufacture_id, model)
VALUES
(201, 1, 'Boeing 737'),
(202, 2, 'Airbus A320');

-- Create AircraftInstance Table
CREATE TABLE flightsbooking.AircraftInstance (
    aircraft_instance_id INT PRIMARY KEY,
    aircraft_id INT,
    FOREIGN KEY (aircraft_id) REFERENCES Aircraft(aircraft_id)
     
    
);

-- Insert sample data into AircraftInstance Table
INSERT INTO flightsbooking.AircraftInstance (aircraft_instance_id, aircraft_id)
VALUES
(501, 201),
(502, 202);

-- Create FlightAircraftInstance Table
CREATE TABLE flightsbooking.FlightAircraftInstance (
    flight_call INT ,
    aircraft_instance_id INT ,
    FOREIGN KEY (aircraft_instance_id) REFERENCES AircraftInstance(aircraft_instance_id),
	FOREIGN KEY (flight_call) REFERENCES Flight(flight_call)
);

-- Insert sample data into FlightAircraftInstance Table
INSERT INTO flightsbooking.FlightAircraftInstance (flight_call, aircraft_instance_id)
VALUES
(101, 501),
(102, 502);

-- Create Schedule Table
CREATE TABLE flightsbooking.Schedules (
    schedule_id INT PRIMARY KEY,
    origin_iata_airport_code CHAR(3),
    dest_iata_airport_code CHAR(3),
    departure_time_gmt TIMESTAMP,
    arrival_time_gmt TIMESTAMP,
    FOREIGN KEY (origin_iata_airport_code) REFERENCES Airport(iata_airport_code),
    FOREIGN KEY (dest_iata_airport_code) REFERENCES Airport(iata_airport_code)
);

-- Insert sample data into Schedule Table
INSERT INTO flightsbooking.Schedules (schedule_id, origin_iata_airport_code, dest_iata_airport_code, departure_time_gmt, arrival_time_gmt)
VALUES
(301, 'JFK', 'LAX', '2023-09-30 10:00:00', '2023-09-30 13:00:00'),
(302, 'LAX', 'JFK', '2023-10-01 12:00:00', '2023-10-01 15:00:00');

-- Create Flight Table
CREATE TABLE flightsbooking.Flight (
    flight_call INT PRIMARY KEY,
    schedule_id INT,
    flight_status_id INT,
    FOREIGN KEY (schedule_id) REFERENCES Schedules(schedule_id),
    FOREIGN KEY (flight_status_id) REFERENCES FlightStatus(flight_status_id)
);

-- Insert sample data into Flight Table
INSERT INTO flightsbooking.Flight (flight_call, schedule_id, flight_status_id)
VALUES
(101, 301, 1),
(102, 302, 2);

-- Create Client Table
CREATE TABLE flightsbooking.Clients (
    client_id INT PRIMARY KEY,
    first_name VARCHAR(45),
    middle_name VARCHAR(45),
    last_name VARCHAR(45),
    phone VARCHAR(45),
    email VARCHAR(45),
    passport VARCHAR(45),
    iata_country_code CHAR(2)
);

-- Insert sample data into Client Table
INSERT INTO flightsbooking.Clients (client_id, first_name, middle_name, last_name, phone, email, passport, iata_country_code)
VALUES
(1, 'John', 'A', 'Doe', '+123456789', 'john.doe@email.com', 'AB123456', 'US'),
(2, 'Jane', '', 'Smith', '+987654321', 'jane.smith@email.com', 'CD789012', 'CA');

-- Create Booking Table
CREATE TABLE flightsbooking.Bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    client_id INT,
    flight_call INT,
    aircraft_id INT,
    seat_id INT,
    FOREIGN KEY (client_id) REFERENCES Clients(client_id),
    FOREIGN KEY (flight_call) REFERENCES Flight(flight_call),
    FOREIGN KEY (aircraft_id) REFERENCES Aircraft(aircraft_id)
    
);

-- Insert sample data into Booking Table
-- Assume client_id, flight_call, aircraft_id, and seat_id are valid IDs from other tables
INSERT INTO flightsbooking.Bookings (client_id, flight_call, aircraft_id, seat_id)
VALUES
(1, 101, 201, 301),
(2, 102, 202, 302);

-- Create AircraftSeat Table
CREATE TABLE flightsbooking.AircraftSeat (
    seat_id INT PRIMARY KEY,
    aircraft_id INT,
    travel_class_id INT,
    FOREIGN KEY (aircraft_id) REFERENCES Aircraft(aircraft_id),
    FOREIGN KEY (travel_class_id) REFERENCES TravelClass(travel_class_id)
);


-- Insert data into AircraftSeat table
INSERT INTO flightsbooking.AircraftSeat (aircraft_id, seat_id, travel_class_id)
VALUES
    (1, 1, 1),
    (2, 1, 2);
    
    CREATE TABLE FlightSeatPrice (
    flight_call INT,
    aircraft_id INT,
    seat_id INT,
    price_used DOUBLE,
    PRIMARY KEY (flight_call, aircraft_id, seat_id),
    FOREIGN KEY (flight_call) REFERENCES Flight(flight_call),
    FOREIGN KEY (aircraft_id) REFERENCES Aircraft(aircraft_id),
    FOREIGN KEY (seat_id) REFERENCES AircraftSeat(seat_id)
);
-- Insert data into FlightSeatPrice table
INSERT INTO flightsbooking.FlightSeatPrice (flight_call, aircraft_id, seat_id, price_used)
VALUES
    (101, 1, 1, 150.00),
    (101, 1, 2, 120.00);
    
    -- Create Payment table
CREATE TABLE flightsbooking.Payment (
    payment_id INT PRIMARY KEY,
    client_id INT,
    booking_id INT,
    amount DECIMAL(10, 2) NOT NULL,
    payment_date DATE NOT NULL,
    FOREIGN KEY (client_id) REFERENCES Clients(client_id),
    FOREIGN KEY (booking_id) REFERENCES Bookings(client_id)
);

-- Insert data into Payment table
INSERT INTO flightsbooking.Payment (payment_id, client_id, booking_id, amount, payment_date)
VALUES
    (1, 1, 101, 100.00, '2023-09-27'),
    (2, 2, 102, 150.50, '2023-09-28');
    
    -- Create FlightSeatPrice table
CREATE TABLE flightsbooking.FlightSeatPrice (
    flight_call INT,
    aircraft_id INT,
    seat_id INT,
    price_used DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (flight_call, aircraft_id, seat_id),
    FOREIGN KEY (flight_call) REFERENCES Flight(flight_call),
    FOREIGN KEY (aircraft_id, seat_id) REFERENCES AircraftSeat(aircraft_id, seat_id)
);

-- Insert data into FlightSeatPrice table
INSERT INTO flightsbooking.FlightSeatPrice (flight_call, aircraft_id, seat_id, price_used)
VALUES
    (101, 1, 1, 150.00),
    (101, 1, 2, 120.00);
