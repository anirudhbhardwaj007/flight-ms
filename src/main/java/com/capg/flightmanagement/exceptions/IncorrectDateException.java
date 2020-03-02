package exceptions;

public class IncorrectDateException extends RuntimeException {

    public IncorrectDateException(String msg){
        super(msg);
    }
}
