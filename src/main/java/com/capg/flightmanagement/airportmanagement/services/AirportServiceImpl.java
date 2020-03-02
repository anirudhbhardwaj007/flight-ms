package com.capg.flightmanagement.airportmanagement.services;
import java.util.*;

import com.capg.flightmanagement.airportmanagement.dao.IAirportDao;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.airportmanagement.util.Validation;

public class AirportServiceImpl implements IAirportService {
	private IAirportDao dao;
	public AirportServiceImpl(IAirportDao dao) {
		this.dao=dao;
	}
	
	//returns list of all the airport present.
	@Override
	public List<Airport> viewAirport() {
		List<Airport> airportView=dao.viewAirport();
		return airportView;
	}

	//returns airport name on the basis of airport code.
	@Override
	public String viewAirport(String airportCode) {
		Validation.validateCode(airportCode);
		String airportDetails=dao.viewAirport(airportCode);
		return airportDetails;
	}

}

