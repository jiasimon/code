package com.sjia.Leetcode;

public class MinimumRotatedSortedArray2 {
    // #154. Find Minimum in Rotated Sorted Array II    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    /*
    For example, the array nums = [0,1,4,4,5,6,7] might become:
    [4,5,6,7,0,1,4] if it was rotated 4 times.
    [0,1,4,4,5,6,7] if it was rotated 7 times.
    Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

    compare to #81
    0,0,0,1,2
    1,2,0,0,0
    0,1,2,0,0

    or example:  [1, 0, 1, 1, 1] and [1, 1, 1, 0, 1].
     */

    // right--, return nums[left], Binary
    // 0 ms, 100% ; 43.1 MB, 65.94%
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;

        while(left < right) {
            int mid = (left + right) /2;
            if ( nums[mid] > nums[right]) {
                left = mid + 1;
            } else if ( nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];

    }

}
