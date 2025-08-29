package exception;

public class CarNotExistsException extends RuntimeException{

    public CarNotExistsException(String message) {
        super(message);
    }
}
