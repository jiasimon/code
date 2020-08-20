package com.sjia.Leetcode;

import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.Collections;
import java.util.HashMap;

public class ArrayDegree {
    // #697 https://leetcode.com/problems/degree-of-an-array/
    // the degree of this array is defined as the maximum frequency of any one of its elements.
    // find the smallest possible length of a (contiguous) subarray of nums with same degree

    // three HashMaps
    // Runtime: 17 ms, faster than 77.71% of Java online submissions for Degree of an Array.
    //Memory Usage: 43.3 MB, less than 82.64% of Java online submissions for Degree of an Array.
    public int findShortestSubArray(int[] nums) {
        int result = nums.length;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i=0; i< nums.length; i++) {
            int tmp = nums[i];
            if (left.get(tmp) == null ) left.put(tmp, i);
            right.put(tmp,i);
            count.put(tmp, count.getOrDefault(tmp, 0) + 1);
        }

        int degree = Collections.max(count.values());

        for ( int k : count.keySet()) {
            if(count.get(k) == degree) {
                result = Math.min(result, right.get(k) -left.get(k)+1);
            }
        }
        return result;

    }


}
