package com.sjia.Leetcode700;

public class ReachaNumber {
    // #754. Reach a Number https://leetcode.com/problems/reach-a-number/description/
    /*
    Input: target = 2       Output: 3
    Explanation:
    On the 1st move, we step from 0 to 1 (1 step).
    On the 2nd move, we step from 1 to -1 (2 steps).
    On the 3rd move, we step from -1 to 2 (3 steps).

    -109 <= target <= 109
    target != 0

     */

    public int reachNumber(int target) {
        target = Math.abs(target); // Since the problem is symmetric, consider only positive target
        int k = 0, sum = 0;

        while (sum < target || (sum - target) % 2 != 0) {
            k++;
            sum += k;
        }

        return k;
    }

    public static void main(String[] args) {
        ReachaNumber solution = new ReachaNumber();
        System.out.println(solution.reachNumber(3)); // Output: 2
        System.out.println(solution.reachNumber(2)); // Output: 3
        System.out.println(solution.reachNumber(5)); // Output: 5
    }

}
