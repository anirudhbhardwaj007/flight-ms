package com.capg.flightmanagement.scheduledms.services;


import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import com.capg.flightmanagement.airportmanagement.entities.Airport;
import com.capg.flightmanagement.exceptions.*;
import com.capg.flightmanagement.flightms.entities.Flight;
import com.capg.flightmanagement.scheduledms.dao.IScheduledFlightDao;
import com.capg.flightmanagement.scheduledms.entities.Schedule;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;
import com.capg.flightmanagement.util.ScheduledFlightValidation;

public class ScheduledFlightServicesImpl implements IScheduledFlightServices {
    private IScheduledFlightDao dao; //declare data access object

    /**
     *
     * @param dao intialize the data acess object
     */
    public ScheduledFlightServicesImpl(IScheduledFlightDao dao) {

        this.dao = dao;
    }

    /**
     *
     * @param scheduledFlight  reference of scheduled flight
     * @return flight is scheduled calling from dao class and scheduling it return flight is scheduled
     */
    @Override
    public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
        ScheduledFlight flightisscheduled = dao.scheduleFlight(scheduledFlight);
        return flightisscheduled;
    }

    /**
     *
     * @param sourceArg
     * @param destinationArg
     * @param time taking argument from dao class and calling here
     * @return scheduledflight which is object of list of scheduled flight
     */
    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport sourceArg, Airport destinationArg, LocalDate time) {
        List<ScheduledFlight> scheduledFlight1 = dao.viewScheduledFlights(sourceArg, destinationArg, time);
        return scheduledFlight1;
    }

    /**
     *
     * @param flightNumber taking flight number if flight is null throw exception
     * @return    calling view schedule from dao class and return flight if flight number is taken
     */
    @Override
    public Flight viewScheduledFlights(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new IncorrectArgumentException("Incorrect Flight number");
        }
        Flight flight1 = dao.viewScheduledFlights(flightNumber);
        return flight1;
    }

    /**
     *
     * @return taking list object and calling the method from dao class
     */
    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        List<ScheduledFlight> flightschedule = dao.viewScheduledFlight();
        return flightschedule;
    }

    /**
     *
     * @param flight taking argument of flight and calling the method from the given class which is dao
     * @param schedule taking argument of schedule and calling the method from the given class which is dao
     * @return returning scheduledflight object with modified flight
     */
    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule) {
        ScheduledFlight f1 = dao.modifyScheduledFlight(flight, schedule);
        return f1;
    }

    /**
     *
     * @param flightNumber   Taking flight number as argument and if flight number is null throw exception or else delete flight
     */
    @Override
    public void deleteScheduledFlight(BigInteger flightNumber) {
        if (flightNumber == null) {
            throw new IncorrectArgumentException("Incorrect Flight Number");
        }
        dao.deleteScheduledFlight(flightNumber);

    }

    /**
     *
     * @param scheduledFlightValidate
     */
    @Override
    public void validateScheduledFlight(ScheduledFlight scheduledFlightValidate) {
        ScheduledFlightValidation.validateScheduledFlightvalid(scheduledFlightValidate);


    }


}
