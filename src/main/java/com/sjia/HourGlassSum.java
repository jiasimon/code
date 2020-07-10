package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassSum {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int maxsum = -1000,   column = 0;  // maxsum=-63 on current condition



/*        for(int i = 0;i < 4;i++) {
            int sum = 0;
            for(int j = column;j < column+3;j++) {
                sum += arr[i][j];
                if(j==column) sum += arr[i+1][column+1];
                sum += arr[i+2][j];
            }
            column = (column < 3) ? column+1 : 0;
            if(sum > maxsum) maxsum = sum;
            if(column != 0) i--;
        }*/

        for (int i=0; i<4; i++) {
            for (int j=0; j< 4; j++) {
                int sum = 0 ;
                sum += arr[i][j] + arr[i][j+1] + arr[i][j+2] + arr[i+1][j+1] + arr[i+2][j] +arr[i+2][j+1] + arr[i+2][j+2];
                if (sum > maxsum) {
                    maxsum = sum;
                }
            }

        }

        return maxsum;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

