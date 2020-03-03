package com.capg.flightmanagement.airportmanagement.entities;

public class Airport {
    String airportName;
    String airportCode;
    String airportLocation;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportLocation() {
        return airportLocation;
    }

    public void setAirportLocation(String airportLocation) {
        this.airportLocation = airportLocation;
    }

    public Airport(String airportName, String airportCode, String airportLocation) {
        this.airportName = airportName;
        this.airportCode = airportCode;
        this.airportLocation = airportLocation;
    }
}
