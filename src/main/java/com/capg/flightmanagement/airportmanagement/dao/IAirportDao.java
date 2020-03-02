package airportmanagement.dao;
import java.util.*;

import com.capg.flightmanagement.airportmanagement.entities.Airport;


public interface IAirportDao {
	public List<Airport> viewAirport();
	public String viewAirport(String airportCode);
	
}
