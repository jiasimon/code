package com.sjia.Leetcode;

public class RangeSumSegmentTree {
    // 307. Range Sum Query - Mutable   https://leetcode.com/problems/range-sum-query-mutable/description/
    /*
    Update the value of an element in nums.
    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
     */


    private int[] segmentTree;
    private int[] nums;
    private int n;


    public RangeSumSegmentTree(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.segmentTree = new int[4 * n];
        buildSegmentTree(0, n - 1, 0);
    }

    private void buildSegmentTree(int start, int end, int currentIndex) {
        if (start == end) {
            segmentTree[currentIndex] = nums[start];
            return;
        }

        int mid = start + (end - start) / 2;
        buildSegmentTree(start, mid, 2 * currentIndex + 1);
        buildSegmentTree(mid + 1, end, 2 * currentIndex + 2);
        segmentTree[currentIndex] = segmentTree[2 * currentIndex + 1] + segmentTree[2 * currentIndex + 2];
    }

    public void update(int index, int val) {
        updateSegmentTree(0, n - 1, index, val, 0);
    }

    private void updateSegmentTree(int start, int end, int index, int val, int currentIndex) {
        if (start == end) {
            nums[index] = val;
            segmentTree[currentIndex] = val;
            return;
        }

        int mid = start + (end - start) / 2;
        if (index <= mid) {
            updateSegmentTree(start, mid, index, val, 2 * currentIndex + 1);
        } else {
            updateSegmentTree(mid + 1, end, index, val, 2 * currentIndex + 2);
        }
        segmentTree[currentIndex] = segmentTree[2 * currentIndex + 1] + segmentTree[2 * currentIndex + 2];
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(0, n - 1, left, right, 0);
    }

    private int querySegmentTree(int start, int end, int left, int right, int currentIndex) {
        if (start >= left && end <= right) {
            return segmentTree[currentIndex];
        }

        if (end < left || start > right) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int leftSum = querySegmentTree(start, mid, left, right, 2 * currentIndex + 1);
        int rightSum = querySegmentTree(mid + 1, end, left, right, 2 * currentIndex + 2);
        return leftSum + rightSum;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        RangeSumSegmentTree numArray = new RangeSumSegmentTree(nums);

        // Test cases
        System.out.println(numArray.sumRange(0, 2)); // Output: 9 (1 + 3 + 5)
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2)); // Output: 8 (1 + 2 + 5)
    }

}


