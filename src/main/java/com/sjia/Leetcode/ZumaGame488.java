package com.sjia.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ZumaGame488 {
    // #488. Zuma Game      https://leetcode.com/problems/zuma-game/

    /*
    Input: board = "WRRBBW", hand = "RB"    Output: -1
    Explanation: It is impossible to clear all the balls. The best you can do is:
    - Insert 'R' so the board becomes WRRRBBW. WRRRBBW -> WBBW.
    - Insert 'B' so the board becomes WBBBW. WBBBW -> WW.

    Input: board = "WWRRBBWW", hand = "WRBRW"   Output: 2
    Explanation: To make the board empty:
    - Insert 'R' so the board becomes WWRRRBBWW. WWRRRBBWW -> WWBBWW.
    - Insert 'B' so the board becomes WWBBBWW. WWBBBWW -> WWWW -> empty.
    2 balls from your hand were needed to clear the board.

    1 <= board.length <= 16
    1 <= hand.length <= 5

     */


    // 49 / 57 testcases passed
    /*
    board = "RRWWRRBBRR",  hand ="WB"  Output:-1  Expected: 2
     */
    public int findMinStep_failed(String board, String hand) {
        int[] handCount = new int[26];
        for (char ch : hand.toCharArray()) {
            handCount[ch - 'A']++;
        }

        return backtrack(board, handCount);
    }

    private int backtrack(String board, int[] handCount) {
        if (board.isEmpty()) {
            return 0;
        }

        int result = Integer.MAX_VALUE;
        int i = 0;

        while (i < board.length()) {
            int j = i;

            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            int neededBalls = 3 - (j - i);
            if (handCount[board.charAt(i) - 'A'] >= neededBalls) {
                String newBoard = updateBoard(board.substring(0, i) + board.substring(j));
                handCount[board.charAt(i) - 'A'] -= neededBalls;
                int nextResult = backtrack(newBoard, handCount);
                if (nextResult != -1) {
                    result = Math.min(result, neededBalls + nextResult);
                }
                handCount[board.charAt(i) - 'A'] += neededBalls;
            }

            i = j;
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private String updateBoard(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i;

            while (j < board.length() && board.charAt(j) == board.charAt(i)) {
                j++;
            }

            if (j - i >= 3) {
                return updateBoard(board.substring(0, i) + board.substring(j));
            }

            i = j;
        }

        return board;
    }



    int INF = 0x3f3f3f3f;
    String b;
    int m;
    Map<String, Integer> map = new HashMap<>();
    public int findMinStep(String a, String _b) {
        b = _b;
        m = b.length();
        int ans = dfs(a, 1 << m);
        return ans == INF ? -1 : ans;
    }
    int dfs(String a, int cur) {
        if (a.length() == 0) return 0;
        String hashKey = a + "_" + cur;
        if (map.containsKey(hashKey)) return map.get(hashKey);
        int ans = INF;
        int n = a.length();
        for (int i = 0; i < m; i++) {
            if (((cur >> i) & 1) == 1) continue;
            int next = (1 << i) | cur;
            for (int j = 0; j <= n; j++) {
                boolean ok = false;
                if (j > 0 && j < n && a.charAt(j) == a.charAt(j - 1) && a.charAt(j - 1) != b.charAt(i)) ok = true;
                if (j < n && a.charAt(j) == b.charAt(i)) ok = true;
                if (!ok) continue;
                StringBuilder sb = new StringBuilder();
                sb.append(a.substring(0, j)).append(b.substring(i, i + 1));
                if (j != n) sb.append(a.substring(j));
                int k = j;
                while (0 <= k && k < sb.length()) {
                    char c = sb.charAt(k);
                    int l = k, r = k;
                    while (l >= 0 && sb.charAt(l) == c) l--;
                    while (r < sb.length() && sb.charAt(r) == c) r++;
                    if (r - l - 1 >= 3) {
                        sb.delete(l + 1, r);
                        k = l >= 0 ? l : r;
                    } else {
                        break;
                    }
                }
                ans = Math.min(ans, dfs(sb.toString(), next) + 1);
            }
        }
        map.put(hashKey, ans);
        return ans;
    }



    public static void main(String[] args) {
        ZumaGame488 solution = new ZumaGame488();
        String board = "WRRBBW";
        String hand = "RB";

        int minSteps = solution.findMinStep(board, hand);
        System.out.println("Minimum Steps to Eliminate: " + minSteps);


        board = "RRWWRRBBRR";
        hand = "WB";

        minSteps = solution.findMinStep(board, hand);
        System.out.println("Minimum Steps to Eliminate: " + minSteps);

    }
}
