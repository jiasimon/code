package com.sjia.Leetcode600;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    // #658. Find K Closest Elements    https://leetcode.com/problems/find-k-closest-elements/description/
    /*
    Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

    An integer a is closer to x than an integer b if:

    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b

    Input: arr = [1,2,3,4,5], k = 4, x = 3      Output: [1,2,3,4]
    Input: arr = [1,2,3,4,5], k = 4, x = -1     Output: [1,2,3,4]
     */



    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (right - left >= k) {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                right--;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            result.add(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        // Test case
        FindKClosestElements solution = new FindKClosestElements();

        int[] arr1 = {1, 2, 3, 4, 5};
        int k1 = 4;
        int x1 = 3;
        System.out.println("Test case 1: " + solution.findClosestElements(arr1, k1, x1));  // Expected output: [1, 2, 3, 4]

        int[] arr2 = {1, 2, 3, 4, 5};
        int k2 = 4;
        int x2 = -1;
        System.out.println("Test case 2: " + solution.findClosestElements(arr2, k2, x2));  // Expected output: [1, 2, 3, 4]

        int[] arr3 = {1, 2, 3, 4, 5};
        int k3 = 2;
        int x3 = 5;
        System.out.println("Test case 3: " + solution.findClosestElements(arr3, k3, x3));  // Expected output: [4, 5]

        int[] arr4 = {1, 3, 5, 7, 9};
        int k4 = 3;
        int x4 = 6;
        System.out.println("Test case 4: " + solution.findClosestElements(arr4, k4, x4));  // Expected output: [3, 5, 7]
    }

}
