package com.flights.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "travelclass")
public class TravelClassEntity {

    @Id
    @Column(name = "travel_class_id")
    private int travelClassId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

	public int getTravelClassId() {
		return travelClassId;
	}

	public void setTravelClassId(int travelClassId) {
		this.travelClassId = travelClassId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}