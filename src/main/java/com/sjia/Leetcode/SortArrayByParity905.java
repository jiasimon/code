package com.sjia.Leetcode;

public class SortArrayByParity905 {
    // #905. Sort Array By Parity   https://leetcode.com/problems/sort-array-by-parity/
    /*
    Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

    Return any array that satisfies this condition.
    Input: nums = [3,1,2,4]
    Output: [2,4,3,1]
    Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

    1 <= nums.length <= 5000
    0 <= nums[i] <= 5000
     */


    public int[] sortArrayByParity(int[] A) {
        int[] sortedArray = new int[A.length];
        int left = 0;  // Index for adding even elements to the beginning
        int right = A.length - 1;  // Index for adding odd elements to the end

        for (int num : A) {
            if (num % 2 == 0) {
                sortedArray[left++] = num;  // Add even element to the beginning
            } else {
                sortedArray[right--] = num;  // Add odd element to the end
            }
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();
        int[] A = {3, 1, 2, 4};
        int[] sortedArray = solution.sortArrayByParity(A);

        System.out.print("Sorted Array By Parity: ");
        for (int num : sortedArray) {
            System.out.print(num + " ");
        }
        // Output: Sorted Array By Parity: 2 4 3 1
    }


}
