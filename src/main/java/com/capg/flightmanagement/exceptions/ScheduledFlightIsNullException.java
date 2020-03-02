package exceptions;

public class ScheduledFlightIsNullException extends RuntimeException {
    public ScheduledFlightIsNullException(String msg){
        super(msg);
    }
}
