package com.flights.model;



public class Booking {
	    private Client client;
	    private Flight flight;
	    private Aircraft aircraft;
	    private AircraftSeat aircraftSeat;
	    private int booking_id;
	    
		public Client getClient() {
			return client;
		}
		public void setClient(Client client) {
			this.client = client;
		}
		public Flight getFlight() {
			return flight;
		}
		public void setFlight(Flight flight) {
			this.flight = flight;
		}
		public Aircraft getAircraft() {
			return aircraft;
		}
		public void setAircraft(Aircraft aircraft) {
			this.aircraft = aircraft;
		}
		public AircraftSeat getAircraftSeat() {
			return aircraftSeat;
		}
		public void setAircraftSeat(AircraftSeat aircraftSeat) {
			this.aircraftSeat = aircraftSeat;
		}
		public int getBooking_id() {
			return booking_id;
		}
		public void setBooking_id(int booking_id) {
			this.booking_id = booking_id;
		}
	    
	    
	    
}
