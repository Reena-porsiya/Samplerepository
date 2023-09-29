package com.flights.model;



public class FlightSeatPrice {
	
    private double priceUsed;
    private Flight flight;
    private Aircraft aircraft;
    private AircraftSeat aircraftSeat;
	public double getPriceUsed() {
		return priceUsed;
	}
	public void setPriceUsed(double priceUsed) {
		this.priceUsed = priceUsed;
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
    
    
	
    
}
