package com.flights.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flightstatus")
public class FlightStatusEntity {

    @Id
    @Column(name = "flight_status_id")
    private int flightStatusId;

    @Column(name = "name")
    private String name;

	public int getFlightStatusId() {
		return flightStatusId;
	}

	public void setFlightStatusId(int flightStatusId) {
		this.flightStatusId = flightStatusId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
}