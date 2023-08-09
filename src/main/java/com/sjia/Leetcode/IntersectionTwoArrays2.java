package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionTwoArrays2 {

    // #350. Intersection of Two Arrays II https://leetcode.com/problems/intersection-of-two-arrays-ii/

    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

    Input: nums1 = [1,2,2,1], nums2 = [2,2]     Output: [2,2]
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9]

     */


    // Runtime: 2 ms, faster than 98.86% of Java online submissions for Intersection of Two Arrays II.
    //Memory Usage: 39.9 MB, less than 9.07% of Java online submissions for Intersection of Two Arrays II.
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);

        HashMap<Integer, Integer> tmp = new HashMap<>();
        for (int n : nums1) {
            tmp.put(n, tmp.getOrDefault(n,0)+1);
        }

        int[] result = new int[nums1.length ];
        int i=0;
        for (int k: nums2) {
            int count= tmp.getOrDefault(k,0);
            if ( count > 0){
                result[i++]=k;
                count--;
                if (count==0) tmp.remove(k);
                else tmp.put(k,count);
            }
        }
        return Arrays.copyOf(result, i);

    }


    public static void main(String[] args) {
        IntersectionTwoArrays2 solution = new IntersectionTwoArrays2();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solution.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result)); // Output: [2, 2]
    }


}
