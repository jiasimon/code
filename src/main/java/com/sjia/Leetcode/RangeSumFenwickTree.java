package com.sjia.Leetcode;

public class RangeSumFenwickTree {
    // #307. Range Sum Query - Mutable   https://leetcode.com/problems/range-sum-query-mutable/description/
    /*
    Binary Indexed Tree (BIT)   Fenwick Tree

     */

    class BIT { // one-based indexing
        int[] bit;
        BIT(int size) {
            bit = new int[size + 1];
        }
        int getSum(int idx) { // Get sum in range [1..idx]
            int sum = 0;
            for (; idx > 0; idx -= idx & (-idx))
                sum += bit[idx];
            return sum;
        }
        int getSumRange(int left, int right) { // left, right inclusive
            return getSum(right) - getSum(left - 1);
        }
        void addValue(int idx, int val) {
            for (; idx < bit.length; idx += idx & (-idx))
                bit[idx] += val;
        }
    }


    BIT bit;
    int[] nums;
    public RangeSumFenwickTree(int[] nums) {
        this.nums = nums;
        bit = new BIT(nums.length);
        for (int i = 0; i < nums.length; ++i)
            bit.addValue(i+1, nums[i]);
    }
    public void update(int index, int val) {
        int diff = val - nums[index]; // get diff amount of `val` compared to current value
        bit.addValue(index + 1, diff); // add this `diff` amount at index `index+1` of BIT, plus 1 because in BIT it's 1-based indexing
        nums[index] = val; // update latest value of `nums[index]`
    }
    public int sumRange(int left, int right) {
        return bit.getSum(right+1) - bit.getSum(left);
    }




}
