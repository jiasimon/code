package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    // #88 https://leetcode.com/problems/merge-sorted-array/

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] m = {1, 2, 3, 0, 0, 0};
        int[] n = {2, 5, 6};

        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(m, m.length, n, n.length);

        System.out.printf(" After merge is %s \n", Arrays.toString(m));
    }


}
