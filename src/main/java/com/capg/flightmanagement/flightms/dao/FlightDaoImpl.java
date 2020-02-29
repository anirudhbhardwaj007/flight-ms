package com.capg.flightmanagement.flightms.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.exceptions.FlightNotExistException;
import com.capg.flightmanagement.flightms.exceptions.FlightNotFoundException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightNumberException;

public class FlightDaoImpl implements IFlightDao {
	public static List<Flight> flightList = new ArrayList<>();

	@Override
	public Flight addFlight(Flight flight) {
		if (flightList.contains(flight)) {
			// throw new FlightAlreadyExistException("Flight already Exist");
		}
		flightList.add(flight);
		return flight;
	}

	@Override
	public Flight modiyFlight(Flight flight) {
		if (!(flightList.contains(flight))) {
			throw new FlightNotExistException("Flight Not Exist");
		}
		for (Flight tempFlight : flightList) {
			if (tempFlight.equals(flight)) {
				tempFlight.setCarrierName(flight.getCarrierName());
				tempFlight.setFlightModel(flight.getFlightModel());
				tempFlight.setSeatCapacity(flight.getSeatCapacity());
			}
		}
		return flight;
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		for (Flight flight : flightList) {
			BigInteger flightNum = flight.getFlightNumber();
			if (flightNum.equals(flightNumber)) {
				return flight;
			}
		}
		throw new FlightNotFoundException("FlightNotFoundException");
	}

	@Override
	public List<Flight> viewFlight() {
		return flightList;
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		Iterator<Flight> flightListIterator = flightList.iterator();
		while (flightListIterator.hasNext()) {
			Flight flight = flightListIterator.next();
			BigInteger flightNum = flight.getFlightNumber();
			if (flightNum.equals(flightNumber)) {
				flightListIterator.remove();
				return;
			}
		}
		throw new FlightNotFoundException("FlightNotFoundException");
	}

}
