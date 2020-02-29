package scheduledms.util;

import scheduledms.exceptions.IncorrectDateException;

import java.time.LocalDateTime;

public class ScheduledFlightValidations {


    public static void validateDate(LocalDateTime arrivalTime){
        if(arrivalTime==null){
            throw new IncorrectDateException("Incorrect Date");
        }

    }
}
