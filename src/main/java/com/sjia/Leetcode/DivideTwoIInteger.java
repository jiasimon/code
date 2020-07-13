package com.sjia.Leetcode;

public class DivideTwoIInteger {

    // #29 Divide two integer https://leetcode.com/problems/divide-two-integers/

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
    //Memory Usage: 36.9 MB, less than 39.07% of Java online submissions for Divide Two Integers.

    // minus , or divisor addition, or bit operation
    // https://leetcode-cn.com/problems/divide-two-integers/solution/po-su-de-xiang-fa-mei-you-wei-yun-suan-mei-you-yi-/


    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1){
            if(dividend>Integer.MIN_VALUE) return -dividend;// 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        return dividend/divisor;

    }


}
