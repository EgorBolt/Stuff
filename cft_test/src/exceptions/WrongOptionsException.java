package exceptions;

public class WrongOptionsException extends Exception {
    public WrongOptionsException() {
        super("Error: something is wrong with options, the program can't work properly, terminating the program.\n");
    }

    public WrongOptionsException(String msg) {
        super(msg);
    }
}
