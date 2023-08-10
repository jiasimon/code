package com.sjia.hackerRank;

import java.io.*;
import java.util.stream.IntStream;

public class AlternatingCharacters {
    /*
    https://www.hackerrank.com/challenges/alternating-characters/problem?isFullScreen=true&h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=strings
     */

    public static int alternatingCharacters(String s) {
        // Write your code here
        int res =0;
        for ( int i=0;  i < s.length() -1; i++) {
            if (s.charAt(i+1) == s.charAt(i)) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        String s1 = "AAAA";
        String s2 = "ABABABB";
        alternatingCharacters(s1);

        System.out.println(s1 +  " alternatingCharacters: " + alternatingCharacters(s1));

        System.out.println(s2 +  " alternatingCharacters: " + alternatingCharacters(s2));


/*
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                int result = AlternatingCharacters.alternatingCharacters(s);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
        */
    }

}
