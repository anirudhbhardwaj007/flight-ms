package com.capg.flightmanagement.scheduledms.entities;

import java.util.Objects;

import com.capg.flightmanagement.flightms.entities.Flight;

public class ScheduledFlight {
    //declaring variables
    private int availableseats;
    private Flight flight;
    private Schedule schedule;

    //Intializing constructor
    public ScheduledFlight() {
        this(0, null, null);
    }

    //Constructor
    public ScheduledFlight(int availableseats, Flight flight, Schedule schedule) {
        this.availableseats = availableseats;
        this.flight = flight;
        this.schedule = schedule;
    }


    //Getters and Setters
    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScheduledFlight)) return false;
        ScheduledFlight that = (ScheduledFlight) o;
        return getAvailableseats() == that.getAvailableseats() &&
                getFlight().equals(that.getFlight()) &&
                getSchedule().equals(that.getSchedule());
    }


    //HashCode
    @Override
    public int hashCode() {

        return Objects.hash(getAvailableseats(), getFlight(), getSchedule());
    }
}
