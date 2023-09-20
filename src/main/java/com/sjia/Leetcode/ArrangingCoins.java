package com.sjia.Leetcode;

public class ArrangingCoins {
    // #441. Arranging Coins https://leetcode.com/problems/arranging-coins/
    // 1,3,5
    // n is a non-negative integer


    // math, Runtime: 1 ms, faster than 100.00% of Java online submissions for Arranging Coins.
    //Memory Usage: 36.9 MB, less than 25.00% of Java online submissions for Arranging Coins.
    public int arrangeCoins(int n) {
        if (n==0) return 0;
        double result = (Math.sqrt(1 + 8.0 * n)-1) / 2;
        return (int)result;
    }



    // iterative
    // 5 ms, 56.38%; 40.2 MB, 16.94%
    public int arrangeCoins_iterative(int n) {
        int i=1;
        while ( n > 0) {
            i++;
            n = n-i;
        }
        return i-1;
    }


    // binary search sum
    // 1 ms, 100%; 39.5 MB, 74.85%
    public int arrangeCoins_binary(int n) {
        long left = 0;
        long right = n;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2; // Sum of the first mid natural numbers

            if (sum == n) {
                return (int) mid; // Found a perfect arrangement
            } else if (sum < n) {
                left = mid + 1; // Try a larger number of rows
            } else {
                right = mid - 1; // Try a smaller number of rows
            }
        }

        return (int) right; // Return the largest n such that sum is less than or equal to n
    }


    /*
    (x+1)x=2n
    x=-1+sqrt(1+8n)
    long for overflow
     */
    public int arrangeCoins_math(int n) {
        return (int) ((Math.sqrt((long) 8 * n + 1) - 1) / 2);
    }




    public static void main(String[] args) {
        int testData  = 1804289383;
        ArrangingCoins solution = new ArrangingCoins();
        int result = solution.arrangeCoins_math(testData);

        System.out.printf("testData %s arrangeCoins is %s \n", testData,result); // 60070
    }

}
