package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IncreasingTripletSubsequence {
    // #334. Increasing Triplet Subsequence https://leetcode.com/problems/increasing-triplet-subsequence/
    /*
    Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

    Input: nums = [1,2,3,4,5]   Output: true    Explanation: Any triplet where i < j < k is valid.
    Input: nums = [5,4,3,2,1]   Output: false

    1 <= nums.length <= 5 * 10^5
    -2^31 <= nums[i] <= 2^31 - 1

     */

    // two pointer
    // 2ms, 98.61%; 131.75mb, 47.65%
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 2) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }



    // leftMin, rightMax, 3 pass
    // 6ms, 14.72%; 125.90mb; 91.61%
    public boolean increasingTriplet_3Pass(int[] nums) {
        int n = nums.length;
        if (n<2) return false;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        }

        rightMax[n-1] = nums[n-1];
        for (int j = n-2; j>=0; j--) {
            rightMax[j] = Math.max(nums[j], rightMax[j+1]);
        }
        for (int i=1; i < n-1; i++) {
            if(nums[i] > leftMin[i-1]  && nums[i] < rightMax[i + 1]){
                return true;
            }
        }

        return false;

    }

    // compare to #300 LIS
    // DP,  75 / 80
    public boolean increasingTriplet_LIS(int[] nums) {
        if (nums.length < 2) return false;

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int res = 1;

        for ( int i=1; i < n ; i++) {
            for (int j=0; j < i; j++ ) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] == 3) return true;
                }
            }
        }
        return false;
    }



    //LIS  binary search
    // 48ms, 5.06%; 128.80mb 89.65%
    public boolean increasingTriplet_LIS_binary(int[] nums) {
        int n = nums.length;
        if (n<2) return false;
        int res=0;
        int[] f = new int[n+1];

        Arrays.fill(f, Integer.MAX_VALUE);

        for (int i=0; i < n; i++) {
            int tmp = nums[i];
            int l=1, r= i+1;   // l=0 or l=1
            while ( l < r) {
                int mid = l + (r - l) / 2;
                if (f[mid] < nums[i]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            f[r] = nums[i];
            res = Math.max(res, r);
        }
        return res >= 3;

    }




    // LIS_Piles, Collections.binarySearch
    // ~pile,  (-(insertion point) - 1)
    // 23 ms, 5.6%, 127.7 MB; 91.18%
    public boolean increasingTriplet_LIS_Piles(int[] nums) {

        List<Integer> piles = new ArrayList<>(nums.length);
        for (int num : nums) {
            int pile = Collections.binarySearch(piles, num);
            if (pile < 0) pile = ~pile;
            if (pile == piles.size()) {
                piles.add(num);
            } else {
                piles.set(pile, num);
            }
        }
        return piles.size() >= 3;

    }



    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution.increasingTriplet_LIS_Piles(nums)); // Output: true (Increasing triplet subsequence: [1, 2, 3])

        int[] nums2 = {5,1,6};
        System.out.println(solution.increasingTriplet_LIS_Piles(nums2)); // False


        int[] nums3 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(solution.increasingTriplet_LIS_Piles(nums3));




    }
}
