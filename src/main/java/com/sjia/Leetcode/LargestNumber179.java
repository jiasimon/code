package com.sjia.Leetcode;

import java.util.*;

public class LargestNumber179 {

    // #179 https://leetcode.com/problems/largest-number/

    // [0,0]. output "00", Expected "0"

    // Runtime: 5 ms, faster than 76.86% of Java online submissions for Largest Number.
    //Memory Usage: 39.7 MB, less than 22.32% of Java online submissions for Largest Number.

    private class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);

        }
    }



    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> tmp = new ArrayList<>();
        for (int num: nums) {
            tmp.add(String.valueOf(num));
        }
        tmp.sort(new MyComparator());
        if (tmp.get(0).equals("0")) return "0";
        for ( String part: tmp) {
            sb.append(part);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        //int[] testData  = {0,0};
        int[] testData  = {3,30,34,5,9};

        LargestNumber179 solution = new LargestNumber179();
        String result = solution.largestNumber(testData);

        System.out.printf(" testData %s LargestNumber179 is %s \n",Arrays.toString(testData), result);
    }

}
