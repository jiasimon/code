package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class FreedomTrail {
    // #514. Freedom Trail  https://leetcode.com/problems/freedom-trail/description/

    /*
    At the stage of rotating the ring to spell the key character key[i]:

    You can rotate the ring clockwise or anticlockwise by one place, which counts as one step. The final purpose of the rotation is to align one of ring's characters at the "12:00" direction, where this character must equal key[i].
    If the character key[i] has been aligned at the "12:00" direction, press the center button to spell, which also counts as one step. After the pressing, you could begin to spell the next character in the key (next stage). Otherwise, you have finished all the spelling.

    Input: ring = "godding", key = "gd"         Output: 4
    Input: ring = "godding", key = "godding"    Output: 13

    1 <= ring.length, key.length <= 100
    ring and key consist of only lower case English letters.
    It is guaranteed that key could always be spelled by rotating ring.

     */


    // memo, dfs
    public int findRotateSteps(String ring, String key) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(ring, key, 0, memo) + key.length();
    }

    // Returns the number of rotates of ring to match key[index..n).
    private int dfs(final String ring, final String key, int index, Map<String, Integer> memo) {
        if (index == key.length())
            return 0;
        // Add the index to prevent duplication.
        final String hashKey = ring + index;
        if (memo.containsKey(hashKey))
            return memo.get(hashKey);

        int ans = Integer.MAX_VALUE;

        // For each ring[i] == key[index], we rotate the ring to match the ring[i]
        // with the key[index], then recursively match the newRing with the
        // key[index + 1..n).
        for (int i = 0; i < ring.length(); ++i)
            if (ring.charAt(i) == key.charAt(index)) {
                final int minRotates = Math.min(i, ring.length() - i);
                final String newRing = ring.substring(i) + ring.substring(0, i);
                final int remainingRotates = dfs(newRing, key, index + 1, memo);
                ans = Math.min(ans, minRotates + remainingRotates);
            }

        memo.put(hashKey, ans);
        return ans;
    }



    public static void main(String[] args) {
        FreedomTrail solution = new FreedomTrail();

        String ring = "godding";
        String key = "godding";

        int minSteps = solution.findRotateSteps(ring, key);
        System.out.println("Minimum steps needed: " + minSteps);
    }

}
