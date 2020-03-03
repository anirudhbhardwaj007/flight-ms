package com.capg.flightmanagement.flightms.entities;

import java.math.BigInteger;
import java.util.Objects;

public class Flight {
    BigInteger flightNumber;
    String flightModel;
    String carrierName;
    int seatCapacity;

    public Flight() {
        this(null,"","",0);

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return getFlightNumber() == flight.getFlightNumber() &&
                getSeatCapacity() == flight.getSeatCapacity() &&
                Objects.equals(getFlightModel(), flight.getFlightModel()) &&
                Objects.equals(getCarrierName(), flight.getCarrierName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFlightNumber(), getFlightModel(), getCarrierName(), getSeatCapacity());
    }

    public BigInteger getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(BigInteger flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Flight(BigInteger flightNumber, String flightModel, String carrierName, int seatCapacity) {
        this.flightNumber = flightNumber;
        this.flightModel = flightModel;
        this.carrierName = carrierName;
        this.seatCapacity = seatCapacity;
    }
}
