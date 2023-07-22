package com.sjia.Leetcode;

public class SlidingWindowMaximum {
    // #239. Sliding Window Maximum     https://leetcode.com/problems/sliding-window-maximum/   #hard
    /*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    Return the max sliding window.

    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4
    1 <= k <= nums.length

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3    Output: [3,3,5,5,6,7]
     */


    // brute force, TLE
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        for (int i=0; i < n-k+1; i++) {
            int end = i + k -1;
            int max = Integer.MIN_VALUE;
            for ( int j=i; j <= end; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }

        return res;
    }




    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = slidingWindowMaximum.maxSlidingWindow(nums, k);
        // Output: [3,3,5,5,6,7]
        for (int num : result) {
            System.out.print(num + " ");
        }
    }


}
