package com.sjia.Leetcode3000Plus;

import java.util.Arrays;

public class LexGreaterPermutation {
    // #3720. Lexicographically Smallest Permutation Greater Than Target
    // https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/description/
    /*
    Return the lexicographically smallest permutation of s that is strictly greater than target

    Input: s = "abc", target = "bba"    Output: "bca"
    Input: s = "baba", target = "bbaa"  Output: ""
     */

    public String lexGreaterPermutation(String s, String target) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        StringBuilder res = new StringBuilder();
        int n = target.length();
        for (int i = 0; i < n; i++) {
            int targetChar = target.charAt(i) - 'a';

            // Case 1: First try to place the same character as target[i] at the current position
            if (cnt[targetChar] > 0) {
                cnt[targetChar]--;
                // Check if the remaining characters can form a string greater than target[i+1:]
                if (canFormGreater(cnt, target, i + 1)) {
                    res.append(target.charAt(i));
                    continue;
                }
                // Cannot form a larger string, backtrack
                cnt[targetChar]++;
            }

            // Case 2: Place a character greater than target[i] at the current position
            for (int j = targetChar + 1; j < 26; j++) {
                if (cnt[j] > 0) {
                    cnt[j]--;
                    res.append((char) ('a' + j));
                    // Fill remaining positions with the smallest lexicographical order
                    res.append(getMinString(cnt));
                    return res.toString();
                }
            }

            // No feasible solution found, return directly
            return "";
        }

        return "";
    }

    // Check if the remaining characters can form a string greater than the suffix.
    private boolean canFormGreater(int[] cnt, String target, int start) {
        String maxStr = getMaxString(cnt);
        String suffix = target.substring(start);
        return maxStr.compareTo(suffix) > 0;
    }

    // Get the maximum lexicographical string (in descending order)
    private String getMaxString(int[] cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            if (cnt[i] > 0) {
                res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
            }
        }
        return res.toString();
    }

    // Get the lexicographically smallest string (in ascending order)
    private String getMinString(int[] cnt) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                res.append(String.valueOf((char) ('a' + i)).repeat(cnt[i]));
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LexGreaterPermutation solver = new LexGreaterPermutation();

        int passed = 0;
        int failed = 0;

        // Test 1: standard case, next greater permutation found via backtracking (case 1 fails
        // at position 1, falls through to case 2, remainder filled with getMinString)
        // letters {a,b,c} of "abc" permuted greater than "abc" -> "acb"
        boolean t1 = runTest(solver, "abc", "abc", "acb");
        passed += t1 ? 1 : 0;
        failed += t1 ? 0 : 1;

        // Test 2: target is already the lexicographically maximum permutation -> no greater
        // permutation exists -> ""
        boolean t2 = runTest(solver, "abc", "cba", "");
        passed += t2 ? 1 : 0;
        failed += t2 ? 0 : 1;

        // Test 3: duplicate letters {a,a,b}; permutations sorted: aab < aba < baa
        // next greater than "aba" -> "baa"
        boolean t3 = runTest(solver, "aab", "aba", "baa");
        passed += t3 ? 1 : 0;
        failed += t3 ? 0 : 1;

        // Test 4: target shorter than s (leftover letters unused); every position matches
        // target exactly via case 1 (continue) so loop completes without ever hitting the
        // case-2 return -> falls through to final "return \"\";"
        boolean t4 = runTest(solver, "abc", "ab", "");
        passed += t4 ? 1 : 0;
        failed += t4 ? 0 : 1;

        // Test 5: empty strings -> loop never runs -> ""
        boolean t5 = runTest(solver, "", "", "");
        passed += t5 ? 1 : 0;
        failed += t5 ? 0 : 1;

        // Test 6: single matching character, no larger character available -> ""
        boolean t6 = runTest(solver, "a", "a", "");
        passed += t6 ? 1 : 0;
        failed += t6 ? 0 : 1;

        // Test 7: no permutation possible at first position, but a larger candidate exists
        // immediately at position 0 (case 2 hit right away)
        // letters {a,b} target "ba": place 'b' fails greater-check, no char > 'b' available -> ""
        boolean t7 = runTest(solver, "ab", "ba", "");
        passed += t7 ? 1 : 0;
        failed += t7 ? 0 : 1;

        // Test 8: case 2 triggered at position 0 directly
        // letters {b,c} target "ac": 'a' not in cnt, so case 1 skipped; smallest char > 'a'
        // available is 'b' -> place 'b', then fill remaining with getMinString -> "bc"
        boolean t8 = runTest(solver, "bc", "ac", "bc");
        passed += t8 ? 1 : 0;
        failed += t8 ? 0 : 1;

        System.out.println();
        System.out.println("Total: " + (passed + failed) + ", Passed: " + passed + ", Failed: " + failed);
        if (failed > 0) {
            throw new AssertionError(failed + " test(s) failed");
        }
    }

    private static boolean runTest(LexGreaterPermutation solver, String s, String target, String expected) {
        String actual = solver.lexGreaterPermutation(s, target);
        boolean ok = actual.equals(expected);
        System.out.printf("s=%-6s target=%-6s expected=%-6s actual=%-6s -> %s%n",
                "\"" + s + "\"", "\"" + target + "\"", "\"" + expected + "\"", "\"" + actual + "\"",
                ok ? "PASS" : "FAIL");
        return ok;
    }

}
