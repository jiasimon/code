package com.sjia.Leetcode600;

public class BeautifulArrangement2 {
    // #667. Beautiful Arrangement II   https://leetcode.com/problems/beautiful-arrangement-ii/description/
    /*
    Given two integers n and k, construct a list answer that contains n different positive integers ranging from 1 to n and obeys the following requirement:

    Suppose this list is answer = [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
    Return the list answer. If there multiple valid answers, return any of them.

    Input: n = 3, k = 1     Output: [1,2,3]
    Explanation: The [1,2,3] has three different positive integers ranging from 1 to 3, and the [1,1] has exactly 1 distinct integer: 1

    Input: n = 3, k = 2     Output: [1,3,2]
    Explanation: The [1,3,2] has three different positive integers ranging from 1 to 3, and the [2,1] has exactly 2 distinct integers: 1 and 2.

    1 <= k < n <= 10000
     */

    // chatgpt incorrect
    public int[] constructArray_wrong(int n, int k) {
        int[] result = new int[n];
        int left = 1, right = n;
        int index = 0;

        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                result[index++] = left++;
            } else {
                result[index++] = right--;
            }
        }

        if (k % 2 == 0) {
            for (int i = left; i <= right; i++) {
                result[index++] = i;
            }
        } else {
            for (int i = right; i >= left; i--) {
                result[index++] = i;
            }
        }

        return result;
    }


    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];

        for (int i = 0; i < n - k; ++i)
            ans[i] = i + 1;

        for (int i = 0; i < k; ++i) {
            if (i % 2 == 0)
                ans[n - k + i] = n - i / 2;
            else
                ans[n - k + i] = n - k + (i + 1) / 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        BeautifulArrangement2 solution = new BeautifulArrangement2();

        // Test case 1
        int n1 = 3, k1 = 1;
        int[] result1 = solution.constructArray(n1, k1);
        System.out.print("Test case 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: [1, 2, 3] or [3, 2, 1] or any permutation with difference 1

        // Test case 2
        int n2 = 3, k2 = 2;
        int[] result2 = solution.constructArray(n2, k2);
        System.out.print("Test case 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: [1, 3, 2] or [3, 1, 2]

        // Test case 3
        int n3 = 4, k3 = 2;
        int[] result3 = solution.constructArray(n3, k3);
        System.out.print("Test case 3: ");
        for (int num : result3) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: [1, 4, 2, 3] or any other valid permutation

        // Test case 4
        int n4 = 5, k4 = 4;
        int[] result4 = solution.constructArray(n4, k4);
        System.out.print("Test case 4: ");
        for (int num : result4) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: [1, 5, 2, 4, 3]

        // Test case 5
        int n5 = 6, k5 = 1;
        int[] result5 = solution.constructArray(n5, k5);
        System.out.print("Test case 5: ");
        for (int num : result5) {
            System.out.print(num + " ");
        }
        System.out.println();  // Expected output: [1, 2, 3, 4, 5, 6] or any permutation with difference 1
    }



}
