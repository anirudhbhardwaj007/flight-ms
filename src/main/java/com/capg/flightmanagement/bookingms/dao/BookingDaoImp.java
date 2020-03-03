package com.capg.flightmanagement.bookingms.dao;

import java.math.BigInteger;
import java.util.*;

import com.capg.flightmanagement.bookingms.entities.Booking;
import com.capg.flightmanagement.userms.entities.Passenger;

public class BookingDaoImp implements IBookingDao {
	public static List<Booking> bookingList = new ArrayList<>();
	List<Passenger> list = new ArrayList<>(); //creating a list of passenger

	
	/**
	 * creating a new booking and added to bookingList
	 * return - returning a list of booking type 
	 */
	@Override
	public List<Booking> addBooking(Booking booking) {
		bookingList.add(booking);
		return bookingList;
	}

	
	/**
	 * 
	 */
	@Override
	public Booking modifyBooking(Booking booking) {
		for(Booking b:bookingList) {
		if(b.getBookingId().equals(booking.getBookingId())){
			int index = bookingList.indexOf(b);
			bookingList.set(index,booking);
		}
			
		}	return booking;
	
	}
	
	/**
	 * Retrieving booking list based on bookingId made by user
	 */
	@Override
	public List<Booking> viewBooking(BigInteger bookingId) {
		List<Booking> desired = new ArrayList<>();
		for (Booking booking : bookingList) {
			//User  user = booking.getUser();
			if(booking.getBookingId().equals(bookingId)) {
				desired.add(booking);
			}
		}
		return desired;
	}

	/**
	 * Retrieving list of all the bookings made
	 */
	@Override
	public List<Booking> viewBooking() {
		return bookingList;
	}

	
	/**
	 * delete all the bookings  based on bookingId Comparison.
	 */
	@Override
	public void deleteBooking(BigInteger bookingId) {
		for (Booking booking : bookingList) {
			BigInteger bookingid1 = booking.getBookingId();
			if (bookingid1.equals(bookingId)) {
				bookingList.remove(booking);
			}

		}

	}

}
