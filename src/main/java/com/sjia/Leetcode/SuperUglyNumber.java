package com.sjia.Leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SuperUglyNumber {
    // #313. Super Ugly Number  https://leetcode.com/problems/super-ugly-number/description/
    /*
    A super ugly number is a positive integer whose prime factors are in the array primes.

    Given an integer n and an array of integers primes, return the nth super ugly number.

    The nth super ugly number is guaranteed to fit in a 32-bit signed integer.

    Input: n = 12, primes = [2,7,13,19] Output: 32
    Input: n = 1, primes = [2,3,5]  Output: 1

     */


    // PriorityQueue and hashset
    // TLE,  86 / 87  n = 10000
    public int nthSuperUglyNumber_HashSet(int n, int[] primes) {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        seen.add(1L);
        pq.offer(1L);
        int ugly = 0;
        for (int i=0; i < n; i++) {
            long curr = pq.poll();
            ugly = (int) curr;

            for ( int prime : primes) {
                if (seen.add(curr * prime)) pq.offer(curr * prime);
            }

        }
        return ugly;
    }


    // if( ugly % prime == 0) break;
    // 76ms, 53.68%; 55.60mb; 5.22%
    public int nthSuperUglyNumber_PriorityQueue(int n, int[] primes) {
        // Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();

        // seen.add(1L);
        pq.offer(1L);
        int ugly = 0;
        for (int i=0; i < n; i++) {
            long curr = pq.poll();
            ugly = (int) curr;

            for ( int prime : primes) {
                pq.offer(curr * prime);
                if( ugly % prime == 0) break;
            }

        }
        return ugly;
    }


    // array pointer
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] superUgly = new int[n];
        int[] indexes = new int[primes.length];
        superUgly[0] = 1;

        for (int i = 1; i < n; i++) {
            int nextUgly = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                nextUgly = Math.min(nextUgly, primes[j] * superUgly[indexes[j]]);
            }

            for (int j = 0; j < primes.length; j++) {
                if (nextUgly == primes[j] * superUgly[indexes[j]]) {
                    indexes[j]++;
                }
            }

            superUgly[i] = nextUgly;
        }

        return superUgly[n - 1];
    }


    public static void main(String[] args) {
        SuperUglyNumber solution = new SuperUglyNumber();
        int[] primes = {2, 7, 13, 19};
        int n = 12;
        int result = solution.nthSuperUglyNumber(n, primes);
        System.out.println(result); // Output: 32

        n = 100;
        result = solution.nthSuperUglyNumber(n, primes);
        System.out.println(result);  // Output: 5408
    }

}
