package com.capg.flightmanagement.bookingms.services;

import java.math.BigInteger;
import java.util.*;
import com.capg.flightmanagement.bookingms.dao.*;
import com.capg.flightmanagement.bookingms.entities.Booking;

import com.capg.flightmanagement.exceptions.ModificationNotFoundException;
import com.capg.flightmanagement.exceptions.NoBookingDeletedException;
import com.capg.flightmanagement.exceptions.NoBookingFoundException;



import com.capg.flightmanagement.userms.entities.Passenger;
import com.capg.flightmanagement.util.BookingValidation;


public class BookingServiceImpl implements IBookingService {
	private IBookingDao dao;

	public BookingServiceImpl(IBookingDao dao) {
		this.dao = dao;

	}
     
	@Override
	public List<Booking> addBooking(Booking booking) {
		if (booking == null) {
			throw new NoBookingFoundException("not any booking");
		}
		List<Booking> addlist = dao.addBooking(booking);
		return addlist;
		
	}

	@Override
	public Booking modifyBooking(Booking booking) {

		if (booking == null) {
			throw new ModificationNotFoundException("modification not found");
		}
		return dao.modifyBooking(booking);
	}

	@Override
	public List<Booking> viewBooking(BigInteger user) {
		if (user == null) {
			throw new NoBookingFoundException("no any booking");
		}
		return dao.viewBooking(user);
	}

	@Override
	public List<Booking> viewBooking() {
       List<Booking> bookingList=dao.viewBooking();
       
		return bookingList;
	}

	@Override
	public void deleteBooking(BigInteger bookingId) {
		// List<Booking> bookingList;

		boolean contain = BookingDaoImp.bookingList.contains(bookingId);
		if (contain) {
			throw new NoBookingDeletedException("no booking deleted");
		}

	}

	@Override
	public void validateBooking(Booking booking) {
		BookingValidation.validatePassengerNumber();


	}

@Override
public void validatePassenger(Passenger passenger) {
	BookingValidation.validatePassenger(passenger);

}
}
