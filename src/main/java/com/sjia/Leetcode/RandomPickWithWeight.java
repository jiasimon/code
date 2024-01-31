package com.sjia.Leetcode;

import java.util.Random;

public class RandomPickWithWeight {
    // #528. Random Pick with Weight    https://leetcode.com/problems/random-pick-with-weight/description/

    /*
    You are given a 0-indexed array of positive integers w where w[i] describes the weight of the ith index.

You need to implement the function pickIndex(), which randomly picks an index in the range [0, w.length - 1] (inclusive) and returns it. The probability of picking an index i is w[i] / sum(w).

For example, if w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e., 25%), and the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e., 75%).


     */


    private int[] prefixSum;
    private Random random;

    public RandomPickWithWeight(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }

        random = new Random();
    }

    public int pickIndex() {
        int target = random.nextInt(prefixSum[prefixSum.length - 1]) + 1;

        int left = 0, right = prefixSum.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 2, 4};
        RandomPickWithWeight solution = new RandomPickWithWeight(weights);

        // Simulate picking an index multiple times
        for (int i = 0; i < 10; i++) {
            System.out.println("Picked index: " + solution.pickIndex());
        }
    }
}
