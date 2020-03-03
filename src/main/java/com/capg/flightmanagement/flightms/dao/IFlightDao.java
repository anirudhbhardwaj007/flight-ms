package com.capg.flightmanagement.flightms.dao;

import java.math.BigInteger;
import java.util.List;

import com.capg.flightmanagement.flightms.entities.Flight;

public interface IFlightDao {
	public Flight addFlight(Flight flight);

	public Flight modiyFlight(Flight flight);

	public Flight viewFlight(BigInteger flightNumber);

	public List<Flight> viewFlight();

	public void deleteFlight(BigInteger flightNumber);
}
