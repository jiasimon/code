package com.sjia.hackerRank2026;

public class FunnyString {
    // https://www.hackerrank.com/challenges/funny-string/problem?isFullScreen=true

    // Failed on "uwa" s = "uwa", diffs: |w-u|=2, |a-w|=22 → diff array [2, 22]
    // reverse diff array [22, 2]

    public static String funnyString_incorrect(String s) {
        // Write your code here
        StringBuffer diff_sb = new StringBuffer();
        for (int i=0; i< s.length()-1; i++) {
            diff_sb.append(Math.abs(s.charAt(i+1)-s.charAt(i)));
        }

        StringBuffer reverse_sb = new StringBuffer();
        for (int i=s.length()-1; i > 0; i--) {
            reverse_sb.append(Math.abs(s.charAt(i)-s.charAt(i-1)));
        }

        if(diff_sb.toString().equals(reverse_sb.toString()) ) {
            return "Funny";
        } else {
            return "Not Funny";
        }
    }

    public static String funnyString(String s) {
        int n = s.length();
        for (int i=1; i<n ; i++) {
            int diff = Math.abs(s.charAt(i) - s.charAt(i - 1));
            int reverseDiff = Math.abs(s.charAt(n-i) - s.charAt(n-i-1));
            if(diff != reverseDiff) return "Not Funny";
        }
        return "Funny";
    }
    

}
