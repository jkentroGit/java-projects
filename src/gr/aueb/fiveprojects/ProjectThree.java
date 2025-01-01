package gr.aueb.fiveprojects;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProjectThree {
    public static void main(String[] args) {

        String line;
        String[] letters;
        char c;
        int ascii = 0;
        int[][] stats = new int[128][2];
        int column = 0;

        try (Scanner in = new Scanner(new File("C:/Users/jkent/OneDrive/CF7-all-projects/IdeaProjects/Testbed/simpletext.txt"));
             PrintStream printOut = new PrintStream("C:/Users/jkent/OneDrive/CF7-all-projects/IdeaProjects/Testbed/simpletext-statistics.txt"))
        {
            while (in.hasNextLine()) {

                line = in.nextLine().replaceAll("\\s", "") ;
                letters = line.split("");

                for (String letter : letters) {
                    c = letter.charAt(0);
                    ascii = c;
                    stats[ascii][0] = ascii;
                    stats[ascii][1]++;
                }
            }

            System.out.print("Ταξινόμηση βάση της πρώτης (1) ή της δεύτερης (2) στήλης; ");

            try (Scanner sc = new Scanner(System.in)) {
                column = sc.nextInt();
                sortColumn(stats, column);

                for (int i=0; i < stats.length; i++) {
                    if (stats[i][1] != 0) {
                    printOut.println("Ο χαρακτήρας " + (char) stats[i][0] + " εμφανίζεται " + stats[i][1] + " φορές.");
                    }
                }

            } catch (InputMismatchException i) {
                i.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortColumn(int arr[][], int column) {
        Arrays.sort(arr, Comparator.comparingInt(x -> x[column - 1]));
    }
}
