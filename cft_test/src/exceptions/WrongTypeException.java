package exceptions;

public class WrongTypeException extends Exception {
    public WrongTypeException() {
        super("Error: trying to sort wrong content type (due to program options), terminating the program.\n");
    }

    public WrongTypeException(String msg) {
        super(msg);
    }
}
