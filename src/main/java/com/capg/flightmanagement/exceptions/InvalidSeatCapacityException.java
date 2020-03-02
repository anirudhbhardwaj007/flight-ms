package exceptions;

public class InvalidSeatCapacityException extends RuntimeException {
	public InvalidSeatCapacityException(String message) {
		super(message);
	}
}
