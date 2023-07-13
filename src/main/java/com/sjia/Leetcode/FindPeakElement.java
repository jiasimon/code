package com.sjia.Leetcode;

public class FindPeakElement {
    // #162. Find Peak Element  https://leetcode.com/problems/find-peak-element/

    /*
    A peak element is an element that is strictly greater than its neighbors.
    You may imagine that nums[-1] = nums[n] = -∞.
    In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

    Input: nums = [1,2,3,1]     Output: 2
    Input: nums = [1,2,1,3,5,6,4]   Output: 5
     */



    // normal scan
    // 0 ms, 100% ; 41 MB, 92.62%
    public int findPeakElementNormal(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1] ) return 0;
        if (nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        for (int i=1; i< nums.length; i++) {
            if (nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                return i;
            }
        }
        return 0;
    }




    // binary search
    // 0 ms, 100% ; 41.5 MB, 41.58%,
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If the middle element is greater than its right neighbor,
            // there is a peak on the left side, so move right pointer to mid
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
            // Otherwise, there is a peak on the right side, so move left pointer to mid + 1
            else {
                left = mid + 1;
            }
        }
        return left;
    }


}
