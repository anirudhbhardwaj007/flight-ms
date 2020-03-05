package com.capg.flightmanagement.airportmanagement.entities;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(getAirportName(), airport.getAirportName()) &&
                Objects.equals(getAirportCode(), airport.getAirportCode()) &&
                Objects.equals(getAirportLocation(), airport.getAirportLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAirportName(), getAirportCode(), getAirportLocation());
    }

    @Override
    public  String toString(){
        return "Aiport Name :"+airportName+" "+"Airport code :"+airportLocation+" "+"Airport Location :"+airportLocation;
    }

}
