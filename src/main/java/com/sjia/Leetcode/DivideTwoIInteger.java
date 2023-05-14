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


    //
    // Left Shift (<<) shall be considered as multiplication by 2^N
    // Similarly, Right Shift (>>) shall be considered as division by 2^N
    public int divideTwoIInteger(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Corner case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow

        boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0, subQuot = 0;

        while (dividend - divisor >= 0) {
            for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
            quotient += 1 << subQuot; //Add to the quotient
            dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
        }
        return negative ? -quotient : quotient;
    }




    // https://leetcode.com/problems/divide-two-integers/solutions/142849/c-java-python-should-not-use-long-int/
    // follow up
    public int divide2(int A, int B) {
        if (A == 1 << 31 && B == -1) return (1 << 31) - 1;
        int a = Math.abs(A), b = Math.abs(B), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }

}
