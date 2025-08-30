package exceptions;

public class CarNotExistsException extends RuntimeException {

    public CarNotExistsException() {
        super("Um carro com esse id não existe.");
    }
}
