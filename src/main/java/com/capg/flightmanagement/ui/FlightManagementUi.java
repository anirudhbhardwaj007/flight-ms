package com.capg.flightmanagement.ui;

import com.capg.flightmanagement.airportmanagement.dao.AirportDaoImpl;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.airportmanagement.services.AirportServiceImpl;
import com.capg.flightmanagement.airportmanagement.services.IAirportService;
import com.capg.flightmanagement.flightms.dao.FlightDaoImpl;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.flightms.service.FlightServiceImpl;
import com.capg.flightmanagement.flightms.service.IFlightService;
import com.capg.flightmanagement.scheduledms.dao.ScheduledFlightDaoImp;
import com.capg.flightmanagement.scheduledms.entities.Schedule;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;
import com.capg.flightmanagement.scheduledms.services.IScheduledFlightServices;
import com.capg.flightmanagement.scheduledms.services.ScheduledFlightServicesImpl;
import com.capg.flightmanagement.userms.dao.IUserDao;
import com.capg.flightmanagement.userms.dao.UserDaoImpl;
import com.capg.flightmanagement.userms.entities.Password;
import com.capg.flightmanagement.userms.entities.User;
import com.capg.flightmanagement.userms.service.IUserService;
import com.capg.flightmanagement.userms.service.UserServiceImpl;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Scanner;

public class FlightManagementUi {

    private IUserService userService = new UserServiceImpl(new UserDaoImpl());
    private IFlightService flightService = new FlightServiceImpl(new FlightDaoImpl());
    private IScheduledFlightServices scheduledFlightServices = new ScheduledFlightServicesImpl(new ScheduledFlightDaoImp());
    private IAirportService airportService = new AirportServiceImpl(new AirportDaoImpl());
    public static void main(String[] args) {
        FlightManagementUi flightManagementUi = new FlightManagementUi();
        User user = new User("admin",new BigInteger("100"),"Harsh",new Password("harsh"),new BigInteger("7587144701"),"shriharsh26@gmail.com");
        flightManagementUi.userService.addUser(user);
        if(user.getUserType().equals("admin")){
            flightManagementUi.adminUi();
        }else {
            flightManagementUi.customerUi();
        }
        }

    public void adminUi(){
    try{

        Flight flight = new Flight(new BigInteger("101"),"Indigo","B101",150);

        Airport sourceAirport = new Airport("Raja Bhoj","B026","Bhopal");
        Airport destinationAirport = new Airport("Banglore Port","A026","Banglore");

        LocalDateTime specificArrivalDate = LocalDateTime.of(2020, Month.JANUARY, 1, 10, 10, 30);
        LocalDateTime specificDepartureDate = LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10, 30);
        Schedule schedule = new Schedule(sourceAirport,destinationAirport,specificArrivalDate,specificDepartureDate);
        ScheduledFlight scheduledFlight= new ScheduledFlight(10,flight,schedule);

        Scanner kb = new Scanner(System.in);
        int choice = kb.nextInt();
        System.out.println("Enter your choice:");
        System.out.println("1.Add Flight");
        System.out.println("2.Modify Flight:");
        System.out.println("3.View List:");
        System.out.println("4 Delete Flight");
        System.out.println("5.View Details By FlightNo");
        System.out.println("6.Schedule Flight");
        System.out.println("7.View ScheduledFlight ");
        System.out.println("8.View ScheduleFlight By No");
        System.out.println("9.View ScheduleFlight By Airport");
        System.out.println("10.Modify ScheduledFlight");
        System.out.println("11.Delete ScheduleFlight");
        switch (choice) {
            case 1:
                flightService.addFlight(flight);
                System.out.println("Flight has been added!");
                break;
            case 2:
                Flight flight2 = new Flight(new BigInteger("101"), "Air India", "A101", 150);
                flightService.modifyFlight(flight2);
                System.out.println("Flight  modified");
                break;
            case 3:
                System.out.println("List of Flights : "+flightService.viewFlight());
                break;
            case 4:
                flightService.deleteFlight(new BigInteger("101"));
                System.out.println("Flight Deleted");
                break;
            case 5:
                System.out.println(flightService.viewFlight(new BigInteger("101")));
                break;

            case 6:
                scheduledFlightServices.scheduleFlight(scheduledFlight);
                break;
            case 7:
                System.out.println("List of all scheduled flights :"+scheduledFlightServices.viewScheduledFlight());
                break;
            case 8:
                System.out.println("Flights by number :"+scheduledFlightServices.viewScheduledFlights(new BigInteger("101")));
                break;
            case 9:
                LocalDate date = LocalDate.of(2020, Month.MARCH, 1);
                System.out.println("Flights by airport :"+scheduledFlightServices.viewScheduledFlights(sourceAirport,destinationAirport,date));
                break;
            case 10:
                LocalDateTime specificArrivalDate2 = LocalDateTime.of(2020, Month.JANUARY, 2, 10, 10, 30);
                LocalDateTime specificDepartureDate2 = LocalDateTime.of(2020, Month.JANUARY, 3, 10, 10, 30);
                Schedule schedule2 = new Schedule(sourceAirport,destinationAirport,specificArrivalDate2,specificDepartureDate2);
                scheduledFlightServices.modifyScheduledFlight(flight,schedule2);
                System.out.println("Flight scheduled has been modified ");
                break;
            case 11:
                scheduledFlightServices.deleteScheduledFlight(new BigInteger("101"));
                System.out.println("Scheduled Flight has been deleted!");
                break;
        }

    }
    catch(){

    }
    }

    public void customerUi(){
        try{
            User user= new User("User",new BigInteger("120"),"Anushka",new Password("anushka"),new BigInteger("1234567890"),"xyz@gmail.com");
            userService.addUser(user);
            Flight flight = new Flight(new BigInteger("101"),"Indigo","B101",150);
            Scanner sc=new Scanner(System.in);
            System.out.print("Select the task");
            System.out.println("1.Display Data");
            System.out.println("2.Search Flights");
            System.out.println("3.Flights");
            System.out.println("4.Check Availablity");
            System.out.println("5.Make Booking");
            int choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("User Details:"+userService.viewUser(user));
                    break;

                case 2:
                    System.out.println("Searched Flight :"+flightService.viewFlight(new BigInteger("101")));
                    break;
                case 3:
                    System.out.println("Flights:"+flightService.viewFlight());
                case 4:
                   // System.out.println(" Checking Availablity:"_);
                    break;
                case 5:
                  //  System.out.println("Booking":);
                    break;



            }



        }
        catch(){

        }
    }

}
