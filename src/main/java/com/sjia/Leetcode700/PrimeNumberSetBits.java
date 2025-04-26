package com.sjia.Leetcode700;

public class PrimeNumberSetBits {
    // #762. Prime Number of Set Bits in Binary Representation https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
    /*
    Input: L = 6, R = 10      Output: 4

    1 <= left <= right <= 10^6
    0 <= right - left <= 10000

     */

    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(Integer.bitCount(i))) {
                count++;
            }
        }
        return count;
    }

    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrimeNumberSetBits solution = new PrimeNumberSetBits();
        System.out.println(solution.countPrimeSetBits(6, 10)); // Output: 4
        System.out.println(solution.countPrimeSetBits(10, 15)); // Output: 5
    }

}
