package com.sjia.Leetcode700;

import java.util.*;

public class PyramidTransitionMatrix {
    // #756. Pyramid Transition Matrix      https://leetcode.com/problems/pyramid-transition-matrix/description/
    /*
    Input: bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]      Output: true
    Explanation: The allowed triangular patterns are shown on the right.
Starting from the bottom (level 3), we can build "CE" on level 2 and then build "A" on level 1.
There are three triangular patterns in the pyramid, which are "BCC", "CDE", and "CEA". All are allowed.
     */

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> transitions = new HashMap<>();

        // Build transition map
        for (String s : allowed) {
            String key = s.substring(0, 2);
            transitions.putIfAbsent(key, new HashSet<>());
            transitions.get(key).add(s.charAt(2));
        }

        return dfs(bottom, "", 0, transitions);
    }

    private boolean dfs(String bottom, String nextRow, int index, Map<String, Set<Character>> transitions) {
        // If we've reached the top
        if (bottom.length() == 1) return true;

        // If current row is fully built, move to next level
        if (index == bottom.length() - 1) return dfs(nextRow, "", 0, transitions);

        // Get possible transitions for the current two-character base
        String key = bottom.substring(index, index + 2);
        if (!transitions.containsKey(key)) return false;

        // Try all possible upper blocks
        for (char c : transitions.get(key)) {
            if (dfs(bottom, nextRow + c, index + 1, transitions)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix solution = new PyramidTransitionMatrix();
        List<String> allowed = Arrays.asList("ABC", "ACD", "BCE", "DEF", "EEE");
        System.out.println(solution.pyramidTransition("BCD", allowed)); // Output: true or false
    }
}
