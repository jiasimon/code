package com.sjia.Leetcode;

import java.util.Arrays;

public class WiggleSort2 {
    // #324. Wiggle Sort II https://leetcode.com/problems/wiggle-sort-ii/
    /*
    Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

    You may assume the input array always has a valid answer.

    Input: nums = [1,5,1,1,6,4]     Output: [1,6,1,5,1,4]
    Explanation: [1,4,1,5,1,6] is also accepted.

    Input: nums = [1,3,2,2,3,1]     Output: [2,3,1,3,1,2]

    1 <= nums.length <= 5 * 10^4    0 <= nums[i] <= 5000
    It is guaranteed that there will be an answer for the given input nums.

    Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?

     */


    // sort, odd, even put num from big to small
    // 6ms, 35.27%; 46.65mb, 84.23%
    public void wiggleSort_odd_even(int[] nums) {
        Arrays.sort(nums);

        int[] tmp = new int[nums.length];
        int j = nums.length - 1;
        for (int i=1; i < nums.length; i=i+2) {
            tmp[i] = nums[j];
            j--;
        }

        for (int i=0; i < nums.length; i=i+2) {
            tmp[i] = nums[j];
            j--;
        }

        for (int i=0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }


    }


    // quick select, 3-way partition, revisit

    int[] nums;
    int n;
    int qselect(int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(l, j, k);
        else return qselect(j + 1, r, k - cnt);
    }
    void swap(int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
    int getIdx(int x) {
        return (2 * x + 1) % (n | 1);
    }
    public void wiggleSort(int[] _nums) {
        nums = _nums;
        n = nums.length;
        int x = qselect(0, n - 1, n + 1 >> 1);
        int l = 0, r = n - 1, loc = 0;
        while (loc <= r) {
            if (nums[getIdx(loc)] > x) swap(getIdx(loc++), getIdx(l++));
            else if (nums[getIdx(loc)] < x) swap(getIdx(loc), getIdx(r--));
            else loc++;
        }
    }




    //
    public void wiggleSort_swap(int[] nums) {
        // 1. if i is even, then nums[i] <= nums[i - 1]
        // 2. if i is odd, then nums[i] >= nums[i - 1]
        for (int i = 1; i < nums.length; ++i) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1]))
                swap(nums, i, i - 1);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        WiggleSort2 solution = new WiggleSort2();
        int[] nums = {1, 5, 1, 1, 6, 4};
        solution.wiggleSort(nums);
        System.out.println(Arrays.toString(nums)); // Output: [1, 6, 1, 5, 1, 4]



        int[] nums2 = {1, 2, 4, 4, 4, 6};
        solution.wiggleSort(nums2);
        System.out.println(Arrays.toString(nums2)); // Output: [4, 6, 2, 4, 1, 4]

        int[] nums2b = {1, 2, 4, 4, 4, 6};
        solution.wiggleSort_swap(nums2b);
        System.out.println(Arrays.toString(nums2b)); // Output: [1, 4, 2, 4, 4, 6]


    }

}
