package scheduledms.util;

import scheduledms.entities.ScheduledFlight;
import scheduledms.exceptions.FlightNotFoundException;
import scheduledms.exceptions.ScheduleNotFoundException;
import scheduledms.exceptions.ScheduledFlightIsNullException;
import scheduledms.exceptions.SeatsNotAvailableExceptions;

public  class ScheduledFlightValidations {


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
