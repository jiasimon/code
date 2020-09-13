package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;


public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if ( !s.contains("a") || s.isEmpty() || s==null) {
            return 0;
        }
        long result = s.length()-s.replace("a", "").length();
        long groups = n/(s.length());
        long rest = n%(s.length());

        result = result * groups;

        for (int i=0; i< rest; i++) {
            if(s.charAt(i)=='a') result++;
        }

        System.out.println("result is: " + result  );
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}

