package gr.aueb.fiveprojects;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectOne {
    public static void main(String[] args) {

        String data;
        String[] allNumbers;
        int[] sixNumber = new int [6];
        int range;

        try (Scanner in = new Scanner(new File("C:/Users/jkent/OneDrive/CF7-all-projects/IdeaProjects/Testbed/numbers.txt"));
            PrintStream printOut = new PrintStream("C:/Users/jkent/OneDrive/CF7-all-projects/IdeaProjects/Testbed/numbers-out.txt"))
        {
            data = in.nextLine();
            allNumbers = data.split("\\s");
            Arrays.sort(allNumbers);

            range = allNumbers.length - 6;

            for (int i=0; i<=range; i++) {
                for (int j=i+1; j<=range+1; j++) {
                    for (int k=j+1; k<=range+2; k++) {
                        for (int l=k+1; l<=range+3; l++) {
                            for (int m=l+1; m<=range+4; m++) {
                                for (int n=m+1; n<=range+5; n++) {

                                    sixNumber[0] = Integer.valueOf(allNumbers[i]);
                                    sixNumber[1] = Integer.valueOf(allNumbers[j]);
                                    sixNumber[2] = Integer.valueOf(allNumbers[k]);
                                    sixNumber[3] = Integer.valueOf(allNumbers[l]);
                                    sixNumber[4] = Integer.valueOf(allNumbers[m]);
                                    sixNumber[5] = Integer.valueOf(allNumbers[n]);

                                    if (evenCheck(sixNumber) && oddCheck(sixNumber) && consecutiveCheck(sixNumber) && sameEndCheck(sixNumber)
                                    && sameTenCheck(sixNumber)) printOut.printf("%d %d %d %d %d %d \n", sixNumber[0], sixNumber[1],
                                            sixNumber[2], sixNumber[3], sixNumber[4], sixNumber[5]);

                                }
                            }
                        }
                    }
                }
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean evenCheck(int arr[]) {
        int counter = 0;

        for (int i=0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) counter++;
        } return counter < 4;
    }
    public static boolean oddCheck(int arr[]) {
        int counter = 0;

        for (int i=0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) counter++;
        } return counter < 4;
    }
    public static boolean consecutiveCheck (int arr[]) {
        int counter = 0;

        Arrays.sort(arr);
        for (int i=0; i < arr.length-1; i++) {
            if (arr[i+1] - arr[i] == 1) counter++;
        } return counter < 3;
    }
    public static boolean sameEndCheck (int arr[]) {

        int[] checkArr = new int[10];

        for (int num : arr) {
            checkArr[num % 10]++;
        }
        for (int sameEnd : checkArr) {
           if (sameEnd > 3) return false;
        } return true;
    }
    public static boolean sameTenCheck (int arr[]) {

        int[] checkArr = new int[5];
        for (int num : arr) {
            checkArr[num / 10]++;
        }
        for (int sameTen : checkArr) {
            if (sameTen > 3) return false;
        } return true;
    }
}
