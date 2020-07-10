package com.sjia;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

/*    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int valley = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : s.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;

            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++valley;
        }
        System.out.print(valley);
        return valley;

    }*/


    static int countingValleys(int n, String s) {
        int flag = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if(String.valueOf(s.charAt(i)).equalsIgnoreCase("U")) {
                flag++;
                if (flag==0) {
                    result++;
                }
            } else if (String.valueOf(s.charAt(i)).equalsIgnoreCase("D")) {
                flag--;
            }

        }
        System.out.println("valley number is : " + result);
        return result;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //sample input
        //8
        //UDDDUDUU

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();

        scanner.close();
    }
}