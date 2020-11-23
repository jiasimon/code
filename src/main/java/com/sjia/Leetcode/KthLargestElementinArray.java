package com.sjia.Leetcode;

import java.util.*;

public class KthLargestElementinArray {
    // #215 https://leetcode.com/problems/kth-largest-element-in-an-array/  #fb

    // Note that it is the kth largest element in the sorted order, not the kth distinct element.


    // Arrays.sort  O(N lgN) running time + O(1) memory
    // Runtime: 1 ms, faster than 97.71% of Java online submissions for Kth Largest Element in an Array.
    //Memory Usage: 39.1 MB, less than 77.44% of Java online submissions for Kth Largest Element in an Array.
    public int findKthLargest2(int[] nums, int k) {
        int N = nums.length;
        Arrays.sort(nums);
        return nums[N-k];
    }



    // PriorityQueue
    // Runtime: 4 ms, faster than 59.76% of Java online submissions for Kth Largest Element in an Array.
    //Memory Usage: 39 MB, less than 95.51% of Java online submissions for Kth Largest Element in an Array.
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }


    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }



}









