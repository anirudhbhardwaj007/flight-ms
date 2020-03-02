package exceptions;

public class InvalidFlightModelException extends RuntimeException {
	public InvalidFlightModelException(String message) {
		super(message);
	}
}
