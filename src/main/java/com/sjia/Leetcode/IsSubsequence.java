package com.sjia.Leetcode;

public class IsSubsequence {
    // #392 https://leetcode.com/problems/is-subsequence/

    // "aaaaaa", "bbaaaa"
/*
    public boolean isSubsequence(String s, String t) {
        if (s.length() ==0 ) return true;
        boolean res = false;
        for (int i=0; i < s.length()-1; i++) {
            if (t.indexOf(s.charAt(i)) < 0) return false;
            else if ( t.indexOf(s.charAt(i)) > t.indexOf(s.charAt(i+1)) ) return false;
            res = true;
        }
        return res;
    }*/


    // two pointer
    // Runtime: 1 ms, faster than 83.83% of Java online submissions for Is Subsequence.
    //Memory Usage: 37.3 MB, less than 57.83% of Java online submissions for Is Subsequence.
    
    public boolean isSubsequence(String s, String t) {
        //if (s.length() ==0 ) return true;
        int i = 0, j = 0;
        int x = s.length(), y = t.length();
        while( i < x && j <y) {
            if (s.charAt(i) == t.charAt(j)) i++;
            else j++;
        }
        return i == x;
    }


    public static void main(String[] args) {
        String s  = "aaaaaa"; // ""
        String t = "bbaaaa";  // ahbgdc and ahgdcb
        IsSubsequence solution = new IsSubsequence();
        boolean result = solution.isSubsequence(s, t);

        System.out.printf("s: %s  and t: %s isSubsequence %s \n",
                s,t, result);
    }

}
