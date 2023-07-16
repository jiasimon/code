package com.sjia.Leetcode;

import java.util.*;

public class LargestNumber179 {

    // #179. Largest Number https://leetcode.com/problems/largest-number/

    /*
    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
    Input: nums = [10,2]    Output: "210"
    Input: nums = [3,30,34,5,9] Output: "9534330"
     */

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
        if (tmp.get(0).equals("0")) return "0"; // {0,0};
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


        // Test case 1
        int[] nums1 = {10, 2};
        String largestNumber1 = solution.largestNumber(nums1);
        System.out.println("Largest Number Test Case 1: " + largestNumber1);  // Expected output: "210"

        // Test case 2
        int[] nums2 = {3, 30, 34, 5, 9};
        String largestNumber2 = solution.largestNumber(nums2);
        System.out.println("Largest Number Test Case 2: " + largestNumber2);  // Expected output: "9534330"

        // Test case 3
        int[] nums3 = {1};
        String largestNumber3 = solution.largestNumber(nums3);
        System.out.println("Largest Number Test Case 3: " + largestNumber3);  // Expected output: "1"

        // Test case 4
        int[] nums4 = {10};
        String largestNumber4 = solution.largestNumber(nums4);
        System.out.println("Largest Number Test Case 4: " + largestNumber4);  // Expected output: "10"

    }

}
