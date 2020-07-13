package com.sjia.Leetcode;

import java.util.Arrays;

public class RemoveElement27 {

    // #27 remove Element, https://leetcode.com/problems/remove-element/
    // similar to #26 removeDup
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    // Memory Usage: 40 MB, less than 5.09% of Java online submissions for Remove Element.

    // add if(nums.length ==0) return 0;
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    //Memory Usage: 37.8 MB, less than 80.90% of Java online submissions for Remove Element.


    // num=[1，2，3，5，4]，Val=4 ; num=[4，1，2，3，5]，Val=4
    // switch last item  Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
    //Memory Usage: 38 MB, less than 68.05% of Java online submissions for Remove Element.

/*    static int removeElement(int[] nums, int val) {
        if(nums.length ==0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }*/


    static int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n==0) return 0;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }



    public static void main(String[] args) {

        // int[] testData = {0,0,1,1,1,2,2,3,3,4,5};
        // int[] testData = {1,2,2,2,5,2};
        int[] testData = {1,2,3,4,5,6};
        int element = 2;
        int result = removeElement(testData, element);

        System.out.printf("After removing element: %d, total length is: %d", element,  result);
    }
}
