package scheduledms.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import scheduledms.dao.ScheduledFlightDaoImp;
import scheduledms.entities.Flight;
import scheduledms.entities.Schedule;
import scheduledms.entities.ScheduledFlight;

import java.math.BigInteger;
import java.util.List;

public class ScheduledFlightServiceImplTest {

    ScheduledFlightServicesImpl service;


    @BeforeEach
    public void setup() {
        service=new ScheduledFlightServicesImpl(new ScheduledFlightDaoImp());
        ScheduledFlight s = new ScheduledFlight();
        System.out.println("before each");
    }

    @AfterEach
    public void clear() {
        ScheduledFlightDaoImp.scheduledFlightsStore.clear();
        System.out.println("inside clear");
    }

    @Test
    public void testScheduleFlight_1() {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        ScheduledFlight result = service.scheduleFlight(scheduledFlight);
        boolean found = ScheduledFlightDaoImp.scheduledFlightsStore.contains(result);
        Assertions.assertTrue(found);
        //done

    }
    public void listscheduledflightbyairport() {
        



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
        Assertions.assertEquals(true,isEmpty);
    }
    @Test
    public void TestviewScheduledFlightlistshow_2() {
        ScheduledFlight scheduledFlight = new ScheduledFlight();
        List<ScheduledFlight>list1 = ScheduledFlightDaoImp.scheduledFlightsStore;
        List<ScheduledFlight>list=service.viewScheduledFlight();
        Assertions.assertEquals(list1,list);
    }
    //done list vla


    @Test
    public void testModifyScheduledFlight() {
        Flight flight=new Flight();
        flight.setFlightNumber(BigInteger.ONE);
        Schedule schedule=new Schedule();
        ScheduledFlight scheduledFlight=new ScheduledFlight(10,flight,schedule);
        ScheduledFlightDaoImp.scheduledFlightsStore.add(scheduledFlight);
        ScheduledFlight result=service.modifyScheduledFlight(flight,schedule,1);
        Assertions.assertEquals(scheduledFlight,result);
        Assertions.assertEquals(flight,scheduledFlight.getFlight());
    }
    //done

    @Test
    public void testViewScheduledFlightsflightnumber() {
        System.out.println("view ScheduledFlights");
        Flight flight=new Flight();
        BigInteger id=BigInteger.ONE;
        flight.setFlightNumber(id);
        ScheduledFlight scheduledFlight=new ScheduledFlight();
        scheduledFlight.setFlight(flight);
        ScheduledFlightDaoImp.scheduledFlightsStore.add(scheduledFlight);
        Flight result = service.viewScheduledFlights(id);
        Assertions.assertEquals(flight,result);
        boolean found = ScheduledFlightDaoImp.scheduledFlightsStore.contains(scheduledFlight);
        Assertions.assertTrue(found);
        //done
    }


}

