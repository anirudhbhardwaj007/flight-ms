package com.capg.flightmanagement.ui;

import com.capg.flightmanagement.airportmanagement.dao.AirportDaoImpl;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.airportmanagement.services.AirportServiceImpl;
import com.capg.flightmanagement.airportmanagement.services.IAirportService;
import com.capg.flightmanagement.bookingms.dao.BookingDaoImp;
import com.capg.flightmanagement.bookingms.entities.Booking;
import com.capg.flightmanagement.bookingms.services.BookingServiceImpl;
import com.capg.flightmanagement.bookingms.services.IBookingService;
import com.capg.flightmanagement.exceptions.IncorrectArgumentException;
import com.capg.flightmanagement.exceptions.InvalidArgumentException;
import com.capg.flightmanagement.flightms.dao.FlightDaoImpl;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.service.FlightServiceImpl;
import com.capg.flightmanagement.flightms.service.IFlightService;
import com.capg.flightmanagement.scheduledms.dao.ScheduledFlightDaoImp;
import com.capg.flightmanagement.scheduledms.entities.Schedule;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;
import com.capg.flightmanagement.scheduledms.services.IScheduledFlightServices;
import com.capg.flightmanagement.scheduledms.services.ScheduledFlightServicesImpl;
import com.capg.flightmanagement.userms.dao.UserDaoImpl;
import com.capg.flightmanagement.userms.entities.Passenger;
import com.capg.flightmanagement.userms.entities.Password;
import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.service.IUserService;
import com.capg.flightmanagement.userms.service.UserServiceImpl;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;
import java.util.*;

public class FlightManagementUi {

	private IUserService userService = new UserServiceImpl(new UserDaoImpl());
	private IFlightService flightService = new FlightServiceImpl(new FlightDaoImpl());
	private IScheduledFlightServices scheduledFlightServices = new ScheduledFlightServicesImpl(
			new ScheduledFlightDaoImp());
	private IAirportService airportService = new AirportServiceImpl(new AirportDaoImpl());
	private IBookingService bookingService = new BookingServiceImpl(new BookingDaoImp());

	public static void main(String[] args) throws ParseException {
		FlightManagementUi flightManagementUi = new FlightManagementUi();

		User user = new User("admin", new BigInteger("100"), "Harsh", new Password("harsh-123"),
				new BigInteger("7587141247"), "shriharsh26@gmail.com");

		flightManagementUi.userService.addUser(user);

		if (user.getUserType().equals("admin")) {
			flightManagementUi.adminUi();
		} else {
			flightManagementUi.customerUi();
		}
	}



	public void adminUi(){
    try{
        //Airport sourceAirport = new Airport("Raja Bhoj","B026","Bhopal");
        //Airport destinationAirport = new Airport("Banglore Port","A026","Banglore");

        //airportService.addAirport(sourceAirport);
       // airportService.addAirport(destinationAirport);

        User user= new User("Customer",new BigInteger("120"),"Anushka",new Password("anushka"),new BigInteger("1234567890"),"xyz@gmail.com");

        LocalDateTime specificArrivalDate = LocalDateTime.of(2020, Month.JANUARY, 1, 10, 10, 30);
        LocalDateTime specificDepartureDate = LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10, 30);

        //Schedule schedule = new Schedule(sourceAirport,destinationAirport,specificArrivalDate,specificDepartureDate);

        //ScheduledFlight scheduledFlight= new ScheduledFlight(14,flight,schedule);
        //scheduledFlightServices.scheduleFlight(scheduledFlight);

        Scanner kb = new Scanner(System.in);
        for(int i=0;i<=14;i++)
        {
        System.out.println("Enter your choice:");
        System.out.println("1.Add Flight");
        System.out.println("2.Modify Flight:");
        System.out.println("3.View List of Flights:");
        System.out.println("4 Delete Flight");
        System.out.println("5.View Details By FlightNo");
        System.out.println("6.Schedule Flight");
        System.out.println("7.View ScheduledFlight ");
        System.out.println("8.View ScheduleFlight By No");
        System.out.println("9.View ScheduleFlight By Airport");
        System.out.println("10.Modify ScheduledFlight");
        System.out.println("11.Delete ScheduleFlight");
        System.out.println("12.Add User");
        System.out.println("13.View All Users");
        System.out.println("14.View User Details");

        int choice = kb.nextInt();
        switch (choice) {
            case 1:
                Flight flight = new Flight(new BigInteger("102"), "Indigo", "B101", 150);
                flightService.addFlight(flight);
                System.out.println("Flight has been added!");
                break;
            case 2:
                Flight flight2 = new Flight(new BigInteger("102"), "SpyJet", "A101", 150);
                flightService.modifyFlight(flight2);
                System.out.println("Flight  modified");
                break;
            case 3:
                System.out.println("List of Flights : " + flightService.viewFlight());
                break;
            case 4:
                flightService.deleteFlight(new BigInteger("102"));
                System.out.println("Flight Deleted");
                break;
            case 5:
                System.out.println(flightService.viewFlight(new BigInteger("102")));
                break;
            case 6:
                Flight flight4 = new Flight(new BigInteger("103"), "Air India", "B101", 100);
                Airport sourceAirport = new Airport("Raja Bhoj","B026","Bhopal");
                Airport destinationAirport = new Airport("Banglore Port","A026","Banglore");
                Schedule schedule = new Schedule(sourceAirport,destinationAirport,specificArrivalDate,specificDepartureDate);

                ScheduledFlight scheduledFlight2= new ScheduledFlight(17,flight4,schedule);
                scheduledFlightServices.scheduleFlight(scheduledFlight2);
                System.out.println("Flight has been scheduled!");
                break;
            case 7:
                System.out.println("List of all scheduled flights :" + scheduledFlightServices.viewScheduledFlight());
                break;
            case 8:
                Flight flight5 = new Flight(new BigInteger("103"), "Air India", "B101", 100);
                flightService.addFlight(flight5);
                Airport sourceAirport9 = new Airport("Raja Bhoj","B026","Bhopal");
                Airport destinationAirport9 = new Airport("Banglore Port","A026","Banglore");
                Schedule schedule9 = new Schedule(sourceAirport9,destinationAirport9,specificArrivalDate,specificDepartureDate);
                ScheduledFlight scheduledFlight= new ScheduledFlight(14,flight5,schedule9);
                //ScheduledFlight scheduledFlight = new ScheduledFlight(10,flight5,new Schedule())
                scheduledFlightServices.scheduleFlight(scheduledFlight);
                System.out.println("Flights by number :" + scheduledFlightServices.viewScheduledFlights(new BigInteger("103")));
                break;
            case 9:
                LocalDate date = LocalDate.of(2020, Month.MARCH, 1);
                Airport sourceAirport1 = new Airport("Raja Bhoj","B026","Bhopal");
                Airport destinationAirport1 = new Airport("Banglore Port","A026","Banglore");
                System.out.println("Flights by airport :" + scheduledFlightServices.viewScheduledFlights(sourceAirport1, destinationAirport1, date));
                break;
            case 10:
                LocalDateTime specificArrivalDate2 = LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10, 30);
                LocalDateTime specificDepartureDate2 = LocalDateTime.of(2020, Month.JANUARY, 3, 10, 10, 30);
                Airport sourceAirports= new Airport("Raja Bhoj","B026","Bhopal");
                Airport destinationAirports = new Airport("Banglore Port","A026","Banglore");
                Schedule schedule2 = new Schedule(sourceAirports, destinationAirports, specificArrivalDate2, specificDepartureDate2);
                Flight flight6= new Flight(new BigInteger("103"), "Air India", "B101", 100);
                scheduledFlightServices.modifyScheduledFlight(flight6, schedule2);
                System.out.println("Flight scheduled has been modified ");
                break;
            case 11:

                scheduledFlightServices.deleteScheduledFlight(new BigInteger("103"));
                System.out.println("Scheduled Flight has been deleted!");
                break;
            case 12:
                userService.addUser(user);
                System.out.println("User Added!");
                break;
            case 13:
                System.out.println("All Users Details:" + userService.viewUser(user));
                break;
            case 14:
                User user1 = userService.viewUserById(new BigInteger("100"));
                System.out.println("User Name :" + user1.getUserName());
                break;

        }
        }

	}
    catch(IncorrectArgumentException ex){
    	//System.out.println("Argument should be correct!");
        ex.printStackTrace();
    }
    }

	public void customerUi() throws ParseException{
        try {

            User user = new User("Customer", new BigInteger("120"), "Anushka", new Password("anushka"), new BigInteger("1234567890"), "xyz@gmail.com");
            userService.addUser(user);
            Passenger passenger = new Passenger(new BigInteger("1234"), "Rashmi", 55, new BigInteger("123123123123"), 44.0);
            List<Passenger> list = new ArrayList<Passenger>();
            list.add(passenger);
            Flight flight = new Flight(new BigInteger("101"), "Indigo", "B101", 150);
            Flight flight2 = new Flight(new BigInteger("101"), "Air India", "A101", 150);
            flightService.addFlight(flight);
            flightService.addFlight(flight2);


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date bookingDate = format.parse("2020-03-03");
            Booking booking = new Booking(new BigInteger("1"), 4441.0, 3, flight, bookingDate, list);
            Booking booking2 = new Booking(new BigInteger("1"), 5000.0, 5, flight, bookingDate, list);

            Scanner sc = new Scanner(System.in);
            for (int i = 0; i <=9; i++) {
                System.out.print("Enter your choice!");
                System.out.println("1.Display Data");
                System.out.println("2.Search Flight by flight number");
                System.out.println("3.List of Flights");
                System.out.println("4.Make Booking");
                System.out.println("5.Modify Booking");
                System.out.println("6.View Booking by id");
                System.out.println("7.All Booking details");
                System.out.println("8.Delete Booking");
                System.out.println("9.Update User");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("User Details:" + userService.viewUser(user));
                        break;
                    case 2:
                        System.out.println("Searched Flight :" + flightService.viewFlight(new BigInteger("101")));
                        break;
                    case 3:
                        System.out.println("Flights:" + flightService.viewFlight());
                        break;
                    case 4:
                        bookingService.addBooking(booking);
                        System.out.println("Booking Done!");
                        break;
                    case 5:
                        bookingService.modifyBooking(booking2);
                        System.out.println("Booking modified!");
                        break;
                    case 6:
                        System.out.println("Booking Details :" + bookingService.viewBooking(new BigInteger("1")));
                        break;
                    case 7:
                        System.out.println("All Booking Details :" + bookingService.viewBooking());
                        break;
                    case 8:
                        bookingService.deleteBooking(new BigInteger("101"));
                        System.out.println("Booking Cancelled!");
                        break;
                    case 9:
                        userService.updateUser(user);
                        System.out.println("User Updated!");
                        break;

                }
            }
        }
        catch(InvalidArgumentException ex){
        	System.out.println("Code should be correct!");
        }
    }

}
