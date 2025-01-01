package gr.aueb.fiveprojects;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectFour {

    public static final String RED = "\u001B[31m";
    public static final String WHITE = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static int player = 1;


    public static void main(String[] args) {
        String triliza[][] = new String[3][3];
        Scanner in = new Scanner(System.in);
        int placeMove = 0;
        String repeat = "Y";

        while (repeat.equals("Y")) {
            initTriliza(triliza);
            while (true) {
                if (nextPlayer()) {
                    printSet(triliza);
                    nextPlayer();
                    placeMove = choise();

                    if (isItEmpty(triliza, placeMove)) {
                        markX(triliza, placeMove);
                        if (checkWinX(triliza)) {
                            printSet(triliza);
                            System.out.println(WHITE + "Κέρδισε ο παίκτης" + RED + " X " + WHITE + "!");
                            break;
                        } else {
                            if (isItDraw(triliza)) {
                                System.out.println(WHITE + "Το παιχνίδι έληξε ισόπαλο!");
                                break;
                            }
                            nextPlayer();
                        }
                    } else System.out.println(WHITE + "Η θέση είναι συμπληρωμένη. Επιλέξτε διαφορετική.");
                } else {
                    nextPlayer();
                    printSet(triliza);
                    placeMove = choise();
                    if (isItEmpty(triliza, placeMove)) {
                        markO(triliza, placeMove);
                        if (checkWinO(triliza)) {
                            printSet(triliza);
                            System.out.println(WHITE +"Κέρδισε ο παίκτης" + GREEN + " Ο " + WHITE + "!");
                            break;
                        } else {
                            if (isItDraw(triliza)) {
                                System.out.println(WHITE + "Το παιχνίδι έληξε ισόπαλο!");
                                break;
                            }
                            nextPlayer();
                        }
                    } else System.out.println(WHITE + "Η θέση είναι συμπληρωμένη. Επιλέξτε διαφορετική.");
                }
            }
            System.out.print(WHITE + "Θέλετε να ξαναπαίξετε (Υ/Ν); ");
            repeat = in.nextLine().toUpperCase();
            System.out.println();
        }
    }

    public static void printSet(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == "X") System.out.printf(RED + "%s ",arr[i][j]);
                else if (arr[i][j] == "O") System.out.printf(GREEN + "%s ",arr[i][j]);
                else System.out.printf(WHITE + "%s ",arr[i][j]);
                if (j == 0 || j ==1) System.out.print(RED + "| ");
            }
            System.out.println();
        }

    }
    public static void initTriliza(String arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i==0) arr[i][j] = String.valueOf(j+1);
                if (i==1) arr[i][j] = String.valueOf(j+4);
                if (i==2) arr[i][j] = String.valueOf(j+7);
            }
        }
    }

    public static boolean nextPlayer() {
        player++;
        return player % 2 !=0;

    }

    public static int choise() throws InputMismatchException {
        try {
        Scanner in = new Scanner(System.in);
        int choise = 0;
        if (player % 2 !=0) System.out.print(WHITE + "Παρακαλώ παίκτη" + GREEN + " 'Ο' " + WHITE + "επιλέξτε θέση (1-9): ");
        else System.out.print(WHITE + "Παρακαλώ παίκτη" + RED + " 'X' " + WHITE + "επιλέξτε θέση (1-9): ");
        choise = in.nextInt();

        while (choise < 1 || choise > 9) {
            System.out.print(WHITE + "Παρακαλώ επιλέξτε μια έγκυρη θέση (1-9): ");
            choise = in.nextInt();
        }
        return choise;

        } catch (InputMismatchException e){
            System.out.println(WHITE + "Η επιλογή της θέσης πρέπει να είναι αριθμός.");
            throw e;
        }
    }

    public static void markX(String arr[][], int choise) {
        Scanner in = new Scanner(System.in);

        switch (choise) {
            case 1:
                arr[0][0]="X";
                break;
            case 2:
                arr[0][1]="X";
                break;
            case 3:
                arr[0][2]="X";
                break;
            case 4:
                arr[1][0]="X";
                break;
            case 5:
                arr[1][1]="X";
                break;
            case 6:
                arr[1][2]="X";
                break;
            case 7:
                arr[2][0]="X";
                break;
            case 8:
                arr[2][1]="X";
                break;
            case 9:
                arr[2][2]="X";
                break;
        }
    }
    public static void markO(String arr[][], int choise) {

        switch (choise) {
            case 1:
                arr[0][0]="O";
                break;
            case 2:
                arr[0][1]="O";
                break;
            case 3:
                arr[0][2]="O";
                break;
            case 4:
                arr[1][0]="O";
                break;
            case 5:
                arr[1][1]="O";
                break;
            case 6:
                arr[1][2]="O";
                break;
            case 7:
                arr[2][0]="O";
                break;
            case 8:
                arr[2][1]="O";
                break;
            case 9:
                arr[2][2]="O";
                break;
        }
    }

    public static boolean isItEmpty(String arr[][], int choise) {

        switch (choise) {
            case 1:
                return arr[0][0] != "X" && arr[0][0] != "O";
            case 2:
                return arr[0][1] != "X" && arr[0][1] != "O";
            case 3:
                return arr[0][2] != "X" && arr[0][2] != "O";
            case 4:
                return arr[1][0] != "X" && arr[1][0] != "O";
            case 5:
                return arr[1][1] != "X" && arr[1][1] != "O";
            case 6:
                return arr[1][2] != "X" && arr[1][2] != "O";
            case 7:
                return arr[2][0] != "X" && arr[2][0] != "O";
            case 8:
                return arr[2][1] != "X" && arr[2][1] != "O";
            case 9:
                return arr[2][2] != "X" && arr[2][2] != "O";
        }
        return false;
    }

    public static boolean checkWinX(String arr[][]) {
        boolean win = false;

        if (arr[0][0]=="X" && arr[0][1]=="X" && arr[0][2]=="X") win = true;
        if (arr[1][0]=="X" && arr[1][1]=="X" && arr[1][2]=="X") win = true;
        if (arr[2][0]=="X" && arr[2][1]=="X" && arr[2][2]=="X") win = true;

        if (arr[0][0]=="X" && arr[1][0]=="X" && arr[2][0]=="X") win = true;
        if (arr[0][1]=="X" && arr[1][1]=="X" && arr[2][1]=="X") win = true;
        if (arr[0][2]=="X" && arr[1][2]=="X" && arr[2][2]=="X") win = true;

        if (arr[0][0]=="X" && arr[1][1]=="X" && arr[2][2]=="X") win = true;
        if (arr[0][2]=="X" && arr[1][1]=="X" && arr[2][0]=="X") win = true;

        return win;
    }
    public static boolean checkWinO(String arr[][]) {
        boolean win = false;

        if (arr[0][0]=="O" && arr[0][1]=="O" && arr[0][2]=="O") win = true;
        if (arr[1][0]=="O" && arr[1][1]=="O" && arr[1][2]=="O") win = true;
        if (arr[2][0]=="O" && arr[2][1]=="O" && arr[2][2]=="O") win = true;

        if (arr[0][0]=="O" && arr[1][0]=="O" && arr[2][0]=="O") win = true;
        if (arr[0][1]=="O" && arr[1][1]=="O" && arr[2][1]=="O") win = true;
        if (arr[0][2]=="O" && arr[1][2]=="O" && arr[2][2]=="O") win = true;

        if (arr[0][0]=="O" && arr[1][1]=="O" && arr[2][2]=="O") win = true;
        if (arr[0][2]=="O" && arr[1][1]=="O" && arr[2][0]=="O") win = true;

        return win;
    }

    public static boolean isItDraw(String arr [][]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
               if (arr[i][j] != "X" && arr[i][j] != "O") return false;
            }

        }
        return true;
    }
}
