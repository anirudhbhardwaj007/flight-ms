package com.capg.flightmanagement.airportmanagement.entities;

public class Airport {
	
String airportName;
String airportCode;
String airportLocation;

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((airportCode == null) ? 0 : airportCode.hashCode());
	result = prime * result + ((airportLocation == null) ? 0 : airportLocation.hashCode());
	result = prime * result + ((airportName == null) ? 0 : airportName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	Airport other = (Airport) obj;
	if (airportCode == null) {
		if (other.airportCode != null)
			return false;
	} else if (!airportCode.equals(other.airportCode))
		return false;
	if (airportLocation == null) {
		if (other.airportLocation != null)
			return false;
	} else if (!airportLocation.equals(other.airportLocation))
		return false;
	if (airportName == null) {
		if (other.airportName != null)
			return false;
	} else if (!airportName.equals(other.airportName))
		return false;
	return true;
}

public Airport(String airportName, String airportCode, String airportLocation) {
	super();
	this.airportName = airportName;
	this.airportCode = airportCode;
	this.airportLocation = airportLocation;
}


public String getAirportName() {
	return airportName;
}

public void setAirportName(String airportName) {
	this.airportName = airportName;
}

public String getAirportCode() {
	return airportCode;
}

public void setAirportCode(String airportCode) {
	this.airportCode = airportCode;
}

public String getAirportLocation() {
	return airportLocation;
}

public void setAirportLocation(String airportLocation) {
	this.airportLocation = airportLocation;
}

@Override
public String toString() {
	return "Airport Name :"+airportName+" "+"Airport Location :"+airportLocation+" "+"Airport Code :"+airportLocation;
}

}
