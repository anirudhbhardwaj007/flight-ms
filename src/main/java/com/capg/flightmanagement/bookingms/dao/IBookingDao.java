package com.capg.flightmanagement.bookingms.dao;

import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.bookingms.entities.Booking;

public interface IBookingDao {

	List<Booking> addBooking(Booking b);

	Booking modifyBooking(Booking b);

	List<Booking> viewBooking(BigInteger userId);

	List<Booking> viewBooking();

	void deleteBooking(BigInteger bookingId);
}
