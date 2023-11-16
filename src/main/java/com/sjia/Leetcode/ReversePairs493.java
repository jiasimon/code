package com.sjia.Leetcode;

public class ReversePairs493 {
    // #493. Reverse Pairs  https://leetcode.com/problems/reverse-pairs/

    /*
    Given an integer array nums, return the number of reverse pairs in the array.

    A reverse pair is a pair (i, j) where:

    0 <= i < j < nums.length and
    nums[i] > 2 * nums[j].

    Input: nums = [1,3,2,3,1]       Output: 2
    Explanation: The reverse pairs are:
    (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
    (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1

    Input: nums = [2,4,3,5,1]   Output: 3
    Explanation: The reverse pairs are:
    (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
    (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
    (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1

    1 <= nums.length <= 5 * 10000
    -2^31 <= nums[i] <= 2^31 - 1
     */

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        int j = mid + 1;
        for (int i = start; i <= mid; i++) {
            while (j <= end && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }

        merge(nums, start, mid, end);
        return count;
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int idx = 0, left = start, right = mid + 1;

        while (left <= mid && right <= end) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

        while (right <= end) {
            temp[idx++] = nums[right++];
        }

        System.arraycopy(temp, 0, nums, start, temp.length);
    }

    public static void main(String[] args) {
        ReversePairs493 solution = new ReversePairs493();
        int[] nums = {1, 3, 2, 3, 1};

        int count = solution.reversePairs(nums);
        System.out.println("Number of Reverse Pairs: " + count);
    }



}
