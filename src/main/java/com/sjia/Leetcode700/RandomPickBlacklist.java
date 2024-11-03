package com.sjia.Leetcode700;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomPickBlacklist {
    // #710. Random Pick with Blacklist     https://leetcode.com/problems/random-pick-with-blacklist/description/
    /*
    chatgpt failed
     */

    // N: [0, N)
    // B: blacklist
    // B1: < N
    // B2: >= N
    // M: N - B1
    int M;
    Random r;
    Map<Integer, Integer> map;

    public RandomPickBlacklist(int N, int[] blacklist) {
        map = new HashMap();
        for (int b : blacklist) // O(B)
            map.put(b, -1);
        M = N - map.size();

        for (int b : blacklist) { // O(B)
            if (b < M) { // re-mapping
                while (map.containsKey(N - 1))
                    N--;
                map.put(b, N - 1);
                N--;
            }
        }

        r = new Random();
    }

    public int pick() {
        int p = r.nextInt(M);
        if (map.containsKey(p))
            return map.get(p);
        return p;
    }

    public static void main(String[] args) {
        int n = 7;
        int[] blacklist = {2, 3, 5};
        RandomPickBlacklist solution = new RandomPickBlacklist(n, blacklist);

        // Test pick() multiple times
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pick());  // Should print random numbers from [0,6] excluding 2, 3, and 5
        }
    }


}
