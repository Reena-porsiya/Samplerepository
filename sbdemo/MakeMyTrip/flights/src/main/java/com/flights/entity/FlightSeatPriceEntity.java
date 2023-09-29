package com.flights.entity;

import com.flights.model.Aircraft;
import com.flights.model.AircraftSeat;
import com.flights.model.Flight;

import jakarta.persistence.*;

@Entity
@Table(name = "flightseatprices")
public class FlightSeatPriceEntity {

    @Id

    @Column(name = "price_used")
    private double priceUsed;

    @ManyToOne
    @JoinColumn(name = "flight_call")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "aircraft_seat_id")
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