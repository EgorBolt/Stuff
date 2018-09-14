package exceptions;

public class WrongSortOrderException extends Exception {
    public WrongSortOrderException(String file[]) {
        super("Warning: file " + file[0] + " or " + file[1] + " are bad - their content has wrong sort number (due to program option);\n" +
                "The rest of the content(s) of the bad file(s) will be deleted.");
    }

    public WrongSortOrderException() { }
}