package com.sjia.Leetcode;

public class SuperPow {
    // #372. Super Pow  https://leetcode.com/problems/super-pow/description/

    /*
    Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
    Input: a = 2, b = [3]   Output: 8
    Input: a = 2, b = [1,0] Output: 1024

    1 <= a <= 2^31 - 1
    1 <= b.length <= 2000
    0 <= b[i] <= 9
    b does not contain leading zeros.
     */

    private static final int MOD = 1337;

    // 26 ms, 17.24%; 43.2 MB, 52.98%
    public int superPow(int a, int[] b) {
        if (b.length == 0) {
            return 1;
        }

        int lastDigit = b[b.length - 1];
        int[] newB = new int[b.length - 1];
        for (int i = 0; i < newB.length; i++) {
            newB[i] = b[i];
        }

        int part1 = powMod(a, lastDigit);
        int part2 = powMod(superPow(a, newB), 10);

        return (part1 * part2) % MOD;
    }

    private int powMod(int base, int exponent) {
        base %= MOD;
        int result = 1;

        for (int i = 0; i < exponent; i++) {
            result = (result * base) % MOD;
        }

        return result;
    }



    // 3 ms, 62.38%; 43.1 MB, 64.26%
//    private final int MOD = 1337;

    public int superPow2(int a, int[] b) {
        int ans = 1;

        a %= MOD;
        for (final int i : b)
            ans = powerMod(ans, 10) * powerMod(a, i) % MOD;

        return ans;
    }


    private int powerMod(int x, int y) {
        int pow = 1;
        x %= MOD;
        while (y-- > 0)
            pow = (pow * x) % MOD;
        return pow;
    }


    public static void main(String[] args) {
        SuperPow solution = new SuperPow();
        int a = 2;
        int[] b = {1,2};
        int result = solution.superPow2(a, b);
        System.out.println("Result: " + result); // Output: 85
    }



}
