package com.capg.flightmanagement.util;

import com.capg.flightmanagement.bookingms.entities.Booking;
import com.capg.flightmanagement.bookingms.exceptions.FlightNotFoundException;

import com.capg.flightmanagement.bookingms.exceptions.UserNotFoundException;
import com.capg.flightmanagement.exceptions.*;
import com.capg.flightmanagement.flightms.entities.Flight;

import com.capg.flightmanagement.userms.entities.Passenger;


public class BookingValidation {
 
	
	public static void validatePassengerNumber() {
	  Booking booking =new Booking();
	  int numberofpassanger=booking.getNoOfPassenger();
	 Flight flight=new Flight();
	 int seatcapacity=flight.getSeatCapacity();
	  if(numberofpassanger>seatcapacity) {
		throw new InvalidArgumentException("invalid passenger number") ;
	  }
  }

  


public static void validateBooking(Booking b) {
	if (b.getBookingId() == null) {
		throw new NoBookingFoundException("no booking found");
	} else if (b.getBookingDate() == null) {
		throw new NoBookingFoundException("no booking found");
	} else if (b.getFlight() == null) {
		throw new FlightNotFoundException("flight not found");
	} else if (b.getNoOfPassenger() == 0) {
		throw new PassengerNotFoundException("no passenger Found");
	} else if (b.getTicketCost() == null) {
		throw new TicketCostInvalidException("ticket cost invalid");
	} else if (b.getUser() == null) {
		throw new UserNotFoundException("User not found ");
	}
}



public static void validatePassenger(Passenger p) {
if(p.getPNR_No()==null) {
throw new IncorrectArgumentException("incorrect argument");
}
else if(p.getPassengerName()==null) {
throw new InvalidArgumentException("invalid argument");

}
else if(p.getPassengerAge()==0) {
throw new InvalidAgeException("invalid age");
}
else if(p. getPassengerUin() ==null) {
throw new IncorrectArgumentException("incorrect argument ");
}
}
}

