package com.capg.flightmanagement.scheduledms.dao;


import com.capg.flightmanagement.scheduledms.entities.Schedule;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;
import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.exceptions.*;
import com.capg.flightmanagement.flightms.entities.Flight;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScheduledFlightDaoImp implements IScheduledFlightDao {

    public static List<ScheduledFlight> scheduledFlightsStore = new ArrayList<ScheduledFlight>(); //Creating attributes of scheduled flight using Array list and storing the elements in array list

    //Overriding the method and defining by implementing the Interface

    /**
     *
     * @param scheduledFlight    if scheduledflight are already there throw exception or add schedule flight
     * @return   Scheduled flight
     */
    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        if (scheduledFlightsStore.contains(scheduledFlight)) {
            throw new ScheduleAlreadyExistsException("Schedule Already exists");
        }
        scheduledFlightsStore.add(scheduledFlight);
        return scheduledFlight;
    }

    /**
     *
     * @param sourceArg    getting source airport via schedule class via scheduledFlight class
     * @param destinationArg  getting destination airport via schedule class via scheduledflight
     * @param departureDateArg  getting departure  time via schedule via departure time and putting all equal if it is equal add schedule
     * @return   desired which is list object of scheduled flight
     * @Traverse traversing the list from scheduledflight to scheduledflightsstore
     */
    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate departureDateArg) {
        List<ScheduledFlight> desired = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            Airport sourcePort = scheduledFlight.getSchedule().getSourceAirport();
            Airport destPort = scheduledFlight.getSchedule().getDestinationAirport();
            LocalDate departureDate = scheduledFlight.getSchedule().getDepartureTime().toLocalDate();
            if (sourcePort.equals(sourceArg)
                    && destPort.equals(destinationArg)
                    && departureDate.equals(departureDateArg)) {
                desired.add(scheduledFlight);

            }
        }
        return desired;

    }

    /**
     *
     * @param flightNumber    traversing the schedule flight to scheduledflightstore
     * @return flight if given flight number is equal to flightnumber or else throw exception
     */

    @Override
    public Flight viewScheduledFlights(BigInteger flightNumber) {
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            Flight flight = scheduledFlight.getFlight();


            if (flight.getFlightNumber().equals(flightNumber)) {

                return flight;
            }

        }

        throw new IncorrectArgumentException("Flight not found " + flightNumber);
    }

    /**
     *
     * @return  creating list of scheduled flight to traverse and store it into the list and return list
     */
    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> list = new ArrayList<>();
        for (int i = 0; i < scheduledFlightsStore.size(); i++) {
            list.add(scheduledFlightsStore.get(i));

        }
        return list;
    }

    /**
     *
     * @param flightNumber   using iterator of the list checking the next value if next value equals the given value then remove the flight
     *                       or else throw exception
     */
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
        throw new IncorrectArgumentException("Flight not found ");

    }

    /**
     *
     * @param flight traversing the list and checking if flight object given equals to scheduled flight object set schedule
     * @param schedule else throw exception
     * @return
     */

    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule) {
        for (ScheduledFlight scheduledFlight : scheduledFlightsStore) {
            if (scheduledFlight.getFlight().equals(flight)) {
                scheduledFlight.setSchedule(schedule);
            }

            return scheduledFlight;
        }
        throw new ScheduleNotFoundException(" Schedule Not Found");

    }
}
