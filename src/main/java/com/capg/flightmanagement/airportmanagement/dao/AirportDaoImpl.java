package com.capg.flightmanagement.airportmanagement.dao;
import java.util.*;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.exceptions.AirportExistsException;
import com.capg.flightmanagement.exceptions.IncorrectArgumentException;
public class AirportDaoImpl implements IAirportDao {

	public static List<Airport>airPortList = new ArrayList<Airport>();
	
	//returns list of all the airport present.
	@Override
	public List<Airport> viewAirport() {
		List<Airport>list = new ArrayList<>();
		for(int i=0;i<airPortList.size();i++) {
		list.add(airPortList.get(i));
		
	}
		return list;
	}

	//returns airport name on the basis of airport code.
	@Override
	public String viewAirport(String airportCode) {
		String airPortName = null;
		for(Airport airport:airPortList) {
			if(airport.getAirportCode().equals(airportCode)) {
				airPortName=airport.getAirportName();
			}
		}
		if(airportCode==null) {
			throw new IncorrectArgumentException("Airport Code Should not be Null!");
		}
		return airPortName;
	}

	@Override
	public List<Airport> addAirport(Airport airport) {
		for(int i=0,limit=airPortList.size();i<limit;i++){
			Airport airport1 = airPortList.get(i);
			if(airport1.getAirportCode().equals(airport.getAirportCode())){
				throw new AirportExistsException("Airport Already Exist");
			}
			airPortList.add(airport);
		}
		return  airPortList;
	}

}

