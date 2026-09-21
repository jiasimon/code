package com.sjia.hackerRank2026;

public class TaumBirthday {
    // https://www.hackerrank.com/challenges/taum-and-bday

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // Write your code here
        long minblack = Math.min(bc, (long)(wc+z));
        long minwhite = Math.min(wc, (long)(bc+z));
        return (b*minblack + w*minwhite);
    }


}
