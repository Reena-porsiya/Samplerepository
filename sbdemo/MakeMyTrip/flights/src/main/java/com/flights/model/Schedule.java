package com.flights.model;


import java.time.LocalDateTime;


public class Schedule {
	private int scheduleId;
    private LocalDateTime departureTimeGmt;
    private LocalDateTime arrivalTimeGmt;
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
