package com.flights.model;


public class Flight {
	    private int flightCall;
	  
	    private Schedule schedule;
	    private FlightStatus flightstatus;
	    
	    
	    
		public FlightStatus getFlightstatus() {
			return flightstatus;
		}
		public void setFlightstatus(FlightStatus flightstatus) {
			this.flightstatus = flightstatus;
		}
		public int getFlightCall() {
			return flightCall;
		}
		public void setFlightCall(int flightCall) {
			this.flightCall = flightCall;
		}
		
		public Schedule getSchedule() {
			return schedule;
		}
		public void setSchedule(Schedule schedule) {
			this.schedule = schedule;
		}
	    
	   

}
