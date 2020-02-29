package scheduledms.dao;

import scheduledms.entities.Airport;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;
import scheduledms.exceptions.FlightNotFoundException;
import scheduledms.exceptions.ScheduleAlreadyExistsException;
import scheduledms.exceptions.ScheduleNotFoundException;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScheduledFlightDaoImp implements IScheduledFlightDao {

    public static List<ScheduledFlight> scheduledFlightsStore = new ArrayList<ScheduledFlight>();

    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlightsStore.contains(scheduledFlight)) {
            throw new ScheduleAlreadyExistsException("Schedule Already exists");
        }
        scheduledFlightsStore.add(scheduledFlight);
        return scheduledFlight;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate departureDateArg) {
        List<ScheduledFlight> desired = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            Airport sourcePort = scheduledFlight.getSchedule().getSourceAirport();
            Airport destPort = scheduledFlight.getSchedule().getDestinationAirport();
            LocalDate departureDate = scheduledFlight.getSchedule().getDepartureTime().toLocalDate();
            if (sourcePort.equals(sourceArg)
                    && destPort.equals(destinationArg)
                    && departureDate.equals(departureDate)) {
                desired.add(scheduledFlight);

            }
        }
        return desired;

    }

    @Override
    public Flight viewScheduledFlights(BigInteger flightNumber) {
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            Flight flight = scheduledFlight.getFlight();


            if (flight.getFlightNumber().equals(flightNumber)) {

                return flight;
            }

        }

        throw new FlightNotFoundException("Flight not found " + flightNumber);
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> list = new ArrayList<>();
        for (int i = 0; i < scheduledFlightsStore.size(); i++) {
            list.add(scheduledFlightsStore.get(i));

        }
        return list;
    }


    @Override
    public void deleteScheduledFlight(BigInteger flightNumber) {
        /*
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            Flight flight = scheduledFlight.getFlight();
            if (flight.getFlightNumber().equals(flightNumber)) {
                scheduledFlightsStore.remove(scheduledFlight);
            }
        }*/
        Iterator<ScheduledFlight> scheduledFlightIterator = scheduledFlightsStore.iterator();
        while(scheduledFlightIterator.hasNext()){
            ScheduledFlight scheduledFlight = scheduledFlightIterator.next();
            BigInteger flightNum = scheduledFlight.getFlight().getFlightNumber();
            if(flightNum.equals(flightNumber)){
                scheduledFlightIterator.remove();
                return;
            }
        }
        throw new FlightNotFoundException("Flight not found ");

    }


    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int a) {
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            if (scheduledFlight.getFlight().equals(flight)) {
                scheduledFlight.setSchedule(schedule);
            }

            return scheduledFlight;
        }
        throw new ScheduleNotFoundException(" Schedule Not Found");

    }
}
