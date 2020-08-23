package com.sjia.Leetcode;

public class BinarySearch {

    // #704 https://leetcode.com/problems/binary-search/
    // assume that all elements in nums are unique.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
    //Memory Usage: 53.5 MB, less than 5.02% of Java online submissions for Binary Search.
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left=0, right= nums.length-1;
        while(left <= right) {
            int mid = (left + right) /2;
            if(nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right =mid-1;
            }
        }
        return -1;
    }

}
