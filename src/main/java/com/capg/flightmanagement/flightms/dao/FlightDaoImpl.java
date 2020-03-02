package flightms.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.flightmanagement.flightms.dao.IFlightDao;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.exceptions.FlightAlreadyExistException;
import com.capg.flightmanagement.flightms.exceptions.FlightNotExistException;
import com.capg.flightmanagement.flightms.exceptions.FlightNotFoundException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightNumberException;

public class FlightDaoImpl implements IFlightDao {
	public static List<Flight> flightList = new ArrayList<>(); // declare arrayList to store all flights

	@Override
	public Flight addFlight(Flight flight) {
		if (flightList.contains(flight)) { // if flight already exist then throw an exception
			throw new FlightAlreadyExistException("Flight already Exist");
		}
		flightList.add(flight); // else add flight in list
		return flight;
	}

	@Override
	public Flight modiyFlight(Flight flight) {
		if (!(flightList.contains(flight))) {
			throw new FlightNotExistException("Flight Not Exist"); // if flight not exist in list then throw exception
		}
		for (Flight tempFlight : flightList) { // iterate element of list and check for the flight
			if (tempFlight.equals(flight)) {
				tempFlight.setCarrierName(flight.getCarrierName());// Modifying carrier name
				tempFlight.setFlightModel(flight.getFlightModel());// Modifying flight model
				tempFlight.setSeatCapacity(flight.getSeatCapacity());// Modifying seat capacity
			}
		}
		return flight;
	}

	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		for (Flight flight : flightList) { // iterate element of list and check for the flight
			BigInteger flightNum = flight.getFlightNumber(); // get the flight number of element of list
			if (flightNum.equals(flightNumber)) { // check the equality of flight number
				return flight;
			}
		}
		throw new FlightNotFoundException("FlightNotFoundException"); // throw exception if flight not found
	}

	@Override
	public List<Flight> viewFlight() {
		return flightList; // return list of all flight
	}

	@Override
	public void deleteFlight(BigInteger flightNumber) {
		Iterator<Flight> flightListIterator = flightList.iterator(); // declare iterator of list of all flight
		while (flightListIterator.hasNext()) {
			Flight flight = flightListIterator.next(); // get element throw iterator
			BigInteger flightNum = flight.getFlightNumber(); // get the flight number of that element
			if (flightNum.equals(flightNumber)) { // check equality of flight number
				flightListIterator.remove(); // remove element of list through iterator
				return;
			}
		}
		throw new FlightNotFoundException("FlightNotFoundException"); // throw exception if flight not found
	}

}
