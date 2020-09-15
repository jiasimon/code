package com.sjia.Leetcode;

public class PeakIndexMountainArray {
    // #852 https://leetcode.com/problems/peak-index-in-a-mountain-array/

    // Input: arr = [3,4,5,1]


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
    //Memory Usage: 39.9 MB, less than 48.12% of Java online submissions for Peak Index in a Mountain Array.
/*    public int peakIndexInMountainArray(int[] arr) {
        int  i=1;
        for ( ; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) return i;
        }
        return i;
    }*/


    // binarysearch, right bound open
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
    //Memory Usage: 39.5 MB, less than 90.62% of Java online submissions for Peak Index in a Mountain Array.
    public int peakIndexInMountainArray(int[] arr) {
        int  left = 0, right = arr.length-1;
        while (left < right) {
            int mid = left + (right -left) /2;
            if ( arr[mid] < arr[mid+1] ) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


}
