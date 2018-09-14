package parser;

import exceptions.OutOfTypeException;
import exceptions.WrongOptionsException;

public class CLIParser {

    public CLIParser() {
    }

    public int parseOptions(String args[], short options[]) throws WrongOptionsException, OutOfTypeException {
        int optionsAmount = 0;
        int i = 0;

        if (args.length < 3) {
            throw new WrongOptionsException();
        }
        while(args[i].startsWith("-") && args[i].length() == 2 && optionsAmount < 2) {
            switch (args[i].charAt(1)) {
                case 'a':
                    if (options[0] == 0 && options[1] == 0) {
                        options[0] = 1;
                        options[1] = 2;
                        break;
                    }
                    else {
                        throw new WrongOptionsException();
                    }
                case 'd':
                    if (options[0] == 0 && options[1] == 0) {
                        options[1] = 1;
                        options[0] = 2;
                        break;
                    }
                    else {
                        throw new WrongOptionsException();
                    }
                case 's':
                    if (options[2] == 0 && options[3] == 0) {
                        options[2] = 1;
                        options[3] = 2;
                        break;
                    } else {
                        throw new WrongOptionsException();
                    }
                case 'i':
                    if (options[2] == 0 && options[3] == 0) {
                        options[3] = 1;
                        options[2] = 2;
                        break;
                    } else {
                        throw new WrongOptionsException();
                    }
                default:
                    throw new WrongOptionsException();
            }
            optionsAmount++;
            i++;
        }
        if (options[2] == 0 || options[3] == 0) {
            throw new OutOfTypeException();
        }
        return optionsAmount;
    }
}
