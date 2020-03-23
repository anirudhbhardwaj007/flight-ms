package com.capg.flightmanagement.airportmanagement.services.test;

import java.util.List;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import com.capg.flightmanagement.airportmanagement.dao.AirportDaoImpl;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.exceptions.AirportExistsException;
import com.capg.flightmanagement.exceptions.AirportNotFoundException;
import com.capg.flightmanagement.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.airportmanagement.services.AirportServiceImpl;

public class AirportServiceImplTest {
	AirportServiceImpl service;

	@BeforeEach
	public void setup() {
		System.out.println("Inside Setup!");
		service = new AirportServiceImpl(new AirportDaoImpl());
	}

	@AfterEach
	public void clear() {
		System.out.println("Inside Clear!");
		AirportDaoImpl.airPortList.clear();
	}

	@Test
	public void test_viewAirport2() {
		String airPortName = "Bhopal Air";
		String airPortCode = "5";
		Airport airport = new Airport("Bhopal Air", "A101", "Bhopal");
		List<Airport> list = AirportDaoImpl.airPortList;
		list.add(airport);
		String name = service.viewAirport(airPortCode);
		if (name.equals(airPortName) == false) {
			throw new AirportNotFoundException("Airport not found");
		}
		Assertions.assertNotEquals(name, airPortName);
	}

	// When airport code is not obtained.
	@Test
	public void test_viewAirport() {
		Executable executable = new Executable() {
			@Override
			public void execute() throws Throwable {
				service.viewAirport(null);
			}
		};
		Assertions.assertThrows(IncorrectArgumentException.class, executable);
	}

	@Test
	public void test_viewAirport3() {
		String airPortName = "Bhopal Air";
		String airPortCode = "bpl";
		Airport airport = new Airport("Bhopal Air", "bpl", "Bhopal");
		List<Airport> list = AirportDaoImpl.airPortList;
		list.add(airport);
		String name = service.viewAirport(airPortCode);
		Assertions.assertEquals(name, airPortName);
	}
	
	@Test
	public void test_addAirport() {
		Airport airport = new Airport("Bhopal Air", "bpl", "Bhopal");
		List<Airport> list = AirportDaoImpl.airPortList;
		list.add(airport);
		List<Airport>list2 = service.addAirport(airport);
		if(list.contains(airport)) {
			throw new AirportExistsException("Airport already present");
		}
		Assertions.assertEquals(list, list2);
	}
	
	@Test
	public void test_addAirport2() {
		Airport airport = new Airport("Bhopal Air", "bpl", "Bhopal");
		List<Airport> list = AirportDaoImpl.airPortList;
		list.add(airport);
		List<Airport>list2 = service.addAirport(airport);
		Assertions.assertNotEquals(list, list2);
	}
	
}
