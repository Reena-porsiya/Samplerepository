package com.flights.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.flights.model.Direction;

@Entity
@Table(name = "schedules")
public class ScheduleEntity {

    @Id
    @Column(name = "schedule_id")
    private int scheduleId;

    @Column(name = "departure_time_gmt")
    private LocalDateTime departureTimeGmt;

    @Column(name = "arrival_time_gmt")
    private LocalDateTime arrivalTimeGmt;

    @ManyToOne
    @JoinColumn(name = "iata_airport_code")
    private Direction direction;

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public LocalDateTime getDepartureTimeGmt() {
		return departureTimeGmt;
	}

	public void setDepartureTimeGmt(LocalDateTime departureTimeGmt) {
		this.departureTimeGmt = departureTimeGmt;
	}

	public LocalDateTime getArrivalTimeGmt() {
		return arrivalTimeGmt;
	}

	public void setArrivalTimeGmt(LocalDateTime arrivalTimeGmt) {
		this.arrivalTimeGmt = arrivalTimeGmt;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
    
}