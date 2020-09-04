package com.sjia.Leetcode;

public class BitsCountPrimaryNumber {
    // #762 https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
    // Given two integers L and R, find the count of numbers in the range [L, R] (inclusive)
    // having a prime number of set bits in their binary representation.

    // Runtime: 3 ms, faster than 96.51% of Java online submissions for Prime Number of Set Bits in Binary Representation.
    //Memory Usage: 36.4 MB, less than 72.85% of Java online submissions for Prime Number of Set Bits in Binary Representation.
    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for (int i=L; i<=R; i++) {
            int tmp = Integer.bitCount(i);
            if (isSmallPrime(tmp)) result++;
        }
        return result;
    }

    private boolean isSmallPrime(int tmp) {
        return (tmp==2 || tmp == 3 || tmp==5 || tmp==7 || tmp==11 || tmp==13
            || tmp==17 || tmp==19 || tmp==23);
    }

}
