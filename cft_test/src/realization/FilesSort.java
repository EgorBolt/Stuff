package realization;

import exceptions.WrongSortOrderException;
import exceptions.WrongTypeException;

import java.io.PrintWriter;
import java.util.Scanner;

public class FilesSort {

    public FilesSort() {
    }

    public void sort(Scanner sc1, Scanner sc2, PrintWriter out, short options[], String fileNames[]) throws WrongSortOrderException {
        if (options[2] == 1) {
            stringSort(sc1, sc2, out, options, fileNames);
        }
        else if (options[3] == 1) {
            intSort(sc1, sc2, out, options, fileNames);
        }
    }

    public void intSort(Scanner sc1, Scanner sc2, PrintWriter out, short options[], String fileNames[]) throws WrongSortOrderException {
        Integer c1;
        Integer c2;
        Integer cPrevious1;
        Integer cPrevious2;
        int sortType = -1;

        if (options[1] == 1) {
            sortType = 1;
        }

        c1 = sc1.nextInt();
        c2 = sc2.nextInt();
        int flag = 1;
        while (flag == 1) {
            if (c1.compareTo(c2) == sortType) {
                out.println(c1);
                if (sc1.hasNextInt()) {
                    cPrevious1 = c1;
                    c1 = sc1.nextInt();
                    if (((cPrevious1 < c1) && (sortType == 1)) || ((cPrevious1 > c1) && (sortType == -1))) {
                        out.println(c2);
                        while (sc2.hasNextInt()) {
                            cPrevious2 = c2;
                            c2 = sc2.nextInt();
                            if (((cPrevious2 < c2) && (sortType == 1)) || ((cPrevious2 > c2) && (sortType == -1))) {
                                sc1.close();
                                sc2.close();
                                out.close();
                                throw new WrongSortOrderException(fileNames);
                            }
                            out.println(c2);
                        }
                        sc1.close();
                        sc2.close();
                        out.close();
                        throw new WrongSortOrderException(fileNames);
                    }
                } else {
                    flag = 2;
                }
            } else {
                out.println(c2);
                if (sc2.hasNextInt()) {
                    cPrevious1 = c2;
                    c2 = sc2.nextInt();
                    if (((cPrevious1 < c2) && (sortType == 1)) || ((cPrevious1 > c2) && (sortType == -1))) {
                        out.println(c1);
                        while (sc1.hasNextInt()) {
                            cPrevious2 = c1;
                            c1 = sc1.nextInt();
                            if (((cPrevious2 < c1) && (sortType == 1)) || ((cPrevious2 > c1) && (sortType == -1))) {
                                sc1.close();
                                sc2.close();
                                out.close();
                                throw new WrongSortOrderException(fileNames);
                            }
                            out.println(c1);
                        }
                        sc1.close();
                        sc2.close();
                        out.close();
                        throw new WrongSortOrderException(fileNames);
                    }
                } else {
                    flag = 3;
                }
            }
        }

        if (flag == 2) {
            out.println(c2);
            while (sc2.hasNextInt()) {
                c2 = sc2.nextInt();
                out.println(c2);
            }
        } else {
            out.println(c1);
            while (sc1.hasNextInt()) {
                c1 = sc1.nextInt();
                out.println(c1);
            }
        }

        sc1.close();
        sc2.close();
        out.close();
    }

    public void stringSort(Scanner sc1, Scanner sc2, PrintWriter out, short options[], String fileNames[]) throws WrongSortOrderException {
        String c1;
        String c2;
        String cPrevious1;
        String cPrevious2;
        int sortType = -1;

        if (options[1] == 1) {
            sortType = 1;
        }

        c1 = sc1.nextLine();
        c2 = sc2.nextLine();
        int flag = 1;
        while (flag == 1) {
            if (c1.compareTo(c2) < 0) {
                out.println(c1);
                if (sc1.hasNextLine()) {
                    cPrevious1 = c1;
                    c1 = sc1.nextLine();
                    if (((cPrevious1.compareTo(c1) == -1) && (sortType == 1)) || ((cPrevious1.compareTo(c1) == 1) && (sortType == -1))) {
                        out.println(c2);
                        while (sc2.hasNextLine()) {
                            cPrevious2 = c2;
                            c2 = sc2.nextLine();
                            if (((cPrevious2.compareTo(c2) == -1) && (sortType == 1)) || ((cPrevious2.compareTo(c2) == 1) && (sortType == -1))) {
                                sc1.close();
                                sc2.close();
                                out.close();
                                throw new WrongSortOrderException(fileNames);
                            }
                            out.println(c2);
                        }
                        sc1.close();
                        sc2.close();
                        out.close();
                        throw new WrongSortOrderException(fileNames);
                    }
                } else {
                    flag = 2;
                }
            } else {
                out.println(c2);
                if (sc2.hasNextLine()) {
                    cPrevious1 = c2;
                    c2 = sc2.nextLine();
                    if (((cPrevious1.compareTo(c2) == -1) && (sortType == 1)) || ((cPrevious1.compareTo(c2) == 1) && (sortType == -1))) {
                        out.println(c1);
                        while (sc1.hasNextLine()) {
                            cPrevious2 = c1;
                            c1 = sc1.nextLine();
                            if (((cPrevious2.compareTo(c1) == -1) && (sortType == 1)) || ((cPrevious2.compareTo(c1) == 1) && (sortType == -1))) {
                                sc1.close();
                                sc2.close();
                                out.close();
                                throw new WrongSortOrderException(fileNames);
                            }
                            out.println(c1);
                        }
                        sc1.close();
                        sc2.close();
                        out.close();
                        throw new WrongSortOrderException(fileNames);
                    }
                } else {
                    flag = 3;
                }
            }
        }

        if (flag == 2) {
            out.println(c2);
            while (sc2.hasNextLine()) {
                c2 = sc2.nextLine();
                out.println(c2);
            }
        } else {
            out.println(c1);
            while (sc1.hasNextLine()) {
                c1 = sc1.nextLine();
                out.println(c1);
            }
        }

        sc1.close();
        sc2.close();
        out.close();
    }
}
