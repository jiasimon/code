package com.sjia.hackerRank2026;

import java.util.List;

public class BetweenTwoSets {
    // https://www.hackerrank.com/challenges/between-two-sets

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
        int lcmA = a.get(0);
        for (int i=1; i<a.size(); i++) {
            lcmA = lcm(lcmA, a.get(i));
        }

        int gcdB = b.get(0);
        for (int i=1; i< b.size(); i++){
            gcdB = gcd(gcdB, b.get(i));
        }

        int res=0;
        for (int i=lcmA; i<= gcdB; i= i+lcmA) {
            if (gcdB % i == 0) {
                res++;
            }
        }
        return res;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / gcd(a, b);
    }


}
