package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    // #89. Gray Code  https://leetcode.com/problems/gray-code/
    /*
    Input: n = 2
    Output: [0,1,3,2]
    Explanation:
    The binary representation of [0,1,3,2] is [00,01,11,10].
    - 00 and 01 differ by one bit
    - 01 and 11 differ by one bit
    - 11 and 10 differ by one bit
    - 10 and 00 differ by one bit
    [0,2,3,1] is also a valid gray code sequence, whose binary representation is [00,10,11,01].
    - 00 and 10 differ by one bit
    - 10 and 11 differ by one bit
    - 11 and 01 differ by one bit
    - 01 and 00 differ by one bit

    1 <= n <= 16
     */


    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        // Gray code starts with 0
        result.add(0);

        // Generate the gray code sequence iteratively
        for (int i = 0; i < n; i++) {
            int size = result.size();
            // Reverse the current sequence and add 1 as the most significant bit
            for (int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) | (1 << i));
            }
        }

        return result;
    }



    public static void main(String[] args) {
        int n = 3;
        List<Integer> grayCodeSeq = grayCode(n);

        System.out.println("Gray Code Sequence:");
        for (int num : grayCodeSeq) {
            System.out.print(num + " ");
        }
    }



}
