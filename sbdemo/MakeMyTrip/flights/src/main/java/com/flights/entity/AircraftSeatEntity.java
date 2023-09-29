package com.flights.entity;

import com.flights.model.Aircraft;
import com.flights.model.TravelClass;

import jakarta.persistence.*;

@Entity
@Table(name = "aircraftseats")
public class AircraftSeatEntity {

    @Id
    @ManyToOne
    private Aircraft aircraft; 
    private int seatId;
    @OneToOne
    private TravelClass travelClass; 

   
   

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

    public TravelClass getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(TravelClass travelClass) {
        this.travelClass = travelClass;
    }
}
