package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumBribes {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

/*       int result = 0;
        for (int i=0; i < q.length; i++) {
            if ( q[i]-(i+1) > 2 ){
                System.out.println("Too chaotic");
                return;
            }
            for (int j= Math.max((q[i] - 2),0 ); j < i; j++ ) {
            //for (int j= (q[i] - 2 >= 0 ? (q[i] - 2):0 ); j < i; j++ ) {
            //for (int j= 0; j < i; j++ ) {
                if (q[j] > q[i]) result++;
            }
        }

        System.out.println(result);*/

        int result = 0;
        int size = q.length;

        for (int i = size-1; i>=0; i--) {
            int expected = i + 1;
            if (q[i] != expected) {
                if (i >= 1 && expected == q[i-1] ) {
                    ++result;
                    q[i-1] = q[i];
                    q[i] = expected;
                } else if (i >= 2 && expected == q[i-2] ) {
                    result += 2;
                    q[i-2]=q[i-1];
                    q[i-1]=q[i];
                    q[i] = expected;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(result);



    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

