package com.flights.entity;


import com.flights.model.FlightStatus;
import com.flights.model.Schedule;

import jakarta.persistence.*;

@Entity
@Table(name = "flight")
public class FlightEntity {

    @Id

    @Column(name = "flight_call")
    private int flightCall;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "flight_status_id")
    private FlightStatus flightStatus;


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

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}
    
}