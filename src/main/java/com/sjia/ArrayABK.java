package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class ArrayABK {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int m, int[][] queries) {
        long max = 0;
        long total = 0;
        long[] temp = new long[n];

        for(int i=0; i<n; i++) {
            temp[i]=0;
        }

        for (int i = 0; i < m ; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1];
            int operation = queries[i][2];
            temp[a] += operation;
            if (b < n) {
                temp[b] -= operation;
            }
        }
        for(int i=0; i<n; i++) {
            total += temp[i];
            if(total> max) max=total;
        }
        //System.out.println(max);
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //test_01
        //5 3
        //1 2 100
        //2 5 100
        //3 4 100
        //
        //result is : 200

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, m, queries);

        System.out.println("result is : " + result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}
