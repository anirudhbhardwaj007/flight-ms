package com.capg.flightmanagement.userms.entities;

import java.math.BigInteger;

import com.capg.flightmanagement.util.UserValidation;



public class Passenger {
	//attributes
	private BigInteger PNR_No;
	private String passengerName;
	private int passengerAge;
	private BigInteger passengerUin;
	private double luggage;
	public Passenger()
	{
		this(null,"",0,null,0.0);
	}
	//constructor
	public Passenger(BigInteger pNR_No, String passengerName, int passengerAge, BigInteger passengerUin,
			double luggage)
	{
	
		this.PNR_No = PNR_No;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		UserValidation.validateUin(passengerUin);
		this.passengerUin = passengerUin;
		this.luggage = luggage;
	}
	
	public BigInteger getPNR_No() {
		return PNR_No;
	}
	public void setPNR_No(BigInteger pNR_No) {
		PNR_No = pNR_No;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	public BigInteger getPassengerUin() {
		return passengerUin;
	}
	public void setPassengerUin(BigInteger passengerUin) {
		this.passengerUin = passengerUin;
	}
	public double getLuggage() {
		return luggage;
	}
	public void setLuggage(double luggage) {
		this.luggage = luggage;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((PNR_No == null) ? 0 : PNR_No.hashCode());
		long temp;
		temp = Double.doubleToLongBits(luggage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + passengerAge;
		result = prime * result + ((passengerName == null) ? 0 : passengerName.hashCode());
		result = prime * result + ((passengerUin == null) ? 0 : passengerUin.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (PNR_No == null) {
			if (other.PNR_No != null)
				return false;
		} else if (!PNR_No.equals(other.PNR_No))
			return false;
		if (Double.doubleToLongBits(luggage) != Double.doubleToLongBits(other.luggage))
			return false;
		if (passengerAge != other.passengerAge)
			return false;
		if (passengerName == null) {
			if (other.passengerName != null)
				return false;
		} else if (!passengerName.equals(other.passengerName))
			return false;
		if (passengerUin == null) {
			if (other.passengerUin != null)
				return false;
		} else if (!passengerUin.equals(other.passengerUin))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Passenger [PNR_No=" + PNR_No + ", passengerName=" + passengerName + ", passengerAge=" + passengerAge
				+ ", passengerUin=" + passengerUin + ", luggage=" + luggage + "]";
	}
	
	
	
}
