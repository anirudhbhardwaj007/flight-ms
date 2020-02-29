package scheduledms.services;

import scheduledms.entities.Airport;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;

import java.math.BigInteger;
import java.time.LocalDate;

import java.util.List;

public interface IScheduledFlightServices {
    ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);

    List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate time);

    Flight viewScheduledFlights(BigInteger flightNumber);

    List<ScheduledFlight> viewScheduledFlight();

    ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int a);

    void deleteScheduledFlight(BigInteger flightNumber);

    void validateScheduledFlight(ScheduledFlight scheduledFlightValidate);


}
