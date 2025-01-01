package gr.aueb.fiveprojects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectFive {
    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[0m";

    public static void main(String[] args) {

        boolean room[][] = new boolean[30][12];
        int choise = 0;


        do {
            choise = menu();

            switch (choise) {

                case 1:
                    plan(room);
                    break;
                case 2:
                    manageBooking(room);
                    break;
                case 3:
                    initArr(room);
                case 4:
                    System.out.println("Έξοδος");
                    break;
            }

        } while (choise != 4);
    }

    public static void initArr(boolean arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = false;
            }
        }
    }

    public static int menu() throws InputMismatchException {

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("ΔΙΑΧΕΙΡΗΣΗ ΚΡΑΤΗΣΕΩΝ");
            System.out.println();
            System.out.println("1. Δείτε το πλάνο του θεάτρου");
            System.out.println("2. Εισαγετε την θέση που σας ενδιαφέρει");
            System.out.println("3. Εκκαθάριση όλων των κρατήσεων");
            System.out.println("4. Έξοδος από το πρόγραμμα");
            System.out.println();
            System.out.print("Επιλογή: ");

            return in.nextInt();

        } catch (InputMismatchException e) {
            return 4;
        }

    }

    public static void plan(boolean arr[][]) {
        String booked;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]) {
                    booked = "F";
                    System.out.print(RED + (i + 1) + "" + (char) (j + 65) + ":" + booked + WHITE + "|");
                } else {
                    booked = "E";
                    System.out.print((i + 1) + "" + (char) (j + 65) + ":" + booked + "|");
                }
            }
            System.out.println();
        }
    }

    public static int chooseRow() throws InputMismatchException {
        try {
            Scanner in = new Scanner(System.in);
            int row = 0;

            System.out.print("Παρακαλώ επιλέξτε σειρά (1-30): ");

            row = in.nextInt();
            while (row < 1 || row > 30) {
                System.out.print("Παρακαλώ επιλέξτε έγκυρη σειρά (1-30): ");
                row = in.nextInt();
            }
            return row;

    } catch (InputMismatchException e) {
        System.out.println("Λανθασμένη επιλογή. Παρακαλώ επιλέξτε έναν αριθμό.");
        throw e;
    }
}
    public static char chooseColumn() {

        Scanner in = new Scanner(System.in);
        String c;

        System.out.print("Παρακαλώ επιλέξτε θέση (A-L): ");
        c = in.nextLine().toUpperCase();

        while ((int) c.charAt(0) < 65 || (int) c.charAt(0) > 76 ) {
            System.out.print("Παρακαλώ επιλέξτε μια έγκυρη θέση (A-L): ");
            c = in.nextLine();
        }
        return c.charAt(0);

    }
    public static void book(boolean arr[][], int row,int column) {
            arr[row][column] = true;
            System.out.println("Κάνατε επιτυχημένη κράτηση της θέσης " + (row+1) + (char)(column+65) + "!");
        }
    public static void cancel(boolean arr[][], int row, int column) {
            arr[row][column] = false;
            System.out.println("Ακυρώσατε επιτυχημένα την κράτηση της θέσης "+ (row+1) + (char)(column+65) + "!");
        }
    public static void manageBooking(boolean arr[][]) {
        int rownum = 0;
        int columnnum = 0;

        rownum = chooseRow()-1;
        columnnum = (int) chooseColumn() - 65;
        if (arr[rownum][columnnum]) {
            cancel(arr, (rownum ), (columnnum));
        } else {book(arr, (rownum), (columnnum));}
    }
    }
