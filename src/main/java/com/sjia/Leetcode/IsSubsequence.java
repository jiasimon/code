package com.sjia.Leetcode;

public class IsSubsequence {
    // #392. Is Subsequence https://leetcode.com/problems/is-subsequence/

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
    //
    public boolean isSubsequence2(String s, String t) {
        if (s.length() ==0 ) return true;

        int i = 0, j = 0;
        int x = s.length(), y = t.length();
        while( i < x && j <y) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == x;
    }


    // two pointer, return sIndex == s.length()
    // 1 ms, 89.72%; 40.3 MB, 79.24%
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int sIndex=0, tIndex=0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == s.length();
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
