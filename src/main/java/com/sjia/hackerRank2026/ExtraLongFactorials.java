package com.sjia.hackerRank2026;

import java.math.BigInteger;

public class ExtraLongFactorials {
    // https://www.hackerrank.com/challenges/extra-long-factorials/

    public static void extraLongFactorials(int n) {

        BigInteger res = BigInteger.ONE;
        for (int i=2; i <= n; i++) {
            res = res.multiply( BigInteger.valueOf(i));
        }
        System.out.println(res);

    }

}
