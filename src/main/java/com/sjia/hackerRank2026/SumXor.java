package com.sjia.hackerRank2026;

public class SumXor {
    // https://www.hackerrank.com/challenges/sum-vs-xor/problem
    // https://www.hackerrank.com/challenges/one-month-preparation-kit-sum-vs-xor/

    // faield on 1099511627776,  if n has its highest set bit at position 40 (e.g., n = 2^40), then res = 40
    // Actual with 1 << 40: Java computes 1 << (40 % 32) = 1 << 8 = 256 — it happens with no exception, no warning
    public static long sumXor_failed(long n) {
        // Write your code here
        if (n==0) return 1;
        int totalbits = 64 - Long.numberOfLeadingZeros(n);
        int res = totalbits - Long.bitCount(n);
        return 1 << res ;
    }

    

}
