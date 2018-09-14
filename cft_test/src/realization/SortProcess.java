package realization;

import exceptions.OutOfTypeException;
import exceptions.WrongOptionsException;
import exceptions.WrongSortOrderException;
import exceptions.WrongTypeException;
import parser.CLIParser;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortProcess {
    public SortProcess() {

    }

    public void doSort(String args[]) {
        Scanner scanner1;
        Scanner scanner2;
        PrintWriter out;
        short options[] = new short[4];
        String fileNames[] = new String[2];
        int optAmount;
        int i;
        ArrayList<String> tempFiles = new ArrayList<>();
        FilesSort filesSort = new FilesSort();
        File f1;
        File f2;

        try {
            CLIParser parser = new CLIParser();
            optAmount = parser.parseOptions(args, options);

            int filesAmount = args.length - optAmount;
            int parseFilesAmount = filesAmount;
            if (filesAmount % 2 == 0) {
                tempFiles.add(args[args.length - 1]);
                parseFilesAmount--;
            }

            try {
                if (options[3] == 1) {
                    for (i = optAmount + 1; i <= parseFilesAmount; i++) {
                        scanner1 = new Scanner(new File(args[i]));
                        String checkIfString = scanner1.nextLine();
                        Integer.parseInt(checkIfString);
                    }
                }
            } catch (NumberFormatException eNumberFormat) {
                throw new WrongTypeException();
            }

            for (i = optAmount + 1; i <= parseFilesAmount; i = i + 2) {
                scanner1 = new Scanner(new File(args[i]));
                scanner2 = new Scanner(new File(args[i + 1]));
                String newFileName = String.valueOf(i) + ".txt";
                File tempFile = new File(".", newFileName);
                out = new PrintWriter(tempFile);
                fileNames[0] = args[i];
                fileNames[1] = args[i + 1];
                try {
                    filesSort.sort(scanner1, scanner2, out, options, fileNames);
                } catch (WrongSortOrderException eWrongSortOrderFirst) {
                    System.err.println(eWrongSortOrderFirst.getMessage());
                }
                tempFiles.add(newFileName);
            }
            while (tempFiles.size() > 2) {
                f1 = new File(tempFiles.get(0));
                f2 = new File(tempFiles.get(1));
                scanner1 = new Scanner(f1);
                scanner2 = new Scanner(f2);
                String newFileName = String.valueOf(i) + ".txt";
                File tempFile = new File(".", newFileName);
                out = new PrintWriter(tempFile);
                fileNames[0] = tempFiles.get(0);
                fileNames[1] = tempFiles.get(1);
                try {
                    filesSort.sort(scanner1, scanner2, out, options, fileNames);
                } catch (WrongSortOrderException eWrongSortOrderMiddle) {
                    System.err.println(eWrongSortOrderMiddle.getMessage());
                }
                tempFiles.add(newFileName);
                if (Arrays.asList(args).contains(f1.getName())) {
                    f2.delete();
                } else {
                    f1.delete();
                    f2.delete();
                }
                tempFiles.remove(0);
                tempFiles.remove(0);
                i++;
            }
            f1 = new File(tempFiles.get(0));
            f2 = new File(tempFiles.get(1));
            scanner1 = new Scanner(f1);
            scanner2 = new Scanner(f2);
            out = new PrintWriter(args[optAmount]);
            fileNames[0] = tempFiles.get(0);
            fileNames[1] = tempFiles.get(1);
            try {
                filesSort.sort(scanner1, scanner2, out, options, fileNames);
            } catch (WrongSortOrderException eWrongSortOrderAtLast) {
                System.err.println(eWrongSortOrderAtLast.getMessage());
            }
            f1.delete();
            f2.delete();
        } catch (WrongTypeException eWrongType) {
            eWrongType.printStackTrace();
        } catch (OutOfTypeException eOutOfType) {
            eOutOfType.printStackTrace();
        } catch (WrongOptionsException eWrongException) {
            eWrongException.printStackTrace();
        } catch (IOException eIO) {
            eIO.printStackTrace();
        }
    }
}
