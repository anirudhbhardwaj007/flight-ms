package com.capg.flightmanagement.util;

import com.capg.flightmanagement.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.exceptions.InvalidFlightModelException;
import com.capg.flightmanagement.exceptions.InvalidFlightNumberException;
import com.capg.flightmanagement.exceptions.InvalidSeatCapacityException;
import com.capg.flightmanagement.flightms.entities.Flight;



public class FlightValidation {
	public static void validateFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Flight Is Null");// throw exception if flight is null
		}
		if ((flight.getFlightNumber() == null) || (flight.toString().length() != 12)) {
			throw new InvalidFlightNumberException("FlightNumber is Invalid");// throw exception if flight number is
																				// null or flight number is not equal to
																				// 12
		}
		if (flight.getFlightModel() == null) {
			throw new InvalidFlightModelException("Flight Model is Invalid");// throw exception if flight model is null
		}
		if (flight.getSeatCapacity() < 0) {
			throw new InvalidSeatCapacityException("Invalid Seat Capacity");// throw exception if seat capacity is
																			// negative
		}
	}
}
