package com.capg.flightmanagement.bookingms.entities;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.entities.Passenger;
import java.math.*;
import java.util.Date;
import java.util.*;

public class Booking {
	
	private BigInteger bookingId;
	private User user;
	private double ticketCost;
	private int noOfPassenger;
	private Flight flight;
	private Date BookingDate;
	private List<Passenger> passengerList;


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookingId == null) ? 0 : bookingId.hashCode());
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
		Booking other = (Booking) obj;
		if (bookingId == null) {
			if (other.bookingId != null)
				return false;
		} else if (!bookingId.equals(other.bookingId))
			return false;
		return true;
	}
	
	public Booking() {
		
	}
	public BigInteger getBookingId() {
		return bookingId;
	}
	public void setBookingId(BigInteger bookingId) {
		this.bookingId = bookingId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getTicketCost() {
		return ticketCost;
	}
	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}
	public int getNoOfPassenger() {
		return noOfPassenger;
	}
	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public Date getBookingDate() {
		return BookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		BookingDate = bookingDate;
	}
	
	public List<Passenger> getPassengerList() {
		return passengerList;
	}
	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}
	
	public Booking(BigInteger bookingId, double ticketCost, int noOfPassenger, Flight flight, Date bookingDate,
			List<Passenger> passengerList) {
		this.bookingId = bookingId;
		this.ticketCost = ticketCost;
		this.noOfPassenger = noOfPassenger;
		this.flight = flight;
		this.BookingDate = bookingDate;
		this.passengerList = passengerList;
	}
	



	}


