package com.capg.flightmanagement.util;

import com.capg.flightmanagement.exceptions.FlightNotFoundException;
import com.capg.flightmanagement.exceptions.ScheduleNotFoundException;
import com.capg.flightmanagement.exceptions.ScheduledFlightIsNullException;
import com.capg.flightmanagement.exceptions.SeatsNotAvailableExceptions;
import com.capg.flightmanagement.scheduledms.entities.ScheduledFlight;

public  class ScheduledFlightValidation{


    public static void validateScheduledFlightvalid(ScheduledFlight scheduledFlightValidate) {
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