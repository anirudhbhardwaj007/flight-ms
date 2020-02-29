package com.capg.flightmanagement.flightms.service;


import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.capg.flightmanagement.flightms.dao.FlightDaoImpl;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.exceptions.FlightNotExistException;
import com.capg.flightmanagement.flightms.exceptions.FlightNotFoundException;
import com.capg.flightmanagement.flightms.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.flightms.exceptions.InvalidFlightNumberException;

public class FlightServiceImplTest {
	private FlightServiceImpl service;

	@BeforeEach
	public void setup() {
		service = new FlightServiceImpl(new FlightDaoImpl());
	}
	@AfterEach
	public void clear() {
		FlightDaoImpl.flightList.clear();
	}
	
	@Test
	public void testAddFlight_1() {
		Flight flight = new Flight(new BigInteger("101"),"Indigo","Boing101",150);
		List<Flight> flightList = FlightDaoImpl.flightList;
		flightList.add(flight);
		Flight result = service.addFlight(flight);
		Assertions.assertEquals(flight.getFlightNumber(), result.getFlightNumber());
		Assertions.assertEquals(flight.getSeatCapacity(),result.getSeatCapacity());
		Assertions.assertEquals(flight.getFlightModel(), result.getFlightModel());
		Assertions.assertEquals(flight.getCarrierName(), result.getCarrierName());
	}
	
	@Test
	public void testAddFlight_2() {
		Executable executable = ()-> service.addFlight(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);
	}
	
	@Test
	public void testModifyFlight_1() {
		Flight flight = new Flight(new BigInteger("101"),"Indigo","Boing101",150);
		List<Flight> flightList = FlightDaoImpl.flightList;
		flightList.add(flight);
		Flight modifyFlight = new Flight(new BigInteger("101"),"Spice Jet","Boing101",150);
		Flight result = service.modifyFlight(modifyFlight);
		Assertions.assertEquals(flight.getFlightNumber(), result.getFlightNumber());
		Assertions.assertEquals(flight.getSeatCapacity(),result.getSeatCapacity());
		Assertions.assertEquals(flight.getFlightModel(), result.getFlightModel());
		Assertions.assertEquals(flight.getCarrierName(), result.getCarrierName());
	}
	
	@Test
	public void testModifyFlight_2() {
		Executable executable = ()-> service.modifyFlight(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);
	}
	
	@Test
	public void testModifyFlight_3() {
		Flight modifyFlight = new Flight(new BigInteger("101"),"Spice Jet","Boing101",150);
		Executable executable = ()-> service.modifyFlight(modifyFlight);
		Assertions.assertThrows(FlightNotExistException.class, executable);
		
	}
	
	@Test
	public void testViewFlight_1() {
		Executable executable = ()-> service.viewFlight(null);
		Assertions.assertThrows(InvalidFlightNumberException.class, executable);
	}
	
	@Test
	public void testViewFlight_2() {
		Flight flight = new Flight(new BigInteger("101"),"Indigo","Boing101",150);
		List<Flight> flightList = FlightDaoImpl.flightList;
		flightList.add(flight);
		BigInteger flightNumber = flight.getFlightNumber();
		Flight result = service.viewFlight(flightNumber);
		Assertions.assertEquals(flight, result);
	}
	
	@Test
	public void testViewFlight_3() {
		Flight flight = new Flight(new BigInteger("101"),"Indigo","Boing101",150);
		BigInteger flightNumber = flight.getFlightNumber();
		Executable executable = ()-> service.viewFlight(flightNumber);
		Assertions.assertThrows(FlightNotFoundException.class, executable);
	}
	
	@Test
	public void testDeleteFlight_1() {
		Executable executable = ()-> service.deleteFlight(null);
		Assertions.assertThrows(InvalidFlightNumberException.class, executable);
	}
	
	@Test
	public void testDeleteFlight_2() {
		Flight flight = new Flight(new BigInteger("101"),"Indigo","Boing101",150);
		List<Flight> flightList = FlightDaoImpl.flightList;
		flightList.add(flight);
		BigInteger flightNumber = flight.getFlightNumber();
		service.deleteFlight(flightNumber);
		boolean isEmpty = flightList.isEmpty();
		Assertions.assertEquals(true, isEmpty);
		
	}
}
