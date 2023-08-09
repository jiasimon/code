package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class IntersectionTwoArrays {
    // #349. Intersection of Two Arrays https://leetcode.com/problems/intersection-of-two-arrays/

    /*
    Input: nums1 = [1,2,2,1], nums2 = [2,2]     Output: [2]
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]     Output: [9,4]
     */




    // 2 HashSets, set1 and intersect
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();

        for (Integer n: nums1) {
            set1.add(n);
        }

        for ( int n: nums2) {
            if (set1.contains(n) ){
                intersect.add(n);
            }
        }

        // Set to ArrayList, then to int[]
        List<Integer> tmp = new ArrayList<>(intersect);
        int[] res = new int[tmp.size()];
        for ( int i=0; i < tmp.size(); i++) {
            res[i] = tmp.get(i);
        }
        return res;

    }




    // Set.size  to int[]
    public int[] intersection_Set(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersect = new HashSet<>();

        for (Integer n: nums1) {
            set1.add(n);
        }

        for ( int n: nums2) {
            if (set1.contains(n) ){
                intersect.add(n);
            }
        }

        int[] res = new int[intersect.size()];
        int index=0;
        for (int n : intersect) {
            res[index] = n;
            index++;
        }
        return res;
    }


    // Runtime: 4 ms, faster than 43.97% of Java online submissions for Intersection of Two Arrays.
    //Memory Usage: 41.4 MB, less than 5.08% of Java online submissions for Intersection of Two Arrays.
    public int[] intersection_retainAll(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n: nums1) set1.add(n);

        HashSet<Integer> set2 = new HashSet<>();
        for(Integer n: nums2) set2.add(n);

        set1.retainAll(set2);
        int [] result = new int[set1.size()];
        int i=0;
        for (Integer k :  set1) {
            result[i++]=k;
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        IntersectionTwoArrays solution = new IntersectionTwoArrays();
        int[] result = solution.intersection(num1, num2);
        System.out.printf("nums1: %s , nums2 %s, result is : %s ", Arrays.toString(num1),
                Arrays.toString(num2), Arrays.toString(result));
    }
}
