package com.sjia.Leetcode;

public class BinaryGap {
    // #868 https://leetcode.com/problems/binary-gap/

    // 8 in binary is 0b1000 , return 0
    // 6 in binary is 0b110 return 1
    // 22 in binary is 0b10110, return 2

    // Runtime: 1 ms, faster than 56.20% of Java online submissions for Binary Gap.
    // Memory Usage: 36.6 MB, less than 40.82% of Java online submissions for Binary Gap.
/*    public int binaryGap(int N) {
        if (Integer.bitCount(N) == 1) return 0;
        String tmp = Integer.toBinaryString(N);
        int pre = -1, res = 0;
        for ( int i=0; i < tmp.length(); i++) {
            if ( tmp.charAt(i)== '1' ) {
                if (pre == -1) pre = i;
                else {
                    res = Math.max(res, i -pre);
                    pre = i;
                }
            }

        }
        return res;

    }*/



    // Runtime: 1 ms, faster than 56.20% of Java online submissions for Binary Gap.
    // Memory Usage: 38 MB, less than 22.48% of Java online submissions for Binary Gap.

    // comment bitCount(), use shift instead of /2
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Gap.
    //Memory Usage: 36 MB, less than 87.60% of Java online submissions for Binary Gap.
    public int binaryGap(int N) {
        // if (Integer.bitCount(N) == 1) return 0;
        int d= -40, res=0;
        while (N>0) {
            if ( N%2 == 1) {
                res = Math.max(res, d);
                d = 0;
            }
            d++;
            // N = N/2;
            N >>= 1;
        }
        return res;
    }

}
