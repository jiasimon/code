package com.sjia.Leetcode;

public class BeautifulArrangement {
    // #526. Beautiful Arrangement  https://leetcode.com/problems/beautiful-arrangement/description/

    /*
    Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

    perm[i] is divisible by i.
    i is divisible by perm[i].
    Given an integer n, return the number of the beautiful arrangements that you can construct.

    Input: n = 2        Output: 2
    The first beautiful arrangement is [1,2]:
    - perm[1] = 1 is divisible by i = 1
    - perm[2] = 2 is divisible by i = 2
    The second beautiful arrangement is [2,1]:
        - perm[1] = 2 is divisible by i = 1
        - i = 2 is divisible by perm[2] = 1

    1 <= n <= 15
     */


    int count;

    public int countArrangement(int n) {
        count = 0;
        boolean[] used = new boolean[n + 1];
        calculateArrangement(n, 1, used);
        return count;
    }

    private void calculateArrangement(int n, int pos, boolean[] used) {
        if (pos > n) {
            count++;
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!used[i] && (i % pos == 0 || pos % i == 0)) {
                used[i] = true;
                calculateArrangement(n, pos + 1, used);
                used[i] = false;
            }
        }
    }


}
