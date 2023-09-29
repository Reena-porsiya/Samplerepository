package com.flights.entity;

import com.flights.model.AircraftInstance;
import com.flights.model.Flight;

import jakarta.persistence.*;

@Entity
@Table(name = "flightaircraftinstances")
public class FlightAircraftInstanceEntity {

    @Id
    
    @ManyToOne
    @JoinColumn(name = "flight_call")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "aircraft_instance_id")
    private AircraftInstance aircraftInstance;

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public AircraftInstance getAircraftInstance() {
		return aircraftInstance;
	}

	public void setAircraftInstance(AircraftInstance aircraftInstance) {
		this.aircraftInstance = aircraftInstance;
	} 
    
}
