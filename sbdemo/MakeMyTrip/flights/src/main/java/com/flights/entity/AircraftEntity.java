package com.flights.entity;

import com.flights.model.AircraftManufacturer;

import jakarta.persistence.*;

@Entity
@Table(name = "aircraft")
public class AircraftEntity {
    @Id
    private int aircraft_Id;
    
    @OneToOne
    @JoinColumn(name = "aircraft_manufacturer_id")
    private AircraftManufacturer aircraftManufacturer;
    
    private String model;
    
    public int getAircraftId() {
        return aircraft_Id;
    }

    public void setAircraftId(int aircraftId) {
        this.aircraft_Id = aircraftId;
    }

    public AircraftManufacturer getAircraftManufacturer() {
        return aircraftManufacturer;
    }

    public void setAircraftManufacturer(AircraftManufacturer aircraftManufacturer) {
        this.aircraftManufacturer = aircraftManufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    
}



