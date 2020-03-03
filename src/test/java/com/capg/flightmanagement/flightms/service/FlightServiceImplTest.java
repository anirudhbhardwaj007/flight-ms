package com.capg.flightmanagement.flightms.service;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import com.capg.flightmanagement.exceptions.FlightAlreadyExistException;
import com.capg.flightmanagement.exceptions.FlightNotExistException;
import com.capg.flightmanagement.exceptions.FlightNotFoundException;
import com.capg.flightmanagement.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.exceptions.InvalidFlightNumberException;
import com.capg.flightmanagement.flightms.dao.FlightDaoImpl;
import com.capg.flightmanagement.flightms.entities.Flight;


public class FlightServiceImplTest {
	private FlightServiceImpl service; // declare service variable

	@BeforeEach // run before every test case
	public void setup() {
		service = new FlightServiceImpl(new FlightDaoImpl()); // Initialize service object
	}

	@AfterEach // run after every test case
	public void clear() {
		FlightDaoImpl.flightList.clear(); // remove all the elements in list
	}

	@Test
	public void testAddFlight_1() {
		Flight flight = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150); // creating object of flight
		Flight result = service.addFlight(flight); // call addFlight method of flight service class
		Assertions.assertEquals(flight.getFlightNumber(), result.getFlightNumber()); // check if the added flight has
																						// same flight number as
																						// expected
		Assertions.assertEquals(flight.getSeatCapacity(), result.getSeatCapacity());// check if the added flight has
																					// same flight capacity as expected
		Assertions.assertEquals(flight.getFlightModel(), result.getFlightModel());// check if the added flight has same
																					// flight model as expected
		Assertions.assertEquals(flight.getCarrierName(), result.getCarrierName());// check if the added flight has same
																					// flight carrier name as expected
	}

	@Test
	public void testAddFlight_2() {
		Executable executable = () -> service.addFlight(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable);// check if invalid argument exception
																			// thrown if null is passed in addFlight
																			// method
	}

	@Test
	public void testAddFlight_3() {
		Flight spiceJet = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150);// creating object of flight
		List<Flight> flightList = FlightDaoImpl.flightList; // get list of flight from Data Access Object Class
		flightList.add(spiceJet); // add Flight in list
		Flight Indigo = new Flight(new BigInteger("101"), "Spice Jet", "Boing101", 150);// creating object of flight
		Executable executable = () -> service.addFlight(Indigo);
		Assertions.assertThrows(FlightAlreadyExistException.class, executable);// check if flight already exist
																				// exception is thrown if flight already
																				// exist in list
	}

	@Test
	public void testModifyFlight_1() {
		Flight flight = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150);// creating object of flight
		List<Flight> flightList = FlightDaoImpl.flightList;// get list of flight from Data Access Object Class
		flightList.add(flight); // add Flight in list
		Flight modifyFlight = new Flight(new BigInteger("101"), "Spice Jet", "Boing101", 150);// creating object of
																								// flight
		Flight result = service.modifyFlight(modifyFlight); // call modifyFlight method of service class
		Assertions.assertEquals(flight.getFlightNumber(), result.getFlightNumber());// check if modified flight has same
																					// flight number as expected
		Assertions.assertEquals(flight.getSeatCapacity(), result.getSeatCapacity());// check if the modified flight has
																					// same flight capacity as expected
		Assertions.assertEquals(flight.getFlightModel(), result.getFlightModel());// check if the modified flight has
																					// same flight model as expected
		Assertions.assertEquals(flight.getCarrierName(), result.getCarrierName());// check if the modified flight has
																					// same flight carrier name as
																					// expected
	}

	@Test
	public void testModifyFlight_2() {
		Executable executable = () -> service.modifyFlight(null);
		Assertions.assertThrows(InvalidArgumentException.class, executable); // check if invalid argument exception is
																				// thrown if null is passed in
																				// modifyFlight method
	}

	@Test
	public void testModifyFlight_3() {
		Flight modifyFlight = new Flight(new BigInteger("101"), "Spice Jet", "Boing101", 150);// creating object of
																								// flight
		Executable executable = () -> service.modifyFlight(modifyFlight);
		Assertions.assertThrows(FlightNotExistException.class, executable);// check if flight not exist exception is
																			// thrown if flight not exist in list

	}

	@Test
	public void testViewFlight_1() {
		Executable executable = () -> service.viewFlight(null);
		Assertions.assertThrows(InvalidFlightNumberException.class, executable); // check if invalid flight number
																					// exception is thrown if null is
																					// passed in viewFlight method

	}

	@Test
	public void testViewFlight_2() {
		Flight flight = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150);// creating object of flight
		List<Flight> flightList = FlightDaoImpl.flightList;// get list of flight from Data Access Object Class
		flightList.add(flight);// add Flight in list
		BigInteger flightNumber = flight.getFlightNumber(); // get the flight number
		Flight result = service.viewFlight(flightNumber);
		Assertions.assertEquals(flight, result);// check if fetching flight is equals as expected
	}

	@Test
	public void testViewFlight_3() {
		Flight flight = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150);// creating object of flight
		BigInteger flightNumber = flight.getFlightNumber();// get the flight number
		Executable executable = () -> service.viewFlight(flightNumber);
		Assertions.assertThrows(FlightNotFoundException.class, executable);// check if flight not found exception is
																			// thrown if flight is not exist in list
	}

	@Test
	public void testDeleteFlight_1() {
		Executable executable = () -> service.deleteFlight(null);
		Assertions.assertThrows(InvalidFlightNumberException.class, executable);// check if invalid flight number
																				// exception is thrown if null is passed
																				// in deleteFlight
	}

	@Test
	public void testDeleteFlight_2() {
		Flight flight = new Flight(new BigInteger("101"), "Indigo", "Boing101", 150);// creating object of flight
		List<Flight> flightList = FlightDaoImpl.flightList;// get list of flight from Data Access Object Class
		flightList.add(flight);// add Flight in list
		BigInteger flightNumber = flight.getFlightNumber();// get the flight number
		service.deleteFlight(flightNumber);
		boolean isEmpty = flightList.isEmpty();
		Assertions.assertEquals(true, isEmpty);// check if flight is deleted from list or not

	}
}
