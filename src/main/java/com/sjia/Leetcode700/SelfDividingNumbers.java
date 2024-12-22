package com.sjia.Leetcode700;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    // #728. Self Dividing Numbers  https://leetcode.com/problems/self-dividing-numbers/description/
    /*

     */

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }

    // Helper function to check if a number is self-dividing
    private boolean isSelfDividing(int num) {
        int original = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || original % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }


    public static void main(String[] args) {
        SelfDividingNumbers solution = new SelfDividingNumbers();

        // Test Case 1
        int left1 = 1, right1 = 22;
        System.out.println(solution.selfDividingNumbers(left1, right1));
        // Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]

        // Test Case 2
        int left2 = 47, right2 = 85;
        System.out.println(solution.selfDividingNumbers(left2, right2));
        // Output: [48, 55, 66, 77]
    }

}
