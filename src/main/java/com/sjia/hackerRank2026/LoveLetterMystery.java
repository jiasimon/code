package com.sjia.hackerRank2026;

public class LoveLetterMystery {
    // https://www.hackerrank.com/challenges/the-love-letter-mystery/problem?isFullScreen=true

    public static int theLoveLetterMystery(String s) {
        // Write your code here
        int res=0, n =s.length();
        char[] tmp =s.toCharArray();
        for (int i=0; i< n/2; i++) {
            res += Math.abs(tmp[i] - tmp[n-1-i]);
        }
        return res;
    }

    
}
