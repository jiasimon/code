package com.sjia.Leetcode;

public class GuessNumber {
    // #374 https://leetcode.com/problems/guess-number-higher-or-lower/

    // binary search
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Guess Number Higher or Lower.
    //Memory Usage: 38.2 MB, less than 5.17% of Java online submissions for Guess Number Higher or Lower.
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low < high) {
            int mid = low + (high-low)/2;
            int result =guess(mid);
            if (result==0) return mid;
            else if (result < 0) high=mid;
            else low = mid+1;
        }
        return low;
    }

    private int guess(int mid) {
        return 0;
    }

}
