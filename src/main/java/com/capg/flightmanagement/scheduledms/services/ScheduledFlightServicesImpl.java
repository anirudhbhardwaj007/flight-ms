package scheduledms.services;

import scheduledms.dao.IScheduledFlightDao;
import scheduledms.entities.Airport;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;
import scheduledms.exceptions.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

public class ScheduledFlightServicesImpl implements IScheduledFlightServices {
    private IScheduledFlightDao dao;

    public ScheduledFlightServicesImpl(IScheduledFlightDao dao) {
        this.dao = dao;
    }

    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        ScheduledFlight flightisscheduled = dao.scheduleFlight(scheduledFlight);
        return flightisscheduled;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate time) {
        List<ScheduledFlight> scheduledFlight1 = dao.viewScheduledFlights(sourceArg, destinationArg, time);
        return scheduledFlight1;
    }

    @Override
    public Flight viewScheduledFlights(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new IncorrectArgumentException("Incorrect Flight number");
        }
        Flight flight1 = dao.viewScheduledFlights(flightNumber);
        return flight1;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> flightschedule = dao.viewScheduledFlight();
        return flightschedule;
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, int a) {
        ScheduledFlight f1 = dao.modifyScheduledFlight(flight, schedule, a);
        return f1;
    }

    @Override
    public void deleteScheduledFlight(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new IncorrectArgumentException("Incorrect Flight Number");
        }
        dao.deleteScheduledFlight(flightNumber);

    }

    @Override
    public void validateScheduledFlight(ScheduledFlight scheduledFlightValidate) {
        if (scheduledFlightValidate == null) {
            throw new ScheduledFlightIsNullException("Scheduled Flight Not Found");
        }
        if(scheduledFlightValidate.getAvailableseats()<=0){
            throw new SeatsNotAvailableExceptions("Seats are not available");
        }
        if(scheduledFlightValidate.getFlight()==null){
            throw new FlightNotFoundException("Flight Not Found");
        }
        if(scheduledFlightValidate.getSchedule()==null){
            throw new ScheduleNotFoundException("Schedule Not Found ");
        }

    }


}
