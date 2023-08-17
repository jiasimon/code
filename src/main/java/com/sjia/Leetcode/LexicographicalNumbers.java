package com.sjia.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    // #386. Lexicographical Numbers    https://leetcode.com/problems/lexicographical-numbers/

    /*
    Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

    You must write an algorithm that runs in O(n) time and uses O(1) extra space.

    Input: n = 13   Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

    Input: n = 2    Output: [1,2]

    1 <= n <= 5 * 10000

     */

    // dfs, recursive
    // 3 ms, 69.83%; 47 MB, 89.44%
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        // loop for 2,3 ...
        for ( int i=1; i<=9; i++) {
            dfs(1, n , res);
        }
        return res;
    }

    private void dfs(int current, int n, List<Integer> res) {
        if ( current > n) {
            return;
        }

        // remember to add current
        res.add(current);

        for (int i=0; i <= 9; i++) {
            int tmp = current * 10 + i;
            if(tmp <= n ) {
                dfs(tmp, n, res);
            }
        }

    }


}
