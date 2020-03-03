package com.capg.flightmanagement.scheduledms.dao;



import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.scheduledms.entities.Schedule;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;


import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public interface IScheduledFlightDao {


    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight); //schedules a flight

    List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate time); //view list on the basis of source airport,destination airport and localdate

    Flight viewScheduledFlights(BigInteger flightNumber); // view scheduled flight on the basis of flight number

    List<ScheduledFlight> viewScheduledFlight(); //list all the scheduled flight

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule);  //modify schedule on the basis of flight

    void deleteScheduledFlight(BigInteger flightNumber); //delete scheduledfight on the basis of flightnumber


}
