package com.sjia.Leetcode;

import java.util.*;

public class FindKPairsSmallestSums {
    // #373. Find K Pairs with Smallest Sums    https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

    /*
    You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

    Define a pair (u, v) which consists of one element from the first array and one element from the second array.

    Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.

    Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3     Output: [[1,2],[1,4],[1,6]]
    Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2      Output: [[1,1],[1,1]]
    Input: nums1 = [1,2], nums2 = [3], k = 3            Output: [[1,3],[2,3]]

     */



    // minHeap, (a, b) -> a[0] + a[1] - b[0] - b[1]
    // 28 ms, 98.48%; 56.3 MB, 91.24%
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);

        for (int i = 0; i < nums1.length && i < k; i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[2];
            result.add(Arrays.asList(curr[0], curr[1]));

            if (i + 1 < nums2.length) {
                minHeap.offer(new int[]{curr[0], nums2[i + 1], i + 1});
            }

            k--;
        }

        return result;
    }



    // brute, Math.min(m, k), Math.min(k, m*n)
    // TLE, 25/36
    public List<List<Integer>> kSmallestPairs_brute(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> tmp = new ArrayList<>();

        for (int i =0; i < Math.min(m, k); i++) {
            for ( int j = 0 ; j < Math.min(n, k); j++) {
                tmp.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }

        Collections.sort(tmp, (a,b) -> a.get(0)+ a.get(1) - b.get(0) -b.get(1) );
//        for ( int i= 0 ; i < k; i++) {
        for ( int i= 0 ; i < Math.min(k, m*n); i++) {
            res.add(tmp.get(i));
        }

        return res;

    }


    public static void main(String[] args) {
        FindKPairsSmallestSums solution = new FindKPairsSmallestSums();
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs_brute(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }

        int[] nums1b = {1, 2};
        int[] nums2b = {3};
        k = 3;
        result = solution.kSmallestPairs_brute(nums1b, nums2b, k);
        System.out.println( "Find K Pairs with Smallest Sums: " + result);


    }


}
