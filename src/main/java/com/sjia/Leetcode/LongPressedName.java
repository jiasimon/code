package com.sjia.Leetcode;

public class LongPressedName {
    // #925 https://leetcode.com/problems/long-pressed-name/
    // 1 <= name.length <= 1000
    // 1 <= typed.length <= 1000
    // The characters of name and typed are lowercase letters.


    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Long Pressed Name.
    //Memory Usage: 39 MB, less than 21.40% of Java online submissions for Long Pressed Name.
    public boolean isLongPressedName(String name, String typed) {
        int N = name.length(),T = typed.length();
        int i = 0;
        for (int j=0; j < T; j++) {
            if ( i< N && name.charAt(i) == typed.charAt(j)) i++;
            else if ( j==0 || typed.charAt(j) != typed.charAt(j-1)) return false;
        }
        return i == N;
    }


}
