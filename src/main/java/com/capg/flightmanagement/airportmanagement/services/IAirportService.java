package com.capg.flightmanagement.airportmanagement.services;
import java.util.List;

import com.capg.flightmanagement.airportmanagement.entities.Airport;

public interface IAirportService{
	public List<Airport> viewAirport();
	public String viewAirport(String airportCode);
}
