package com.capg.flightmanagement.bookingms;


import java.math.BigInteger;
import java.sql.Date;
import java.util.*;
import com.capg.flightmanagement.bookingms.dao.BookingDaoImp;
import com.capg.flightmanagement.bookingms.entities.Booking;
import com.capg.flightmanagement.bookingms.services.BookingServiceImpl;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.userms.entities.Passenger;
import com.capg.flightmanagement.userms.entities.User;

import org.junit.jupiter.*;
import org.junit.jupiter.api.*;

public class BookingServiceImplTest {
	
BookingServiceImpl service;

@BeforeEach
public void setup() {
	service=new BookingServiceImpl(new BookingDaoImp());
	
}

@AfterEach
public void clear() {
	BookingDaoImp.bookingList.clear();
}

@Test
public void testAddBooking1()
{
	List<Passenger>list=new ArrayList<>();
   
	
	Flight flight=new Flight();
	Booking booking = new Booking(new BigInteger("111"),444.0,55,flight,null,list);
	service.addBooking(booking);
	
	Assertions.assertEquals(55,booking.getNoOfPassenger());
	Assertions.assertEquals(444.0, booking.getTicketCost());
	Assertions.assertEquals(new BigInteger("111"),booking.getBookingId());
}

@Test
public void testModifyBooking()
{
	List<Passenger>list=new ArrayList<>();
   
	
	Flight flight=new Flight();
	Booking booking = new Booking(new BigInteger("111"),444.0,55,flight,null,list);
	BookingDaoImp.bookingList.add(booking);
	Booking booking2 = new Booking(new BigInteger("111"),555.0,55,flight,null,list);
	Booking result = service.modifyBooking(booking2);
	
	Assertions.assertEquals(booking,result);

}

@Test
public void viewBooking() {
	List<Passenger>list=new ArrayList<>();
	Flight flight=new Flight();
	Booking booking1=  new Booking();
	booking1.setFlight(flight);
	Booking booking = new Booking(new BigInteger("111"),444.0,55,flight,null,list);
	
	service.modifyBooking(booking);
	Assertions.assertEquals(new BigInteger("111"), booking.getBookingId());

	Assertions.assertEquals(444.0, booking.getTicketCost());
	Assertions.assertEquals(55, booking.getNoOfPassenger());
	Assertions.assertEquals(flight, booking1.getFlight());
		}

@Test
public void deleteBooking() {
	List<Passenger>list=new ArrayList<>();
	Flight flight=new Flight();
	Booking booking = new Booking(new BigInteger("111"),444.0,55,flight,null,list);
	//Booking booking1 = new Booking(new BigInteger("112"),444.0,55,flight,null,list);
	service.addBooking(booking);
	BookingDaoImp.bookingList.remove(booking);
	boolean isEmpty=BookingDaoImp.bookingList.contains(booking);
	Assertions.assertNull(booking.getBookingDate());
	Assertions.assertEquals(false,isEmpty);
		}

}

