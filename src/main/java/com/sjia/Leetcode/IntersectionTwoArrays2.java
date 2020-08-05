package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionTwoArrays2 {

    // #350 https://leetcode.com/problems/intersection-of-two-arrays-ii/
    // Input: nums1 = [1,2,2,1], nums2 = [2,2], Output: [2,2]

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


}
