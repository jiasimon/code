package com.sjia.Leetcode;

public class MinMovesToEqualArrayElements453 {
    // #453. Minimum Moves to Equal Array Elements  https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

    /*
    Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.

    In one move, you can increment n - 1 elements of the array by 1.
    Input: nums = [1,2,3]       Output: 3
    Input: nums = [1,1,1]       Output: 0
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
     */

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int moves = 0;

        // Find the minimum element in the array
        for (int num : nums) {
            min = Math.min(min, num);
        }

        // Calculate the total moves needed to make all elements equal
        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }

    public static void main(String[] args) {
        MinMovesToEqualArrayElements453 solution = new MinMovesToEqualArrayElements453();
        int[] nums = {1, 2, 5};
        int minMoves = solution.minMoves(nums);
        System.out.println("Minimum moves to equal array elements: " + minMoves); // Output: 5
    }


}
