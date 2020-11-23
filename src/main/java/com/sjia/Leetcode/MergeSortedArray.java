package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    // #88 https://leetcode.com/problems/merge-sorted-array/

    //Runtime: 1 ms, faster than 20.93% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 40.3 MB, less than 5.07% of Java online submissions for Merge Sorted Array.

    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 39.1 MB, less than 61.19% of Java online submissions for Merge Sorted Array.
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1,m,n);
        Arrays.sort(nums1);
    }


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 39.8 MB, less than 18.65% of Java online submissions for Merge Sorted Array.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

    }


    public static void main(String[] args) {
        int[] m = {1, 2, 3, 0, 0, 0};
        int[] n = {2, 5, 6};

        MergeSortedArray solution = new MergeSortedArray();
        solution.merge(m, 3, n, 3);

        System.out.printf(" After merge is %s \n", Arrays.toString(m));
    }


}
