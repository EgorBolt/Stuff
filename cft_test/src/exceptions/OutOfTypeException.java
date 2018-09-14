package exceptions;

public class OutOfTypeException extends Exception {
    public OutOfTypeException() {
        super("Error: can't detect the type of files' contents, terminating the program.\n");
    }

    public OutOfTypeException(String msg) {
        super(msg);
    }
}
