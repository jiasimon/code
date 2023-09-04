package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FormSmallestNumber2605 {
    // #2605. Form Smallest Number From Two Digit Arrays    https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays/description/

    /*
    Given two arrays of unique digits nums1 and nums2, return the smallest number that contains at least one digit from each array.

    Input: nums1 = [4,1,3], nums2 = [5,7]       Output: 15
    Input: nums1 = [3,5,2,6], nums2 = [3,1,7]   Output: 3

    1 <= nums1[i], nums2[i] <= 9
     */


    // Set
    // 2 ms, 36.57%; 40.2 MB, 88.64%
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> tmp = new HashSet();
        for (int n : nums2) {
            tmp.add(n);
        }
        for ( int n: nums1) {
            if (tmp.contains(n)) {
                return n;
            }
        }
        if ( nums1[0] < nums2[0]) return nums1[0] * 10 + nums2[0];
        return nums2[0] * 10 + nums1[0];

    }


}
