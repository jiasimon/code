package com.sjia.Leetcode;

import java.util.Arrays;

public class CountPrimes {

    // #204. Count Primes   https://leetcode.com/problems/count-primes/
    /*
    Given an integer n, return the number of prime numbers that are strictly less than n.
    Input: n = 10   Output: 4
    Input: n = 0    Output: 0
    Input: n = 1    Output: 0
    Input: n = 10000    Output: 1229
    Input: n = 5000000  Output: 348513

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
    int countPrimesFilter(int n) {
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
    }


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
        System.out.println();

        // Test Case 1: Count the number of primes less than 10
        int n1 = 10;
        int result1 = solution.countPrimes(n1);
        System.out.println("Number of primes less than " + n1 + ": " + result1);

        // Test Case 2: Count the number of primes less than 20
        int n2 = 30;
        int result2 = solution.countPrimes(n2);
        System.out.println("Number of primes less than " + n2 + ": " + result2);

        // Test Case 3: Count the number of primes less than 30
        int n3 = 10000;
        int result3 = solution.countPrimes(n3);
        System.out.println("Number of primes less than " + n3 + ": " + result3);  // 1229


        int n4 = 5000000;
        int result4 = solution.countPrimes(n4);
        System.out.println("Number of primes less than " + n4 + ": " + result4);  // 348513
    }

}
