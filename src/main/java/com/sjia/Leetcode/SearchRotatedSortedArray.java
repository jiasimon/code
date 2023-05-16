package com.sjia.Leetcode;

import java.util.Arrays;

public class SearchRotatedSortedArray {

    // #33 Search in Rotated Sorted Array https://leetcode.com/problems/search-in-rotated-sorted-array/

    // binary search, erfen
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
    //Memory Usage: 40 MB, less than 7.63% of Java online submissions for Search in Rotated Sorted Array.

    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4

    static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0]==target ? 0:-1 ;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (nums[mid] == target) return mid;
            if ( nums[l] <= nums[mid]) {
                if ( target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[r] ) {
                   l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    static int searchRotatedSortedArray(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0]==target ? 0:-1 ;
        int l=0, r = nums.length-1;
        while ( l<=r) {
            int mid = l + (r-l)/2; // (l+r)/2 could be out of range
            if( nums[mid]== target) return mid;
            if (nums[l] <= nums[mid])
            { // Left half is sorted
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {  // Right half is sorted
                if (target <= nums[r] && target > nums[mid] ) {
                    l = mid + 1;
                } else {
                    r = mid -1;
                }
            }
            
        }

        return -1;
    }

    public static void main(String[] args) {
        // int range:  -2147483648～2147483647


         int [] testData ={1,3};
        // int [] testData ={1};
        // int []  testData  = { 7,0,1,2,4,5,6};
        //int []  testData  = { 4,5,6,7,0,1,2};
        int target = 1;
        int result = search(testData, target);

        System.out.printf(" Search %d in Rotated SortedArray %s, result : %s ", target,
                Arrays.toString(testData), result);
    }


}
