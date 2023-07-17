package com.sjia.Leetcode;

import java.util.Arrays;

public class CountPrimes {

    // #204. Count Primes   https://leetcode.com/problems/count-primes/
    /*
    Given an integer n, return the number of prime numbers that are strictly less than n.
    Input: n = 10   Output: 4
    Input: n = 0    Output: 0
    Input: n = 1    Output: 0
    0 <= n <= 5 * 106
     */



    // Time Limit Exceeded
    public int countPrimesNormal(int n) {
        if (n<2) return 0;
        int result =0;
        for ( int i=2; i < n;  i++ ) {
            if (isPrime(i)) result++;
        }
        return result;
    }

    private boolean isPrime(int N) {
        if (N%2 ==0 || N < 2) return N==2;
        for (int i=2; i<= Math.sqrt(N); i++ ) {
            if (N%i ==0) return false;
        }
        return true;
    }


    // Runtime: 19 ms, faster than 55.19% of Java online submissions for Count Primes.
    //Memory Usage: 41.2 MB, less than 9.02% of Java online submissions for Count Primes.
/*
    int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        // init all to true
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i])
                for (int j = 2 * i; j < n; j += i)
                    isPrime[j] = false;
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }*/


    // Runtime: 13 ms, faster than 85.90% of Java online submissions for Count Primes.
    //Memory Usage: 38.5 MB, less than 8.34% of Java online submissions for Count Primes.

    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        int testData = 100;
        CountPrimes solution = new CountPrimes();
        int result = solution.countPrimes(testData);
        System.out.printf( "we have  %d Primes for %s ", result, testData);
    }

}
