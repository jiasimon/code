package com.sjia.Leetcode;

import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    // #88. Merge Sorted Array https://leetcode.com/problems/merge-sorted-array/    #fb
    // Given two sorted integer arrays nums1 and nums2
    // merge nums2 into nums1 as one sorted array
    // The number of elements initialized in nums1 and nums2 are m and n
    // nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2
    // -10^9 <= nums1[i], nums2[i] <= 10^9
    // nums1.length == m + n
    // nums2.length == n




    // Two pointers, from end to begin
    // time: O(n+m)  space:O(1)
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



    // System.arraycopy
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 39.1 MB, less than 61.19% of Java online submissions for Merge Sorted Array.
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1,m,n);
        Arrays.sort(nums1);
    }



    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
    //Memory Usage: 39.4 MB, less than 10.42% of Java online submissions for Merge Sorted Array.
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1 , k = m + n - 1;
        while (i>=0 && j>=0) {
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }
        while (j>=0) {
            nums1[k--] = nums2[j--];
        }
    }



    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1; // Pointer for nums1 array
        int p2 = n - 1; // Pointer for nums2 array
        int p = m + n - 1; // Pointer for merged array

        while (p1 >= 0 && p2 >= 0) {
            // Compare the elements from the end of both arrays
            // and place the larger element at the end of nums1
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        // If there are any remaining elements in nums2,
        // copy them to the beginning of nums1
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }


    public static void main(String[] args) {
        int[] m = {1, 2, 3, 0, 0, 0};
        int[] n = {2, 5, 6};

        MergeSortedArray solution = new MergeSortedArray();
        solution.merge3(m, 3, n, 3);

        System.out.printf(" After merge is %s \n", Arrays.toString(m));
    }


}
