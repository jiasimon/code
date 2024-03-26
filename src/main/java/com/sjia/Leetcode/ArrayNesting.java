package com.sjia.Leetcode;

public class ArrayNesting {
    // #565. Array Nesting  https://leetcode.com/problems/array-nesting/description/
    /*
    Input: nums = [5,4,0,3,1,6,2]   Output: 4
    Explanation:
    nums[0] = 5, nums[1] = 4, nums[2] = 0, nums[3] = 3, nums[4] = 1, nums[5] = 6, nums[6] = 2.
    One of the longest sets s[k]:
    s[0] = {nums[0], nums[5], nums[6], nums[2]} = {5, 6, 2, 0}

    Input: nums = [0,1,2]       Output: 1

    1 <= nums.length <= 10^5
    All the values of nums are unique.
     */

    // mark visited as -1
    public int arrayNesting(int[] nums) {
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int current = i;
                int length = 0;
                while (nums[current] != -1) {
                    int next = nums[current];
                    nums[current] = -1; // Mark as visited
                    current = next;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ArrayNesting solution = new ArrayNesting();

        int[] testArray = {5, 4, 0, 3, 1, 6, 2};

        System.out.println("Test Case 1: " + solution.arrayNesting(testArray)); // Output: 4
    }



}
