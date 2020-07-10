package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pair = 0 ;
        Set<Integer> tmp = new HashSet<>();

        // use ar length
        for (int i=0; i < ar.length; i++) {
            if (!tmp.contains(ar[i])) {
                tmp.add(ar[i]);
            } else {
                pair++;
                tmp.remove(ar[i]);
            }
        }
        System.out.println("pair number is:  " + pair);
        return pair;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //9
        //10 20 20 10 10 30 50 10 20

        //choose HashSet over ArrayList , The call to contains() on colors will be O(1) for a HashSet versus O(n) for a List,
        // and you won't store duplicates. The listing above can be improved by using the output of remove
        // instead of calling contains first. You can also add directly to the Set when reading from Stdin
        // rather than storing values first and iterating through them.

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);


//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

