package com.sjia.hackerRank2026;

public class FindDigits {
    // https://www.hackerrank.com/challenges/find-digits

    // keep orig
    int findDigits(int n) {
        int res=0, orig = n;
        while (n> 0) {
            int tmp = n%10;
            if (tmp!=0 && (orig % tmp ==0)) {
                res++;
            }
            n =n/10;
        }
        return res;
    }

}
