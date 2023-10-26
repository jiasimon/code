package com.sjia.Leetcode;

import java.util.Arrays;

public class MinimumMovesToEqualArray2 {
    // #462. Minimum Moves to Equal Array Elements II   https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/

    /*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

    In one move, you can increment or decrement an element of the array by 1.

    Test cases are designed so that the answer will fit in a 32-bit integer
    Input: nums = [1,2,3]       Output: 2
    Input: nums = [1,10,2,9]    Output: 16

    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9

     */

    // sort, median
    //
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2]; // Median value

        int moves = 0;
        for (int num : nums) {
            moves += Math.abs(num - median);
        }

        return moves;
    }



    // nums[j]-nums[i]
    public int minMoves2_twoPointer(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        int res = 0;
        while(i < j){
            res += nums[j]-nums[i];
            i++;
            j--;
        }
        return res;

    }

    public static void main(String[] args) {
        MinimumMovesToEqualArray2 solution = new MinimumMovesToEqualArray2();
        int[] nums = {1, 2, 3};

        int minMoves = solution.minMoves2_twoPointer(nums);
        System.out.println("Minimum Moves: " + minMoves); // Output: 2
    }


}
