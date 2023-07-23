package com.sjia.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

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
    public int[] maxSlidingWindowBrute(int[] nums, int k) {
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


    // ArrayDeque
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int resultIndex = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of the current window from the front of the deque
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove smaller elements from the end of the deque as they won't be candidates for maximum
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add the current index to the end of the deque
            deque.offerLast(i);

            // Start recording maximum values when the window reaches size k
            if (i >= k - 1) {
                result[resultIndex] = nums[deque.peekFirst()];
                resultIndex++;
            }
        }

        return result;
    }


    // two pass, MaxLeft, MaxRight
    public int[] maxSlidingWindowTwoPass(int[] nums, int k) {
        int n = nums.length;
        int[] MaxLeft = new int[n];
        int[] MaxRight = new int[n];
        int[] res = new int[n - k + 1];

        for (int i=0; i < n ; i++) {
            if(i %k == 0) {
                MaxLeft[i] = nums[i];
            } else {
                MaxLeft[i] = Math.max(MaxLeft[i-1], nums[i]);
            }
        }

        for (int i =n-1; i >=0; i--) {
            if ( i == n-1 || ( i +1) % k == 0 ) {
                MaxRight[i] = nums[i];
            } else {
                MaxRight[i] = Math.max(MaxRight[i+1], nums[i]);
            }
        }

        for (int i = 0; i <= n - k; i++) {
            res[i] = Math.max(MaxLeft[i + k-1], MaxRight[i]);  //note:  MaxLeft[i + k-1]
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
