package com.sjia.Leetcode;

import java.util.Arrays;

public class NextPermutation {

    // #31 https://leetcode.com/problems/next-permutation/  #fb
    // Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    //If such an arrangement is not possible, it must rearrange it as the lowest possible order

    // {1,2,7,4,3,1}

    // Runtime: 1 ms, faster than 51.91% of Java online submissions for Next Permutation.
    // Memory Usage: 41 MB, less than 5.00% of Java online submissions for Next Permutation.


    // 1) from right to left , find first i, nums[i] < nums[i+1]
    // 2) from right to left, find j, first nums[j] > nums[i], swap i and j
    // 3) reverse i+1 to the end 
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Next Permutation.
    //Memory Usage: 39 MB, less than 75.18% of Java online submissions for Next Permutation.
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1] ) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        NextPermutation solution = new NextPermutation();
        int[] testData = {1,2,7,4,3,1};
        System.out.println("testData is: " + Arrays.toString(testData));
        solution.nextPermutation(testData);
        System.out.println("next Permutation is: " + Arrays.toString(testData));
    }

}
