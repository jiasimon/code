package com.sjia.Leetcode600;

import java.util.Arrays;

public class StickersSpellWord {
    // #691. Stickers to Spell Word      https://leetcode.com/problems/stickers-to-spell-word/description/
    /*
    Input: stickers = ["with","example","science"], target = "thehat"   Output: 3
    Explanation:
    We can use 2 "with" stickers, and 1 "example" sticker.

    n == stickers.length
    1 <= n <= 50
    1 <= stickers[i].length <= 10
    1 <= target.length <= 15
    stickers[i] and target consist of lowercase English letters.
     */



    // dynamic programming with bit masking to optimize the state space.
    // Each state in the DP array represents the minimum number of stickers needed to achieve a certain subset of the target word.
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length;
        int[] dp = new int[1 << target.length()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < (1 << target.length()); i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (String sticker : stickers) {
                int newMask = i;
                for (char c : sticker.toCharArray()) {
                    for (int k = 0; k < target.length(); k++) {
                        if (target.charAt(k) == c && (newMask & (1 << k)) == 0) {
                            newMask |= 1 << k;
                            break;
                        }
                    }
                }
                dp[newMask] = Math.min(dp[newMask], dp[i] + 1);
            }
        }

        return dp[(1 << target.length()) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << target.length()) - 1];
    }

    public static void main(String[] args) {
        StickersSpellWord solution = new StickersSpellWord();

        // Test Case 1
        String[] stickers1 = {"with", "example", "science"};
        String target1 = "thehat";
        System.out.println("Test Case 1: " + solution.minStickers(stickers1, target1)); // Expected output: 3

        // Test Case 2
        String[] stickers2 = {"notice", "possible"};
        String target2 = "basicbasic";
        System.out.println("Test Case 2: " + solution.minStickers(stickers2, target2)); // Expected output: -1

        // Test Case 3
        String[] stickers3 = {"these", "guess", "about", "garden", "him"};
        String target3 = "atomher";
        System.out.println("Test Case 3: " + solution.minStickers(stickers3, target3)); // Expected output: 3

        // Test Case 4
        String[] stickers4 = {"a", "b", "c"};
        String target4 = "abc";
        System.out.println("Test Case 4: " + solution.minStickers(stickers4, target4)); // Expected output: 3

        // Test Case 5
        String[] stickers5 = {"the", "hat"};
        String target5 = "that";
        System.out.println("Test Case 5: " + solution.minStickers(stickers5, target5)); // Expected output: 2
    }


}
