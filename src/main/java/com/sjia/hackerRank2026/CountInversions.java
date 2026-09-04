package com.sjia.hackerRank2026;

import java.util.List;

public class CountInversions {
    // https://www.hackerrank.com/challenges/ctci-merge-sort/problem

    // O(N^2) naive
    public static long countInversions2(List<Integer> arr) {
        // Write your code here
        if (arr.size() <= 1) return 0;

        long res=0;
        for (int i=0; i<arr.size(); i++){
            for (int j=i+1; j < arr.size(); j++) {
                if (arr.get(i) > arr.get(j)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static long countInversions(List<Integer> arr) {
        int n = arr.size();
        long[] temp = new long[n];
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = arr.get(i);
        }
        return mergeSortAndCount(array, temp, 0, n - 1);
    }

    private static long mergeSortAndCount(long[] array, long[] temp, int left, int right) {
        long invCount = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            // Count inversions in left half, right half, and across the merge
            invCount += mergeSortAndCount(array, temp, left, mid);
            invCount += mergeSortAndCount(array, temp, mid + 1, right);
            invCount += mergeAndCount(array, temp, left, mid, right);
        }
        return invCount;
    }

    private static long mergeAndCount(long[] array, long[] temp, int left, int mid, int right) {
        int i = left;      // pointer for left subarray
        int j = mid + 1;    // pointer for right subarray
        int k = left;        // pointer for merged temp array
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                // array[i..mid] are all greater than array[j] (since left half is sorted),
                // so all of them form an inversion with array[j]
                temp[k++] = array[j++];
                invCount += (mid - i + 1);
            }
        }

        // Copy any remaining elements
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }

        // Copy merged result back into original array
        for (int idx = left; idx <= right; idx++) {
            array[idx] = temp[idx];
        }

        return invCount;
    }


}
