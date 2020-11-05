package com.sjia.Leetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    // #238 https://leetcode.com/problems/product-of-array-except-self/ #fb


    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] testData = {1,2,3,4,5};
        //int[] testData = {0,0};
        ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();
        int[] result = solution.productExceptSelf(testData);
        System.out.println("testData is: " + Arrays.toString(testData));
        System.out.println("result is: " + Arrays.toString(result));

    }


}
