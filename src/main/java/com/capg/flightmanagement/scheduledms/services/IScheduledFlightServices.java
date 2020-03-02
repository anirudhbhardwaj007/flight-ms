package scheduledms.services;

import scheduledms.entities.Airport;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;

import java.math.BigInteger;
import java.time.LocalDate;

import java.util.List;

public interface IScheduledFlightServices {
    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight); //schedules a flight  will be called here

    List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate time); //view list on the basis of source airport,destination airport and localdate

    Flight viewScheduledFlights(BigInteger flightNumber); // view scheduled flight on the basis of flight number

    List<ScheduledFlight> viewScheduledFlight(); //list all the scheduled flight

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule);  //modify schedule on the basis of flight

    void deleteScheduledFlight(BigInteger flightNumber); //delete Scheduledfight on the basis of flightnumber

    void validateScheduledFlight(ScheduledFlight scheduledFlightValidate); //method to check if values are null or not


}
