package com.capg.flightmanagement.flightms.service;

import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.flightms.dao.IFlightDao;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightModelException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightNumberException;
import com.capg.flightmanagement.flightms.exceptions.InvalidSeatCapacityException;

public class FlightServiceImpl implements IFlightService {

	private IFlightDao dao;

	public FlightServiceImpl(IFlightDao dao) {
		this.dao = dao;
	}

	@Override
	public Flight addFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		return dao.addFlight(flight);
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		return dao.modiyFlight(flight);
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		if (flightNumber == null) {
			throw new InvalidFlightNumberException("Flight Number is invalid");
		}
		return dao.viewFlight(flightNumber);
	}

	@Override
	public List<Flight> viewFlight() {
		return dao.viewFlight();
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		if (flightNumber == null) {
			throw new InvalidFlightNumberException("Flight Number is invalid");
		}
		dao.deleteFlight(flightNumber);
	}

	@Override
	public void validateFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Flight Is Null");
		}
		if (flight.getFlightNumber() == null) {
			throw new InvalidFlightNumberException("FlightNumber is Invalid");
		}
		if (flight.getFlightModel() == null) {
			throw new InvalidFlightModelException("Flight Model is null");
		}
		if (flight.getSeatCapacity() < 0) {
			throw new InvalidSeatCapacityException("Invalid Seat Capacity");
		}
	}

}
