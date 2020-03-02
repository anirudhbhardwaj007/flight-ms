package scheduledms.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import scheduledms.dao.ScheduledFlightDaoImp;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;
import scheduledms.exceptions.IncorrectArgumentException;
import scheduledms.exceptions.ScheduleAlreadyExistsException;
import scheduledms.exceptions.ScheduleNotFoundException;

import java.math.BigInteger;
import java.util.List;

public class ScheduledFlightServiceImplTest {

    ScheduledFlightServicesImpl service;


    @BeforeEach
    public void setup() {
        service = new ScheduledFlightServicesImpl(new ScheduledFlightDaoImp());
        ScheduledFlight s = new ScheduledFlight();
        System.out.println("Before each");
    }

    @AfterEach
    public void clear() {
        ScheduledFlightDaoImp.scheduledFlightsStore.clear();
        System.out.println("Inside clear");
    }

    @Test
    public void testScheduleFlight_1() {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        ScheduledFlight result = service.scheduleFlight(scheduledFlight);
        boolean found = ScheduledFlightDaoImp.scheduledFlightsStore.contains(result);
        Assertions.assertTrue(found);
        //doneScheduleAlreadyExistsException

    }

    @Test
    public void testScheduleFlight_2() {
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                ScheduledFlight scheduledFlight = new ScheduledFlight();
                List<ScheduledFlight> scheduledFlightList = ScheduledFlightDaoImp.scheduledFlightsStore;
                scheduledFlightList.add(scheduledFlight);
                ScheduledFlight result = scheduledFlightList.get(0);
                service.scheduleFlight(result);
            }
        };
        Assertions.assertThrows(ScheduleAlreadyExistsException.class, executable);


    }


    @Test
    public void testDeleteScheduleFlight_1() {
        //Flight flight = new Flight();
        //flight.setFlightNumber(BigInteger.ONE);
        //service.deleteScheduledFlight(flight.getFlightNumber());
        //boolean found = ScheduledFlightDaoImp.scheduledFlightsStore.contains(result);
        //Assertions.assertTrue(found);
        //Assertions.assertNull();
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        List<ScheduledFlight> scheduledFlightList = ScheduledFlightDaoImp.scheduledFlightsStore;
        scheduledFlightList.add(scheduledFlight);
        scheduledFlight.setFlight(new Flight());
        scheduledFlight.getFlight().setFlightNumber(BigInteger.ONE);
        BigInteger flightNumber = scheduledFlight.getFlight().getFlightNumber();
        service.deleteScheduledFlight(flightNumber);
        boolean isEmpty = scheduledFlightList.isEmpty();
        Assertions.assertEquals(true, isEmpty);
    }

    @Test
    public void testdeletescheduleflight_2() {
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                service.deleteScheduledFlight(null);
            }
        };
        Assertions.assertThrows(IncorrectArgumentException.class, executable);


    }

    @Test
    public void TestviewScheduledFlightlistshow_2() {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        List<ScheduledFlight> list1 = ScheduledFlightDaoImp.scheduledFlightsStore;
        List<ScheduledFlight> list = service.viewScheduledFlight();
        Assertions.assertEquals(list1, list);
    }
    //done list vla


    @Test
    public void testModifyScheduledFlight() {
        Flight flight = new Flight();
        flight.setFlightNumber(BigInteger.ONE);
        Schedule schedule = new Schedule();
        ScheduledFlight scheduledFlight = new ScheduledFlight(10, flight, schedule);
        ScheduledFlightDaoImp.scheduledFlightsStore.add(scheduledFlight);
        ScheduledFlight result = service.modifyScheduledFlight(flight, schedule);
        Assertions.assertEquals(scheduledFlight, result);
        Assertions.assertEquals(flight, scheduledFlight.getFlight());
    }
    //done

    @Test
    public void testModifyScheduledFlight_1() {
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                service.modifyScheduledFlight(null, null);
            }
        };
        Assertions.assertThrows(ScheduleNotFoundException.class, executable);


    }

    @Test
    public void testViewScheduledFlightsflightnumber() {
        System.out.println("view ScheduledFlights");
        Flight flight = new Flight();
        BigInteger id = BigInteger.ONE;
        flight.setFlightNumber(id);
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        scheduledFlight.setFlight(flight);
        ScheduledFlightDaoImp.scheduledFlightsStore.add(scheduledFlight);
        Flight result = service.viewScheduledFlights(id);
        Assertions.assertEquals(flight, result);
        boolean found = ScheduledFlightDaoImp.scheduledFlightsStore.contains(scheduledFlight);
        Assertions.assertTrue(found);
        //done
    }

    @Test
    public void testViewScheduledFlightsflightnumber_1() {
        Executable executable = new Executable() {
            @Override
            public void execute() throws Throwable {
                service.viewScheduledFlights(null);
            }
        };
        Assertions.assertThrows(IncorrectArgumentException.class, executable);


    }


}

