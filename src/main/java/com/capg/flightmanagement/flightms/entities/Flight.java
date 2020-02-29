package com.capg.flightmanagement.flightms.entities;

import java.math.BigInteger;

public class Flight {
	private BigInteger flightNumber;
	private String carrierName;
	private String flightModel;
	private int seatCapacity;

	public Flight(BigInteger flightNumber, String carrierName, String flightModel, int seatCapacity) {
		this.flightNumber = flightNumber;
		this.carrierName = carrierName;
		this.flightModel = flightModel;
		this.seatCapacity = seatCapacity;
	}

	public BigInteger getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(BigInteger flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getFlightModel() {
		return flightModel;
	}

	public void setFlightModel(String flightModel) {
		this.flightModel = flightModel;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Flight)) {
			return false;
		}
		Flight flight = (Flight) obj;
		return this.flightNumber.equals(flight.getFlightNumber());
	}

	@Override
	public int hashCode() {
		return flightNumber.hashCode();
	}

	@Override
	public String toString() {
		return "Flight [Flight Number : " + flightNumber + " Carrier Name : " + carrierName + "Flight Model : "
				+ flightModel + " Seat Capacity : " + seatCapacity + "]";
	}

}
