package com.capg.flightmanagement.airportmanagement.services.test;
import java.util.List;

import org.junit.jupiter.api.*;	
import org.junit.jupiter.api.function.Executable;

import com.capg.flightmanagement.airportmanagement.dao.AirportDaoImpl;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.exceptions.InvalidArgumentException;
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
	
	//When airport code is obtained.
	@Test
	public void test_viewAirport() {
		String airPortName="Bhopal Air";
		String airPortCode="A101";
		Airport airport = new Airport("Bhopal Air", "A101", "Bhopal");
		List<Airport>list = AirportDaoImpl.airPortList;
		list.add(airport);
		String name = service.viewAirport(airPortCode);
		Assertions.assertEquals(name,airPortName);
	}
	
	//When airport code is not obtained.
	@Test
	public void test_viewAirport1() {
			Executable executable = new Executable() {
				@Override
				public void execute()throws Throwable {
					service.viewAirport(null);
				}
			};
			Assertions.assertThrows(InvalidArgumentException.class ,executable);
		}
	}


