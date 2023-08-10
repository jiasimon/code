package com.sjia.hackerRank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SpecialStringAgain {
    // https://www.hackerrank.com/challenges/special-palindrome-again/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings

    static long substrCount(int n, String str) {
        int res = n; // Sring of single char counts
        for (int i = 0; i < str.length(); i++) {
            char iIndexChar = str.charAt(i);

            int middleCharIndex = -1;

            for (int j = i+1; j < str.length(); j++) {
                char jIndexChar = str.charAt(j);

                // Check for characters except the middle one are the same and
                // All of the characters are the same
                if (iIndexChar == jIndexChar) {
                    if ( (middleCharIndex == -1) || (j - middleCharIndex) == (middleCharIndex - i)) {
                        res++;
                    }
                } else if (middleCharIndex == -1) {
                    middleCharIndex = j;
                } else {
                    break;
                }
            }
        }
        return res;

    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s1 = "asasd";
        String s2 = "mnonopoo";
        System.out.println(s1 + " SpecialStringAgain: " + substrCount(5,s1));

        String s3 = "aasaad";
        System.out.println(s3 + " SpecialStringAgain: " + substrCount(6,s3));



/*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        */
    }


}
