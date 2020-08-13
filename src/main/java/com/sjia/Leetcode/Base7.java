package com.sjia.Leetcode;

public class Base7 {
    // #504 https://leetcode.com/problems/base-7/

    // Runtime: 1 ms, faster than 90.88% of Java online submissions for Base 7.
    //Memory Usage: 36.8 MB, less than 83.81% of Java online submissions for Base 7.
    public String convertToBase7(int num) {
        if (num<0) return "-" + convertToBase7(-num);
        if (num<7) return Integer.toString(num);
        return convertToBase7( num/7) + Integer.toString(num%7);
    }


}
