package com.sjia.hackerRank2026;

public class RecursiveDigitSum {
    // https://www.hackerrank.com/challenges/recursive-digit-sum/problem

/*    public static int superDigit(String n, int k) {
        // Write your code here
        String whole = n.repeat(k);
        String tmp = whole;
        while (tmp.length()>1) {
            int sum = 0;
            for ( char c : tmp.toCharArray()) {
//                sum += Integer.parseInt(c+"");
                sum += Character.getNumericValue(c)
            }
            tmp = sum+"";
        }
        return Integer.parseInt(tmp);
    }

    */

    public static int superDigit(String n, int k) {
        // Write your code here
        long tmp = 0;
        for (char c : n.toCharArray()) {
            // tmp += Character.getNumericValue(c);
            tmp += c - '0';
        }

        tmp *= k;
        return getSuperDigit(tmp);
    }

    public static int getSuperDigit(long num) {
        if (num <10) return (int)num;
        long sum = 0;
        while (num>0) {
            sum += num % 10;
            num /= 10;
        }
        return getSuperDigit(sum);
    }


}
