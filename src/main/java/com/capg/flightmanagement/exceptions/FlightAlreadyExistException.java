package exceptions;

public class FlightAlreadyExistException extends RuntimeException {
	public FlightAlreadyExistException(String message) {
		super(message);
	}
}
