package com.sjia.Leetcode;

public class Numberof1Bits {
    // #191. Number of 1 Bits https://leetcode.com/problems/number-of-1-bits/

    /*
    Write a function that takes the binary representation of an unsigned integer
    and returns the number of '1' bits it has (also known as the Hamming weight).
     */

    // Runtime: 1 ms, faster than 54.21% of Java online submissions for Number of 1 Bits.
    //Memory Usage: 38.8 MB, less than 5.01% of Java online submissions for Number of 1 Bits.


    //   return Integer.bitCount()


    // By String
    // 1ms, 45.24%; 39.50mb, 77.19%
    public int hammingWeightByString(int n) {
        String tmp = Integer.toBinaryString(n);
        int res = 0 ;
        for (int i=0; i <tmp.length(); i++) {
            if (tmp.charAt(i) == '1') res++;
        }
        return res;
    }



    // bit operation, n & 1
    // 0ms 100%; 39.3 MB 92.87%
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;   // We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
        }
        return count;
    }


    // n & (n-1)
    public int hammingWeightBit(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Numberof1Bits solution = new Numberof1Bits();

        // Test case
        int n = 00000000000000000000000000001011;
        int count = solution.hammingWeight(n);
        System.out.println("Number of 1 Bits: " + count);  // Expected output: 3
    }


}
