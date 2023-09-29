package com.flights.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "aircraftmanufacturer")
public class AircraftManufacturerEntity {

    @Id
    private int aircraft_manufacturer_id; 

    private String name;


	public int getAircraft_manufacturer_id() {
		return aircraft_manufacturer_id;
	}

	public void setAircraft_manufacturer_id(int aircraft_manufacturer_id) {
		this.aircraft_manufacturer_id = aircraft_manufacturer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    
}
