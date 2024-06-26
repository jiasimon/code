package com.sjia.Leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {
     // #611. Valid Triangle Number https://leetcode.com/problems/valid-triangle-number/description/
    /*
    #interview
    Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

    Input: nums = [2,2,3,4] Output: 3
    2,3,4 (using the first 2)
    2,3,4 (using the second 2)
    2,2,3

    Input: nums = [4,2,3,4]     Output: 4

    1 <= nums.length <= 1000
    0 <= nums[i] <= 1000
     */


    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < n - 1 && nums[i] != 0; j++) {
                while (k < n && nums[i] + nums[j] > nums[k]) {
                    k++;
                }
                res += k - j - 1;
            }
        }

        return res;
    }


    // 3 for loop
    // 640ms, 18.01%; 42.84MB, 93.36%
    public int triangleNumber_threeloop(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1 && nums[i] != 0; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }

        return res;
    }


    // two pointer
    public int triangleNumber_twoPointer(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int res = 0;

        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        ValidTriangleNumber solution = new ValidTriangleNumber();

        // Test Case
        int[] nums = {2, 2, 3, 4};
        System.out.println("Test Case 1: " + solution.triangleNumber_threeloop(nums)); // Output: 3
    }

}
