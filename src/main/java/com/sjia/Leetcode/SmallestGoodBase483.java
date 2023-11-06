package com.sjia.Leetcode;

public class SmallestGoodBase483 {
    // #483. Smallest Good Base     https://leetcode.com/problems/smallest-good-base/

    /*
    Given an integer n represented as a string, return the smallest good base of n.

    We call k >= 2 a good base of n, if all digits of n base k are 1's.

    Input: n = "13"     Output: "3"
    Explanation: 13 base 3 is 111.

    Input: n = "4681"   Output: "8"
    Explanation: 4681 base 8 is 11111.

    Input: n = "1000000000000000000"    Output: "999999999999999999"
    Explanation: 1000000000000000000 base 999999999999999999 is 11.

    n is an integer in the range [3, 1018].

     */


    // binary search
    // 2 ms, 70.15%; 40.7 MB, 29.85%
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);

        // Maximum possible length of the number in base 2 representation
        int maxLen = (int) (Math.log(num) / Math.log(2)) + 1;

        for (int len = maxLen; len > 2; len--) {
            long low = 2, high = (long) (Math.pow(num, 1.0 / (len - 1)) + 1);

            while (low <= high) {
                long mid = low + (high - low) / 2;

                long sum = 0;
                for (int i = 0; i < len; i++) {
                    sum = sum * mid + 1;
                }

                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return String.valueOf(num - 1); // For an input of form "11111..." where base is 2
    }

    public static void main(String[] args) {
        SmallestGoodBase483 solution = new SmallestGoodBase483();
        String n = "4681";

        String result = solution.smallestGoodBase(n);
        System.out.println("Smallest Good Base: " + result);
    }


}
