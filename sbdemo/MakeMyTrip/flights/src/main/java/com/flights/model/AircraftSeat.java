package com.flights.model;



public class AircraftSeat {
	
	private Aircraft aircraft;
    private int seatId;
    private TravelClass travelclass;
    
	public Aircraft getAircraft() {
		return aircraft;
	}
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	public int getSeatId() {
		return seatId;
	}
	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	public TravelClass getTravelclass() {
		return travelclass;
	}
	public void setTravelclass(TravelClass travelclass) {
		this.travelclass = travelclass;
	}
    
 }
