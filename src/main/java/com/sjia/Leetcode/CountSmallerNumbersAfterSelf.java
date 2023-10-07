package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    // #315. Count of Smaller Numbers After Self    https://leetcode.com/problems/count-of-smaller-numbers-after-self/description/
    /*
    Given an integer array nums, return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].

    Input: nums = [5,2,6,1]     Output: [2,1,1,0]
    Input: nums = [-1]          Output: [0]
    Input: nums = [-1,-1]       Output: [0,0]
     */



    // naive, 2 loop
    // TLE 62/66
    public List<Integer> countSmaller_brute(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for ( int i =0; i< n; i++) {
            int count =0;
            for (int j = i+1; j< n; j++) {
                if (nums[j] < nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }



    // mergeSort

    class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller_mergeSort(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(nums[i], i));
            result[i] = 0;
        }

        mergeSortAndCount(pairs, result);

        return Arrays.asList(result);
    }

    private List<Pair> mergeSortAndCount(List<Pair> pairs, Integer[] result) {
        int n = pairs.size();
        if (n <= 1) {
            return pairs;
        }

        int mid = n / 2;
        List<Pair> left = mergeSortAndCount(pairs.subList(0, mid), result);
        List<Pair> right = mergeSortAndCount(pairs.subList(mid, n), result);

        return merge(left, right, result);
    }

    private List<Pair> merge(List<Pair> left, List<Pair> right, Integer[] result) {
        int leftSize = left.size();
        int rightSize = right.size();
        List<Pair> merged = new ArrayList<>();

        int i = 0, j = 0;

        while (i < leftSize && j < rightSize) {
            if (left.get(i).val <= right.get(j).val) {
                result[left.get(i).index] += j; // Increment count of smaller numbers on the right
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        while (i < leftSize) {
            result[left.get(i).index] += j; // Increment count of smaller numbers on the right
            merged.add(left.get(i));
            i++;
        }

        while (j < rightSize) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }


    public static void main(String[] args) {
        CountSmallerNumbersAfterSelf solution = new CountSmallerNumbersAfterSelf();
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = solution.countSmaller_mergeSort(nums);
        System.out.println(result); // Output: [2, 1, 1, 0]
    }

}
