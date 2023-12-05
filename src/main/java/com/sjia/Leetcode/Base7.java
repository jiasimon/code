package com.sjia.Leetcode;

public class Base7 {
    // #504. Base 7 https://leetcode.com/problems/base-7/

    // Runtime: 1 ms, faster than 90.88% of Java online submissions for Base 7.
    //Memory Usage: 36.8 MB, less than 83.81% of Java online submissions for Base 7.
    public String convertToBase7_old(int num) {
        if (num<0) return "-" + convertToBase7(-num);
        if (num<7) return Integer.toString(num);
        return convertToBase7( num/7) + Integer.toString(num%7);
    }



    public String convertToBase7(int num) {
        if (num == 0) return "0";

        StringBuilder result = new StringBuilder();
        boolean isNegative = num < 0;

        if (isNegative) {
            num = -num;
        }

        while (num > 0) {
            int remainder = num % 7;
            result.append(remainder);
            num /= 7;
        }

        if (isNegative) {
            result.append("-");
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Base7 solution = new Base7();

        int num = 100;

        String base7Representation = solution.convertToBase7(num);
        System.out.println("Base 7 representation of " + num + " is: " + base7Representation);
    }

}
