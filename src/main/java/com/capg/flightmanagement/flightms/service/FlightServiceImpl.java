package com.capg.flightmanagement.flightms.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.flightms.dao.IFlightDao;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightNumberException;
import com.capg.flightmanagement.flightms.util.FlightValidation;

public class FlightServiceImpl implements IFlightService {

	private IFlightDao dao; // declare Data Access Object

	public FlightServiceImpl(IFlightDao dao) { 
		this.dao = dao; // initialize Data Access Object
	}
	/***
	 * @param reference of flight
	 * 	throw exception if flight is null
	 * @return return the object of flight after adding flight in the list
	 */
	@Override
	public Flight addFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		return dao.addFlight(flight);
	}
	/***
	 * @param reference of flight
	 * throw exception if flight is null
	 * @return return the object of flight after modifying flight in the list
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		return dao.modiyFlight(flight);
	}
	/***
	 * @param reference of flightNumber
	 * throw exception if flight number is null
	 * @return return the object of flight after fetching flight from the list
	 */
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		if (flightNumber == null) {
			throw new InvalidFlightNumberException("Flight Number is invalid");
		}
		return dao.viewFlight(flightNumber);
	}
	/***
	 * @param void
	 * 
	 * @return return the list of all flight
	 */
	@Override
	public List<Flight> viewFlight() {
		return dao.viewFlight();
	}
	/***
	 * @param flightNumber as BigInteger
	 * throw exception if flight number is null
	 * else delete flight from list
	 * @return return void
	 */
	@Override
	public void deleteFlight(BigInteger flightNumber) {
		if (flightNumber == null) {
			throw new InvalidFlightNumberException("Flight Number is invalid"); 
		}
		dao.deleteFlight(flightNumber);
	}
	/***
	 * @param reference of flight
	 * 	validate flight
	 * @return return void
	 */
	@Override
	public void validateFlight(Flight flight) {
		FlightValidation.validateFlight(flight);
	}

}
