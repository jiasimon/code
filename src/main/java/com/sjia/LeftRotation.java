package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {

    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
/*        if (d > a.length) {
            System.out.println("d should be less than a.length");
        }
        d = d % a.length;
        int result[] = new int[a.length];
        for (int i =0 ; i< a.length; ++i) {
            result[i] = a[ (i+d) % a.length ];
        }
        return result;*/

        /* To handle if d >= n */
        d = d % a.length;
        int i, j, k, temp;
        int result_gcd = gcd(d, a.length);
        for (i = 0; i < result_gcd; i++) {
            /* move i-th values of blocks */
            temp = a[i];
            j = i;
            while (true) {
                k = j + d;
                if (k >= a.length)
                    k = k - a.length;
                if (k == i)
                    break;
                a[j] = a[k];
                j = k;
            }
            a[j] = temp;
        }
        return a;
    }


    static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

