package com.capg.flightmanagement.scheduledms.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.capg.flightmanagement.airportmanagement.entities.Airport;


public class Schedule  {
    @Override
    public String toString() {
        return "Schedule{" +
                "sourceAirport=" + sourceAirport +
                ", destinationAirport=" + destinationAirport +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Schedule)) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(getSourceAirport(), schedule.getSourceAirport()) &&
                Objects.equals(getDestinationAirport(), schedule.getDestinationAirport()) &&
                Objects.equals(getArrivalTime(), schedule.getArrivalTime()) &&
                Objects.equals(getDepartureTime(), schedule.getDepartureTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSourceAirport(), getDestinationAirport(), getArrivalTime(), getDepartureTime());
    }

    //declaring variables
    private Airport sourceAirport;
    private Airport destinationAirport;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;

      //Intializing constructor
    public Schedule(){
        this(null,null,null,null);

    }
      //Constructor
    public Schedule(Airport sourceAirport, Airport destinationAirport, LocalDateTime arrivalTime, LocalDateTime departureTime) {

        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }
//Getter and Setter
    public Airport getSourceAirport() {
        return sourceAirport;
    }

    public void setSourceAirport(Airport sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
    }

    public void setDestinationAirport(Airport destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }
}
