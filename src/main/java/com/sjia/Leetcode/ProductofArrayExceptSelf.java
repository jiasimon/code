package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductofArrayExceptSelf {
    // #238. Product of Array Except Self https://leetcode.com/problems/product-of-array-except-self/ #fb
    /*
         Given an array nums of n integers where n > 1,
         return the product of all the elements of nums except nums[i]
         Note: Please solve it without division and in O(n).

     */


    // Input:  [1,2,3,4]    Output: [24,12,8,6]


    // Brute Force
    public int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for ( int i =0; i < n ; i++) {
            int tmp =1;
            for (int j = 0; j < n; j++ ) {
                if (j != i) {
                    tmp *= nums[j];
                }
            }
            res[i] = tmp;
        }
        return res;
    }


    // Runtime: 1 ms, faster than 99.99% of Java online submissions for Product of Array Except Self.
    // Memory Usage: 50.2 MB, less than 22.63% of Java online submissions for Product of Array Except Self.
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

    // if no 0 element, divide
    public int[] productExceptSelfFromTotal(int[] nums) {
        int n = nums.length, total=1;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            total *= nums[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = total / nums[i];
        }
        return res;
    }


    // 2ms, 52.52%; 53.22mb, 42.33%
    public int[] productExceptSelfFromDivide(int[] nums) {
        int n = nums.length, total=1;
        int[] res = new int[n];
        List<Integer> indexZero = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            total *= nums[i];
            if(nums[i] == 0) {
                indexZero.add(i);
            }
        }
        if ( total != 0) {
            for (int i = 0; i < n; i++) {
                res[i] = total / nums[i];
            }
        } else {
            if (indexZero.size() > 1) {
//                Arrays.fill(res, 0);
                return res;
            } else {
                int p = indexZero.get(0);
                total = 1;
                for (int i = 0; i < n; i++) {
                    if(i != p) {
                        total *= nums[i];
                    }
                }
                res[p] = total;
            }
        }
        return res;
    }



    // prefix product, like memo,
    public int[] productExceptSelfPre(int[] nums) {
        int n = nums.length;
        int pre[] = new int[n];
        int post[] = new int[n];
        pre[0] = 1;
        post[n - 1] = 1;

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            post[i] = post[i + 1] * nums[i + 1];
        }

        int res[] = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = pre[i] * post[i];
        }
        return res;
    }



    public static void main(String[] args) {
//        int[] testData = {1,2,3,4,5};
        int[] testData = {-1,1,0,-3,3};
        int[] testData3 = {-1,1,0,0,-3,3};
        ProductofArrayExceptSelf solution = new ProductofArrayExceptSelf();
        int[] result = solution.productExceptSelfFromDivide(testData);
        System.out.println("testData is: " + Arrays.toString(testData));
        System.out.println("result is: " + Arrays.toString(result));

    }


}
