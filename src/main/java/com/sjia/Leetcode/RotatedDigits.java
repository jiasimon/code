package com.sjia.Leetcode;

public class RotatedDigits {
    // #788 https://leetcode.com/problems/rotated-digits/
    // 0, 1, and 8 rotate to themselves;
    // 2 ,5 ,6 ,9 are good ; 3, 4, 7 are bad
    // N  will be in range [1, 10000].

    public int rotatedDigits(int N) {
        int result = 0;
        for (int i=1; i<=N; i++) {
            if (checkRotatedDigits(i)) result++;
        }
        return result;
    }

    // Runtime: 7 ms, faster than 53.40% of Java online submissions for Rotated Digits.
    //Memory Usage: 38.7 MB, less than 37.33% of Java online submissions for Rotated Digits.
    private boolean checkRotatedDigits(int i) {
        String tmp = Integer.toString(i);
        if ( tmp.contains("3") || tmp.contains("4") || tmp.contains("7") ) return false;
        boolean flag = false;
        for (char c : tmp.toCharArray()) {
            if (c == '2' || c == '5' || c == '6' || c == '9'){
                flag = true;
            }
        }
        return flag;
    }


}
