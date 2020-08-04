package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionTwoArrays {
    // #349 https://leetcode.com/problems/intersection-of-two-arrays/

    // Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2]
    // Input: [4,9,5], [9,4,9,8,4], Output [4,9,0], Expected [9,4]

    // Runtime: 2 ms, faster than 99.33% of Java online submissions for Intersection of Two Arrays.
    //Memory Usage: 40.1 MB, less than 5.08% of Java online submissions for Intersection of Two Arrays.
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n: nums1) set1.add(n);

        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n: nums2) set2.add(n);

        int i =0;
        int size = Math.min(set1.size(), set2.size());
        int [] result = new int[size];
        for (Integer k :  set1) {
            if(set2.contains(k)) result[i++]=k;
        }
        return  Arrays.copyOf(result, i);
    }

}
