package com.sjia.Leetcode;

public class PeakIndexMountainArray {
    // #852 https://leetcode.com/problems/peak-index-in-a-mountain-array/

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
    //Memory Usage: 39.9 MB, less than 48.12% of Java online submissions for Peak Index in a Mountain Array.
    public int peakIndexInMountainArray(int[] arr) {
        int  i=1;
        for ( ; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) return i;
        }
        return i;
    }

    


}
