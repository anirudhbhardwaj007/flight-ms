package exceptions;
/**
 * 
 * this class extends the RuntimeException  for making userDefine exception
 *
 */

public class InvalidUserIdException extends RuntimeException{
	public InvalidUserIdException(String msg)
	{
		super(msg);
	}

}
