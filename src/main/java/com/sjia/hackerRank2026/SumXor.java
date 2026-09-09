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

    public static long sumXor(long n) {
        if (n == 0) return 1;
        int totalBits = 64 - Long.numberOfLeadingZeros(n);
        int res = totalBits - Long.bitCount(n);
        return 1L << res;
    }

    public static long sumXorByLoop(long n) {
        // Base case: If n is 0, the only valid x is 0
        if (n == 0) {
            return 1;
        }

        long unsetBits = 0;

        // Count the number of 0s in the binary representation of n
        // up to its most significant bit
        while (n > 0) {
            if ((n & 1) == 0) {
                unsetBits++;
            }
            n >>= 1; // Shift right to check the next bit
        }

        // Total combinations = 2^unsetBits
        // Using bitwise shift 1L << unsetBits is equivalent to Math.pow(2, unsetBits)
        return 1L << unsetBits;
    }

    public static void main(String[] args) {
        // Test Cases: [input, expectedOutput]
        long[][] testCases = {
                {0L, 1L},         // Edge Case: n = 0 -> x = 0
                {5L, 2L},         // 5 (101_2) -> 1 unset bit -> 2^1 = 2 (x = 0, 2)
                {10L, 4L},        // 10 (1010_2) -> 2 unset bits -> 2^2 = 4 (x = 0, 1, 4, 5)
                {1L, 1L},         // 1 (1_2) -> 0 unset bits -> 2^0 = 1 (x = 0)
                {1000000000000L, 1073741824L} // Large input test (handles 64-bit bounds)
        };

        boolean allPassed = true;

        for (int i = 0; i < testCases.length; i++) {
            long n = testCases[i][0];
            long expected = testCases[i][1];
            long actual = sumXor(n);

            if (actual == expected) {
                System.out.printf("Test %d PASSED: sumXor(%d) = %d%n", i + 1, n, actual);
            } else {
                System.out.printf("Test %d FAILED: sumXor(%d) = %d (Expected: %d)%n", i + 1, n, actual, expected);
                allPassed = false;
            }
        }

        if (allPassed) {
            System.out.println("\nAll test cases passed successfully!");
        }
    }



}
