package com.capg.flightmanagement.airportmanagement.services;
import java.util.*;

import com.capg.flightmanagement.airportmanagement.dao.IAirportDao;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.airportmanagement.services.IAirportService;
import com.capg.flightmanagement.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.util.AirportValidation;

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
		AirportValidation.validateCode(airportCode);
		String airportDetails=dao.viewAirport(airportCode);
		return airportDetails;
	}

	@Override
	public List<Airport> addAirport(Airport airport) {
		if(airport==null){
			throw  new IncorrectArgumentException("Airport not found!");
		}
		return dao.addAirport(airport);
	}

}

