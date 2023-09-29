package com.flights.model;

public class Aircraft {
	    private int aircraftId;
	    private AircraftManufacturer aircraftManufacturer;
	    private String model; 
	    
		public int getAircraftId() {
			return aircraftId;
		}
		public void setAircraftId(int aircraftId) {
			this.aircraftId = aircraftId;
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
