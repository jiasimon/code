package com.sjia.hackerRank;

public class Abbreviation {
    // https://www.hackerrank.com/challenges/abbr/problem?isFullScreen=true&h_l=interview&playlist_slugs[]=interview-preparation-kit&playlist_slugs[]=dynamic-programming

    /*
    Given two strings, a and b,
    Capitalize zero or more of a 's lowercase letters.
    Delete all of the remaining lowercase letters in a.

     */


    public static String abbreviation_failed(String a, String b) {
        // Write your code here
        if (a.length() < b.length()) return "NO";
        int p1 = 0, p2=0;
        while (p1 < a.length() && p2 < b.length() ) {
            if (a.charAt(p1) == b.charAt(p2) ||
                    Character.toUpperCase(a.charAt(p1)) == b.charAt(p2)  ) {
                p1++;
                p2++;
            } else if ( Character.isLowerCase(a.charAt(p1)) ) {
                p1++;
            } else {
                return "NO";
            }
        }
        if (p2 == b.length() ) {
            while (p1 < a.length()) {
                if ( Character.isUpperCase(a.charAt(p1)) ) return "NO";
                p1++;
            }
            return "YES";
        }
        return "NO";

    }


    static String abbreviation_dp_failed(String a, String b) {
        int n = a.length();
        int m = b.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0 && Character.isUpperCase(a.charAt(i - 1))) {
                    dp[i][j] |= dp[i - 1][j] && a.charAt(i - 1) == b.charAt(j);
                }
                if (i > 0) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (i > 0 && j > 0) {
                    dp[i][j] |= dp[i - 1][j - 1] && Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1);
                }
            }
        }

        return dp[n][m] ? "YES" : "NO";
    }







    public static void main(String[] args) {
        String a ="AbcBDE";
        String b ="ABDE";
        System.out.println(abbreviation_dp_failed(a,b));

        a ="KXzQ";
        b ="K";
        System.out.println(abbreviation_dp_failed(a,b));



    }


}
