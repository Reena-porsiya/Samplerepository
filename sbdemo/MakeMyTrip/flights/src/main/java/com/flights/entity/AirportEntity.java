package com.flights.entity;

import com.flights.model.Country;

import jakarta.persistence.*;



@Entity
@Table(name = "airports")
public class AirportEntity {

    @Id
    private String iataAirportCode;
    private String name;
    private String city;

    @ManyToOne
    @JoinColumn(name = "iata_country_code")
    private Country country;

	
	public String getIataAirportCode() {
		return iataAirportCode;
	}

	public void setIataAirportCode(String iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

   

    
}
