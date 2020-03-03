package com.capg.flightmanagement.bookingms.services;

import java.math.BigInteger;
import java.util.List;
import com.capg.flightmanagement.bookingms.entities.Booking;
import com.capg.flightmanagement.userms.entities.Passenger;

public interface IBookingService {
	List<Booking> addBooking(Booking b);

	Booking modifyBooking(Booking b);

	List<Booking> viewBooking(BigInteger userId);

	List<Booking> viewBooking();

	void deleteBooking(BigInteger bookingId);

	void validateBooking(Booking b);

	void validatePassenger(Passenger p);
}
