package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class FraudulentActivity {

    // Complete the activityNotifications function below.
    /*static int activityNotifications(int[] expenditure, int d) {
        int size = expenditure.length;
        int NoticeNumber = 0;
        int[] sortedTrail = new int[d];

        for (int i=0; i < size - d ; i++) {
            for (int j=0; j < d; j++ ) {
                sortedTrail[j] = expenditure[i+j];
            }
            Arrays.sort(sortedTrail);

            if (d%2 ==1) {
                int median;
                 median = (d-1)/2;
                 if (expenditure[i+d] >= 2 * sortedTrail[median]){
                     NoticeNumber++;
                 }
            } else {
                int tmp = d/2 -1;
                if( expenditure[i+d] >= sortedTrail[tmp] + sortedTrail[tmp+1] ) {
                    NoticeNumber++;
                }
            }
        }

        System.out.println(NoticeNumber);
        return NoticeNumber;
    }
*/

    //9 5
    //2 3 4 2 3 6 8 4 5

    //5 4
    //1 2 3 4 4

    static int activityNotifications(int[] expenditure, int d) {

        int[] counts = new int[201];
        for (int i = 0; i < d; i++) {
            counts[expenditure[i]]++;
        }

        int result = 0;
        for (int i = d; i < expenditure.length; i++) {
            int lower = 0;
            int leftNum = 0;
            while ((leftNum + counts[lower]) * 2 <= d) {
                leftNum += counts[lower];
                lower++;
            }

            int upper = counts.length - 1;
            int rightNum = 0;
            while ((rightNum + counts[upper]) * 2 <= d) {
                rightNum += counts[upper];
                upper--;
            }

            if (expenditure[i] >= lower + upper) {
                result++;
            }

            counts[expenditure[i - d]]--;
            counts[expenditure[i]]++;
        }
        System.out.println(result);
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

