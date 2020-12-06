package com.sjia.Leetcode;

public class CountGoodTriplets {
    // #1534 https://leetcode.com/problems/count-good-triplets/

    // A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
    //
    // 0 <= i < j < k < arr.length
    // |arr[i] - arr[j]| <= a
    // |arr[j] - arr[k]| <= b
    // |arr[i] - arr[k]| <= c

    // 3 <= arr.length <= 100
    // 0 <= arr[i] <= 1000
    // 0 <= a, b, c <= 1000

    // three loops
    // Runtime: 13 ms, faster than 58.17% of Java online submissions for Count Good Triplets.
    //Memory Usage: 36.5 MB, less than 65.36% of Java online submissions for Count Good Triplets.
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            for (int j= i+1; j< n-1; j++) {
                for (int k= j+1; k < n; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                        res++;
                    }

                }
            }
        }
        return res;
    }


}
